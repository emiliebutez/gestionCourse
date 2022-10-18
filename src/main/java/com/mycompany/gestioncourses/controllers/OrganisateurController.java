/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncourses.controllers;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.query.QCourse;
import com.mycompany.gestioncourses.views.organisateur.CreationCoursePanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author Emilie
 */
public class OrganisateurController {
    
    public OrganisateurController() {
    }
    
    public void ajouterCourse(String nom){
        Course course = new Course(null, nom, Collections.emptyList());
        course.save();
    }
    
    public String afficherCourse() {
        Course course = new QCourse().findOne();
        return String.valueOf(course.getId());
    }
    
    public String afficherEditions(Course course) {
        ArrayList<Edition> editions = (ArrayList<Edition>) course.getEditions();
        String informationsEdition = "";
        
        for (Edition edition : editions) {
            informationsEdition += edition.getPaysDepart() + " "+ edition.getPaysArrivee() + edition.getVilleArrivee() + edition.getVilleDepart();
        }
        
        return informationsEdition;
    }
}
