package com.mycompany.gestioncourses.services;

public class ParticipationService {
    private static ParticipationService INSTANCE;

    public synchronized static ParticipationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParticipationService();
        }

        return INSTANCE;
    }

    private ParticipationService() {

    }
}
