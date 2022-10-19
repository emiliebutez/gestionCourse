package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.query.QEquipe;

import java.util.Collections;
import java.util.List;

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
    
    public List<Equipe> equipes() {
        return new QEquipe().findList();
    }
}
