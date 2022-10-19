package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.*;
import static com.mycompany.gestioncourses.models.query.QEtape.Alias.edition;
import com.mycompany.gestioncourses.models.query.QParticipation;
import com.mycompany.gestioncourses.models.query.QParticipationEquipe;
import lombok.val;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class EditionService {

    private static final int AGE_MAX_JEUNE = 25;

    private static EditionService INSTANCE;
    public synchronized static EditionService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EditionService();
        }

        return INSTANCE;
    }

    private EditionService() {

    }

    public Edition annulerEdition(Edition edition) {
        edition.setAnnulee(true);
        edition.save();
        return edition;
    }
    
    public Etape ajouterEtape(Edition edition, String villeDepart, 
            String villeArrivee, String paysDepart, String paysArrivee, 
            float distance) {
        
        edition.refresh();
        int nbEtape = edition.getEtapes().size();
        Etape etape = new Etape(null, villeDepart, villeArrivee, paysDepart, paysArrivee, distance, nbEtape + 1, EtatEtape.Attente, edition, Collections.emptyList());
        etape.save();
        edition.refresh();
        return etape;
    }

    public List<Participation> participationsEdition(Edition edition) {
        return new QParticipationEquipe()
                .edition.eq(edition)
                .findStream()
                .flatMap(pe -> pe.getParticipation().stream())
                .collect(Collectors.toList());
    }

    public List<Participation> participationsEditionJeunes(Edition edition) {
        return new QParticipationEquipe()
                .edition.eq(edition)
                .findStream()
                .flatMap(pe -> pe.getParticipation().stream())
                .filter(p -> p.getCoureur().getDateNaissance().before(
                        Date.from(Instant.now().minus(25, ChronoUnit.YEARS))
                ))
                .collect(Collectors.toList());
    }

    public Optional<Coureur> meilleurJeune(Edition edition) {
        val participationsParCoureur = participationsEditionJeunes(edition)
                .stream()
                .collect(groupingBy(Participation::getCoureur)); // On regroupe par coureur

        val performances = participationsParCoureur
                .entrySet()
                .stream()
                .collect( // On modifie la Map pour avoir une Map<Coureur, Float> où Int est la somme des performances
                        toMap(
                                Map.Entry::getKey,
                                entry -> calculerSommeTemps(entry.getValue(), Performance::getTemps)
                        )
                );

        return meilleurTemps(performances); // On récupère le coureur
    }

    private Optional<Coureur> meilleurTemps(Map<Coureur, Float> participations) {
        return participations.entrySet().stream()
                .min(Map.Entry.comparingByValue())  // Maximum par les points
                .map(Map.Entry::getKey);            // Récupération du coureur
    }

    public Optional<Coureur> meilleurGrimpeur(Edition edition) {
        return meilleurCoureur(participationsEdition(edition), Performance::getPointsGrimp);
    }

    public Optional<Coureur> meilleurSprinteur(Edition edition) {
        return meilleurCoureur(participationsEdition(edition), Performance::getPointsSprint);
    }

    private Optional<Coureur> meilleurCoureur(List<Participation> participations, Function<Performance, Integer> critere) {
        val participationsParCoureur = participations
                .stream()
                .collect(groupingBy(Participation::getCoureur)); // On regroupe par coureur

        val performances = participationsParCoureur
                .entrySet()
                .stream()
                .collect( // On modifie la Map pour avoir une Map<Coureur, Int> où Int est la somme des performances
                        toMap(
                                Map.Entry::getKey,
                                entry -> calculerPerformance(entry.getValue(), critere)
                        )
                );

        return meilleurePerformance(performances); // On récupère le coureur
    }

    private Optional<Coureur> meilleurePerformance(Map<Coureur, Integer> participations) {
        return participations.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // Maximum par les points
                .map(Map.Entry::getKey);            // Récupération du coureur
    }

    private int calculerPerformance(List<Participation> participations, Function<Performance, Integer> critere) {
        return participations.stream()
                .flatMap(f -> f.getPerformances().stream()) // On aplatis la liste des performances
                .map(critere)                               // On récupère le critère qui nous intéresse
                .reduce(Integer::sum)                       // Somme des performances pour le critère donné
                .orElse(0);                           // Si aucun perf, alors 0
    }

    private float calculerSommeTemps(List<Participation> participations, Function<Performance, Float> critere) {
        return participations.stream()
                .flatMap(f -> f.getPerformances().stream()) // On aplatis la liste des performances
                .map(critere)                               // On récupère le critère qui nous intéresse
                .reduce(Float::sum)                         // Somme des performances pour le critère donné
                .orElse(0f);                          // Si aucun perf, alors 0
    }

    public boolean estInscrit(Edition value, Equipe equipe) {
        if (value == null || equipe == null) {
            return false;
        }
        
        QParticipationEquipe qParticipation = new QParticipationEquipe();
        
        return qParticipation
                .edition.eq(value)
                .equipe.eq(equipe)
                .exists();
    }

}
