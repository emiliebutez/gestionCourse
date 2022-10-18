package com.mycompany.gestioncourses.services;

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
}
