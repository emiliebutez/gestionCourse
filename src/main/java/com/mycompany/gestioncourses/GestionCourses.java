/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gestioncourses;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.models.EtatEtape;
import com.mycompany.gestioncourses.models.query.QCourse;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.DbMigration;
import lombok.val;
import lombok.var;

import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author Emilie
 */
public class GestionCourses {
    public static void main(String[] args) {
           Date date1 = new Date(2022, 10, 12);
           Date date2 = new Date(2022, 11, 12);
           Date date3 = new Date(2022, 12, 12);
           
           //Creation d'une course
            System.out.println("-----------------------------------------------------------");
            System.out.println("CREATION D'UNE COURSE");
            System.out.println("-----------------------------------------------------------");

           Course c1 = new Course(1,"Tour de France");
           Course c2 = new Course(2,"Championnat de France");
           System.out.println("Le nom de la course est : "+c1.afficherNom());
           System.out.println("Le nom de la course est : "+c2.afficherNom());

//            System.out.println("-----------------------------------------------------------");
//            System.out.println("CREATION DES EDITIONS");
//            System.out.println("-----------------------------------------------------------");

           //Creation des editions de la course
           Edition e1 = new Edition(1,2022,date1 ,date2 , "Paris", "Lille", "France", "France",  15, false);
           Edition e2 = new Edition(2,2023,date2,date3, "Monaco", "Marseille", "France", "France",  10, false);
           Edition ed1 = new Edition(3,2022,date1 ,date2 , "Toulouse", "Monaco", "France", "France",  15, false);
           Edition ed2 = new Edition(4,2023,date2,date3, "Toulouse", "Monaco", "France", "France",  10, false);
           
            System.out.println("-----------------------------------------------------------");
            System.out.println("LISTE DES EDITIONS D'UNE COURSE");
            System.out.println("-----------------------------------------------------------");

           //Ajouter les editions a la course
           
           c1.ajouterEdition(e1);
           c1.ajouterEdition(e2);
           c2.ajouterEdition(ed1);
           c2.ajouterEdition(ed2);
           //Afficher les editions de la course
           System.out.println("---------------COURSE 1--------------------");
           c1.afficherListEdition();
           System.out.println("---------------COURSE 2--------------------");
           c2.afficherListEdition();
           
           System.out.println("-----------------------------------------------------------");
           System.out.println("LISTE DES ETAPES DE LA COURSE 1 EDITION 1");
           System.out.println("-----------------------------------------------------------");
           //Creation d'une etape
           Etape etape1 = new Etape(1, "Paris", "Lyon", "France", "France", 10, 1, EtatEtape.Attente);
           Etape etape2 = new Etape(2, "Lyon", "Nice", "France", "France", 10, 2, EtatEtape.Attente);
           Etape etape3 = new Etape(3, "Nice", "Marseille", "France", "France", 10, 3, EtatEtape.Attente);
           Etape etape4 = new Etape(4, "Marseille", "Strasbourg", "France", "France", 10, 4, EtatEtape.Attente);
           Etape etape5 = new Etape(5, "Strasbourg", "Toulouse", "France", "France", 10, 5, EtatEtape.Attente);
           Etape etape6 = new Etape(6, "Toulouse", "Bordeaux", "France", "France", 10, 6, EtatEtape.Attente);
           Etape etape7 = new Etape(7, "Bordeaux", "Nantes", "France", "France", 10, 7, EtatEtape.Attente);
           Etape etape8 = new Etape(8, "Nantes", "Lille", "France", "France", 10, 8, EtatEtape.Attente);

           //Affectation de l'etape a la course
           e1.ajouterEtape(etape1);
           e1.ajouterEtape(etape2);
           e1.ajouterEtape(etape3);
           e1.ajouterEtape(etape4);
           e1.ajouterEtape(etape5);
           e1.ajouterEtape(etape6);
           e1.ajouterEtape(etape7);
           e1.ajouterEtape(etape8);
          
           //Afficher l'etape de l'edition
           e1.afficherEtapes();
           
           System.out.println("-----------------------------------------------------------");
           System.out.println("LISTE DES ETAPES DE LA COURSE 1 EDITION 2");
           System.out.println("-----------------------------------------------------------");
         
           //Affectation de l'etape a la course
           e2.ajouterEtape(etape1);
           e2.ajouterEtape(etape2);
           e2.ajouterEtape(etape3);
           e2.ajouterEtape(etape4);
           e2.ajouterEtape(etape5);
           e2.ajouterEtape(etape6);
           e2.ajouterEtape(etape7);
           e2.ajouterEtape(etape8);
          
           //Afficher l'etape de l'edition
           e2.afficherEtapes();
           
           
//        Database db = DB.getDefault();
//        var course = new Course(null, "CastràToulouse", Collections.emptyList());
//        course.save();
//
//        var edition = new Edition(
//                null,
//                2022,
//                Date.valueOf("2022-10-17"),
//                Date.valueOf("2022-10-18"),
//                "Castres",
//                "Toulouse",
//                "France",
//                "France",
//                0,
//                false,
//                Collections.emptyList(),
//                Collections.emptyList(),
//                Collections.emptyList(),
//                course
//        );
//        edition.save();
//
//        System.out.println(new QCourse().findList().stream().map(c -> c.getEditions().stream().map(e -> e.getId()).collect(Collectors.toList())).collect(Collectors.toList()));
//    }
}

   
}
