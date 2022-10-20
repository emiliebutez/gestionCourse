package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Chauffeur;
import com.mycompany.gestioncourses.models.VehiculeAssistance;
import com.mycompany.gestioncourses.models.query.QChauffeur;
import java.util.List;

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
    
    public List<Chauffeur> chauffeurs() {
        return new QChauffeur().findList();
    }

    public Chauffeur creerChauffeur(String nom, String prenom, Integer numPermis) {
        Chauffeur chauffeur = new Chauffeur(null, nom, prenom, numPermis);
        chauffeur.save();

        return chauffeur;
    }
    
    public void assignerVehicule(Chauffeur chauffeur, VehiculeAssistance vehiculeAssistance) {
        vehiculeAssistance.setChauffeur(chauffeur);
        vehiculeAssistance.save();
    }
}
