package com.mycompany.gestioncourses.services;

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
}
