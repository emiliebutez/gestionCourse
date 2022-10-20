package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Chauffeur;
import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.Etat;
import com.mycompany.gestioncourses.models.ParticipationEquipe;
import com.mycompany.gestioncourses.models.VehiculeAssistance;
import com.mycompany.gestioncourses.models.query.QVehiculeAssistance;
import java.util.List;

public class VehiculeService {
    private static VehiculeService INSTANCE;

    public synchronized static VehiculeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VehiculeService();
        }

        return INSTANCE;
    }

    private VehiculeService() {

    }

    public VehiculeAssistance creerVehicule(String immatriculation) {
        return creerVehicule(immatriculation, null);
    }

    public VehiculeAssistance creerVehicule(String immatriculation, Chauffeur chauffeur) {
        VehiculeAssistance vehiculeAssistance = new VehiculeAssistance(null, immatriculation, chauffeur, null);
        vehiculeAssistance.save();

        if (chauffeur != null) {
            chauffeur.refresh();
        }

        return vehiculeAssistance;
    }

    public List<VehiculeAssistance> vehiculesDiponibles() {
        return new QVehiculeAssistance().findList();
    }

}
