package com.mycompany.gestioncourses.services;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.query.QCourse;
import lombok.Singleton;
import lombok.val;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class CourseService {

    private static CourseService INSTANCE;
    public synchronized static CourseService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CourseService();
        }

        return INSTANCE;
    }

    public Course creerCourse(String nom) {
        val course = new Course(null, nom, Collections.emptyList());
        course.save();
        return course;
    }
    
    public Map<String, Course> coursesParNom() {
        HashMap<String, Course> res = new HashMap<>();
        new QCourse()
                .findStream()
                .forEach(c -> res.put(c.getNom(), c));
        return res;
    }

    public List<Course> rechercherCourse(String nom) {
        return new QCourse()
                .nom.icontains(nom)
                .findList();
    }

    public Optional<Course> courseParId(Integer id) {
        return new QCourse()
                .id.eq(id)
                .findOneOrEmpty();
    }

    public Edition creerEdition(Course course, int annee, Date dateDebut, Date dateFin, String depart, String arrivee, String paysDepart, String paysArrivee) {
        Edition edition = new Edition(
                null,
                annee,
                dateDebut,
                dateFin,
                depart,
                arrivee,
                paysDepart,
                paysArrivee,
                0f,
                false,
                emptyList(),
                emptyList(),
                emptyList(),
                course
        );
        
        edition.save();
        course.refresh();

        return edition;
    }

}
