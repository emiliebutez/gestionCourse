package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.*;
import com.mycompany.gestioncourses.models.query.QEdition;

import com.mycompany.gestioncourses.models.query.QParticipation;
import com.mycompany.gestioncourses.models.query.QEquipe;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipationService {
    private static ParticipationService INSTANCE;

    public synchronized static ParticipationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParticipationService();
        }

        return INSTANCE;
    }

    private ParticipationService() {

    }

    public Participation creerParticipation(ParticipationEquipe participationEquipe, Coureur coureur, Equipe equipe) {
        Participation participation = new Participation(
                null,
                Etat.Validee,
                Collections.emptyList(),
                participationEquipe,
                coureur
        );

        participation.save();
        participationEquipe.refresh();
        participationEquipe.getEdition().refresh();
        coureur.refresh();
        equipe.refresh();

        return participation;
    }

    public Participation changerEquipeParticipation(Participation participation, ParticipationEquipe participationEquipe) {
        ParticipationEquipe ancienne = participation.getParticipationEquipe();

        participation.setParticipationEquipe(participationEquipe);
        participation.save();

        ancienne.refresh();
        participationEquipe.refresh();

        return participation;
    }

    public Participation eliminerParticipant(Participation participation) {
        participation.setEtatParticipation(Etat.Eliminee);
        participation.save();
        participation.getCoureur().refresh();

        return participation;
    }

    public Participation annulerParticipation(Participation participation) {
        participation.setEtatParticipation(Etat.Annulee);
        participation.save();
        participation.getCoureur().refresh();
        participation.getParticipationEquipe().refresh();

        return participation;
    }
    
    public List<Participation> participations(Edition edition) {
        return new QParticipation()
                .participationEquipe
                .edition
                .eq(edition)
                .findList();
    }
    
    public Participation trouverParticipation(Coureur coureur) {
        return new QParticipation().coureur.eq(coureur).findOne();
    }
        
    public Equipe equipeAssocierEdition(Edition edition) {
        return new QEquipe().participations.edition.eq(edition).findOne();
    }
    
    public List<Edition> editionsParticipee(Coureur coureur) {
        return new QParticipation()
                .coureur.eq(coureur)
                .findStream()
                .map(p -> p.getParticipationEquipe().getEdition())
                .collect(Collectors.toList());
    }
    
    public List<Edition> editionsParticipeeNonEliminee(Coureur coureur) {
        return new QParticipation()
                .coureur.eq(coureur)
                .etatParticipation.ne(Etat.Eliminee)
                .findStream()
                .map(p -> p.getParticipationEquipe().getEdition())
                .collect(Collectors.toList());
    }
    
    public Participation trouverParticipation(Coureur coureur, Edition edition) {
        return new QParticipation().coureur.eq(coureur)
                .participationEquipe.edition.eq(edition).findOne();
    }
}
