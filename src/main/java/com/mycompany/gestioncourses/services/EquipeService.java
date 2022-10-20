package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Coureur;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.Etat;
import com.mycompany.gestioncourses.models.ParticipationEquipe;
import com.mycompany.gestioncourses.models.query.QCoureur;
import com.mycompany.gestioncourses.models.query.QEquipe;
import com.mycompany.gestioncourses.models.query.QParticipation;
import com.mycompany.gestioncourses.models.query.QParticipationEquipe;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EquipeService {
    private static EquipeService INSTANCE;

    public synchronized static EquipeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EquipeService();
        }

        return INSTANCE;
    }

    private EquipeService() {

    }

    public Equipe creerEquipe(String nomResponsable, String prenomResponsable, String mailResponsable, String telResponsable, String nationalite, String nomEquipe) {
        Equipe equipe = new Equipe(null, nomResponsable, prenomResponsable, mailResponsable, telResponsable, nationalite, nomEquipe, Collections.emptyList());
        equipe.save();

        return equipe;
    }
    
    public void eliminerEquipes(Edition edition){
        new QParticipationEquipe()
                .edition.eq(edition)
                .findStream()
                .filter(pe -> {
                    return pe.getParticipation().stream()
                            .filter(p -> p.getEtatParticipation() == Etat.Validee)
                            .count() > 3;
                })
                .forEach(pe -> {
                    eliminerEquipe(pe);
                });
        //this.equipesEdition(edition).forEach(e -> e.getParticipations().forEach(p -> p.getEtatParticipation().Validee).);
    }
    
    public void eliminerEquipe(ParticipationEquipe equipe) {
        equipe.setEtatParticipation(Etat.Eliminee);
    }
    
    public List<Equipe> equipesEdition(Edition edition) {
        return new QEquipe().participations.edition.eq(edition).findList();
    }
    
    public List<Equipe> equipes() {
        return new QEquipe().findList();
    }
    
    public List<Coureur> coureursEquipe(Equipe equipe, Edition edition) {
        return new QParticipation()
                .participationEquipe.equipe.eq(equipe)
                .participationEquipe.edition.eq(edition)
                .findStream()
                .map(p -> p.getCoureur())
                .collect(Collectors.toList());
    }
}
