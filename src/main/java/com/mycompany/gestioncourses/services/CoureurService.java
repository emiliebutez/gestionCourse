package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Coureur;
import com.mycompany.gestioncourses.models.query.QCoureur;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CoureurService {
    private static CoureurService INSTANCE;

    public synchronized static CoureurService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CoureurService();
        }

        return INSTANCE;
    }

    private CoureurService() {

    }

    public Coureur creerCoureur(String nom, String prenom, Date dateNaissance, String groupeSanguin) {
        Coureur coureur = new Coureur(null, nom, prenom, dateNaissance, groupeSanguin, Collections.emptyList());
        coureur.save();
        return coureur;
    }

    public List<Coureur> rechercherCoureur(String nom, String prenom) {
        return new QCoureur()
                .nom.icontains(nom)
                .prenom.icontains(prenom)
                .findList();
    }
    
    public List<Coureur> coureurs() {
        return new QCoureur().findList();
    }
    
    public Map<String, Coureur> coureursParNom() {
        HashMap<String, Coureur> res = new HashMap<>();
        new QCoureur()
                .findStream()
                .forEach(c -> res.put(c.getNom(), c));
        return res;
    }
}
