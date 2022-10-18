package com.mycompany.gestioncourses.services;

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
}
