package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.*;

import java.util.Collections;

public class ParticipationEquipeService {
    private static ParticipationEquipeService INSTANCE;

    public synchronized static ParticipationEquipeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParticipationEquipeService();
        }

        return INSTANCE;
    }

    private ParticipationEquipeService() {

    }

    public ParticipationEquipe creerParticipationEquipe(Equipe equipe, Edition edition) {
        ParticipationEquipe participationEquipe = new ParticipationEquipe(
                null,
                Etat.Validee,
                Collections.emptyList(),
                equipe,
                edition,
                Collections.emptyList()
        );

        participationEquipe.save();
        equipe.refresh();
        edition.refresh();

        return participationEquipe;
    }

    public ParticipationEquipe annulerParticipation(ParticipationEquipe participationEquipe) {
        participationEquipe.setEtatParticipation(Etat.Annulee);
        participationEquipe.save();

        return participationEquipe;
    }

    public ParticipationEquipe eliminer(ParticipationEquipe participationEquipe) {
        participationEquipe.setEtatParticipation(Etat.Eliminee);
        participationEquipe.save();

        return participationEquipe;
    }

    public ParticipationEquipe supprimerParticipation(ParticipationEquipe participationEquipe, Participation participation) {
        participation.delete();
        participationEquipe.refresh();

        return participationEquipe;
    }

}
