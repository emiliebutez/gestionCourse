package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.ParticipationEquipe;
import com.mycompany.gestioncourses.models.query.QCourse;
import com.mycompany.gestioncourses.models.query.QEdition;
import com.mycompany.gestioncourses.models.query.QEquipe;
import com.mycompany.gestioncourses.models.query.QParticipation;
import com.mycompany.gestioncourses.models.query.QParticipationEquipe;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EquipeService {
    private static EquipeService INSTANCE;
    private CourseService courseService = CourseService.getInstance();


    public synchronized static EquipeService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EquipeService();
        }

        return INSTANCE;
    }

    private EquipeService() {

    }

    public Equipe creerEquipe(String nomResponsable, String prenomResponsable, String mailResponsable, String telResponsable, String nationalite, String nomEquipe) {
        Equipe equipe = new Equipe(null, nomResponsable, prenomResponsable, mailResponsable, telResponsable, nationalite, nomEquipe, Collections.emptyList());
        equipe.save();

        return equipe;
    }
    
    public List<Equipe> equipes() {
        return new QEquipe().findList();
    }
    
    public List<Course> TrouverParticipationCourseEquipe(Equipe equipe){
        return new QCourse().editions.participationEquipes.equipe.eq(equipe).findList();
    }
    
    public List<Edition> TrouverParticipationEditionEquipe(Equipe equipe){
        return new QEdition().participationEquipes.equipe.eq(equipe).findList();
    }
}
