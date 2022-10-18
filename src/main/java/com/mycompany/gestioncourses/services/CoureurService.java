package com.mycompany.gestioncourses.services;

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

}
