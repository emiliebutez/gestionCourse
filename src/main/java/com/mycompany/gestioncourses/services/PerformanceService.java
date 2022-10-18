package com.mycompany.gestioncourses.services;

public class PerformanceService {
    private static PerformanceService INSTANCE;

    public synchronized static PerformanceService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PerformanceService();
        }

        return INSTANCE;
    }

    private PerformanceService() {

    }
}
