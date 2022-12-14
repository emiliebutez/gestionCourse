package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.*;
import static com.mycompany.gestioncourses.models.Etat.Eliminee;
import static com.mycompany.gestioncourses.models.query.QEtape.Alias.edition;
import com.mycompany.gestioncourses.models.query.QParticipation;
import com.mycompany.gestioncourses.models.query.QParticipationEquipe;
import com.mycompany.gestioncourses.models.query.QPerformance;
import lombok.val;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap;
import java.util.Calendar;
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
    
    public boolean participationEdition(Edition edition, Coureur coureur) {
        return new QParticipation()
                .participationEquipe.edition.eq(edition)
                .coureur.eq(coureur)
                .exists();
    }

    public Edition annulerEdition(Edition edition) {
        edition.setAnnulee(true);
        edition.save();
        return edition;
    }
    
    public Etape ajouterEtape(Edition edition, String villeDepart, 
            String villeArrivee, String paysDepart, String paysArrivee, 
            float distance, int nbSprint, int nbCol) {
        
        edition.refresh();
        int nbEtape = edition.getEtapes().size();
        Etape etape = new Etape(null, villeDepart, villeArrivee, paysDepart,
                paysArrivee, distance, nbEtape + 1, EtatEtape.Attente, 
                edition, Collections.emptyList(), nbSprint, nbCol);
        etape.save();
        edition.refresh();
        
        edition.setDistance(distance + edition.getDistance());
        edition.save();
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -AGE_MAX_JEUNE);
        Date yearsAgo25 = cal.getTime();
        return new QParticipationEquipe()
                .edition.eq(edition)
                .findStream()
                .flatMap(pe -> pe.getParticipation().stream())
                .filter(p -> p.getCoureur().getDateNaissance().after(yearsAgo25))
                .collect(Collectors.toList());
    }

    public Optional<Coureur> meilleurJeune(Edition edition) {
        val participationsParCoureur = participationsEditionJeunes(edition)
                .stream()
                .filter(p -> p.getEtatParticipation()!= Eliminee)
                .collect(groupingBy(Participation::getCoureur)); // On regroupe par coureur

        val performances = participationsParCoureur
                .entrySet()
                .stream()
                .collect( // On modifie la Map pour avoir une Map<Coureur, Float> o?? Int est la somme des performances
                        toMap(
                                Map.Entry::getKey,
                                entry -> calculerSommeTemps(entry.getValue(), Performance::getTemps)
                        )
                );

        return meilleurTemps(performances); // On r??cup??re le coureur
    }

    private Optional<Coureur> meilleurTemps(Map<Coureur, Float> participations) {
        return participations.entrySet().stream()
                .min(Map.Entry.comparingByValue())  // Maximum par les points
                .map(Map.Entry::getKey);            // R??cup??ration du coureur
    }

    public Optional<Coureur> meilleurGrimpeur(Edition edition) {
        return meilleurCoureur(participationsEdition(edition), Performance::getPointsGrimp);
    }

    public Optional<Coureur> meilleurSprinteur(Edition edition) {
        return meilleurCoureur(participationsEdition(edition), Performance::getPointsSprint);
    }

    private Optional<Coureur> meilleurCoureur(List<Participation> participations, Function<Performance, Integer> critere) {
        Map<Coureur, List<Participation>> participationsParCoureur = participations
                .stream()
                .filter(p -> p.getEtatParticipation()!= Eliminee)
                .collect(groupingBy(Participation::getCoureur)); // On regroupe par coureur

        val performances = participationsParCoureur
                .entrySet()
                .stream()
                .collect( // On modifie la Map pour avoir une Map<Coureur, Int> o?? Int est la somme des performances
                        toMap(
                                Map.Entry::getKey,
                                entry -> calculerPerformance(entry.getValue(), critere)
                        )
                );

        return meilleurePerformance(performances); // On r??cup??re le coureur
    }

    private Optional<Coureur> meilleurePerformance(Map<Coureur, Integer> participations) {
        return participations.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // Maximum par les points
                .map(Map.Entry::getKey);            // R??cup??ration du coureur
    }

    private int calculerPerformance(List<Participation> participations, Function<Performance, Integer> critere) {
        return participations.stream()
                .flatMap(f -> f.getPerformances().stream()) // On aplatis la liste des performances
                .map(critere)                               // On r??cup??re le crit??re qui nous int??resse
                .reduce(Integer::sum)                       // Somme des performances pour le crit??re donn??
                .orElse(0);                           // Si aucun perf, alors 0
    }

    private float calculerSommeTemps(List<Participation> participations, Function<Performance, Float> critere) {
        return participations.stream()
                .flatMap(f -> f.getPerformances().stream()) // On aplatis la liste des performances
                .map(critere)                               // On r??cup??re le crit??re qui nous int??resse
                .reduce(Float::sum)                         // Somme des performances pour le crit??re donn??
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
    
    
    public List<Coureur> classementGeneralEtape(Etape etape){
        Map <Coureur, List<Performance>> performances = new QPerformance().etape.eq(etape)
                .findStream()
                .collect(Collectors.groupingBy(
                        p -> p.getParticipation().getCoureur())
                );
        
        return performances.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                        entry.getKey(),
                        entry.getValue().stream()
                            .map(Performance::getTemps)
                            .reduce(Float::sum)
                            .orElse(0f)
                ))
                .sorted((entryA, entryB) -> entryA.getValue().compareTo(entryB.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
    
    public List<Equipe> classementGeneralEtapeParEquipe(Etape etape){
        Map <Equipe, List<Performance>> performances = new QPerformance().etape.eq(etape)
                .findStream()
                .collect(Collectors.groupingBy(
                        p -> p.getParticipation().getParticipationEquipe().getEquipe())
                );
        
        return performances.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                        entry.getKey(),
                        entry.getValue().stream()
                            .map(Performance::getTemps)
                            .reduce(Float::sum)
                            .orElse(0f)
                ))
                .sorted((entryA, entryB) -> entryA.getValue().compareTo(entryB.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
    
    public List<Coureur> classementGeneralEdition(Edition edition){
        Map <Coureur, List<Performance>> performances = new QPerformance().etape.edition.eq(edition)
                .findStream()
                .collect(Collectors.groupingBy(
                        p -> p.getParticipation().getCoureur())
                );
        
        return performances.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                        entry.getKey(),
                        entry.getValue().stream()
                            .map(Performance::getTemps)
                            .reduce(Float::sum)
                            .orElse(0f)
                ))
                .sorted((entryA, entryB) -> entryA.getValue().compareTo(entryB.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
    
    public List<Equipe> classementGeneralEditionParEquipe(Edition edition){
        Map <Equipe, List<Performance>> performances = new QPerformance().etape.edition.eq(edition)
                .findStream()
                .collect(Collectors.groupingBy(
                        p -> p.getParticipation().getParticipationEquipe().getEquipe())
                );
        
        return performances.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                        entry.getKey(),
                        entry.getValue().stream()
                            .map(Performance::getTemps)
                            .reduce(Float::sum)
                            .orElse(0f)
                ))
                .sorted((entryA, entryB) -> entryA.getValue().compareTo(entryB.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

}
