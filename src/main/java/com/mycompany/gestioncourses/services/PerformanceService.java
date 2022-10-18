package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.models.Participation;
import com.mycompany.gestioncourses.models.Performance;

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

    public Performance creerPerformance(Participation participation, Etape etape, float temps, int pointsSprint, int pointGrimp) {
        Performance performance = new Performance(null, temps, pointsSprint, pointGrimp, participation, etape);
        performance.save();
        participation.refresh();
        etape.refresh();

        return performance;
    }

    public Performance ajouterPointsSprint(Performance performance, int pointsSprint) {
        performance.setPointsSprint(performance.getPointsSprint() + pointsSprint);
        performance.save();

        return performance;
    }

    public Performance ajouterPointsGrimp(Performance performance, int pointsGrimp) {
        performance.setPointsGrimp(performance.getPointsGrimp() + pointsGrimp);
        performance.save();

        return performance;
    }

    public Performance ajouterTemps(Performance performance, float delta) {
        performance.setTemps(performance.getTemps() + delta);
        performance.save();

        return performance;
    }

}
