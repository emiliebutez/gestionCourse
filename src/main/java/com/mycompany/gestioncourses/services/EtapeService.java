package com.mycompany.gestioncourses.services;

public class EtapeService {
    private static EtapeService INSTANCE;

    public synchronized static EtapeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EtapeService();
        }

        return INSTANCE;
    }

    private EtapeService() {

    }
}
