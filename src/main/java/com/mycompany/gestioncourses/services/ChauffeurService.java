package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Chauffeur;

public class ChauffeurService {
    private static ChauffeurService INSTANCE;

    public synchronized static ChauffeurService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChauffeurService();
        }

        return INSTANCE;
    }

    private ChauffeurService() {

    }

    public Chauffeur creerChauffeur(String nom, String prenom, Integer numPermis) {
        Chauffeur chauffeur = new Chauffeur(null, nom, prenom, numPermis);
        chauffeur.save();

        return chauffeur;
    }
}
