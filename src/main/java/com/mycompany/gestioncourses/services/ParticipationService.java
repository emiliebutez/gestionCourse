package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.*;

import java.util.Collections;

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

    public Participation creerParticipation(Edition edition, Coureur coureur, Equipe equipe) {
        Participation participation = new Participation(
                null,
                Etat.Validee,
                Collections.emptyList(),
                edition,
                coureur,
                equipe
        );

        participation.save();
        edition.refresh();
        coureur.refresh();
        equipe.refresh();

        return participation;
    }

    public Participation changerEquipeParticipation(Participation participation, Equipe equipe) {
        Equipe ancienne = participation.getEquipe();

        participation.setEquipe(equipe);
        participation.save();

        ancienne.refresh();
        equipe.refresh();

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
        participation.getEdition().refresh();

        return participation;
    }

}
