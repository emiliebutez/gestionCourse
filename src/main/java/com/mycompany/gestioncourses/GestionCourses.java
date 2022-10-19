/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gestioncourses;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
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
        Database db = DB.getDefault();
        var course = new Course(null, "CastràToulouse", Collections.emptyList());
        course.save();

        var edition = new Edition(
                null,
                2022,
                Date.valueOf("2022-10-17"),
                Date.valueOf("2022-10-18"),
                "Castres",
                "Toulouse",
                "France",
                "France",
                0,
                false,
                Collections.emptyList(),
                Collections.emptyList(),
                course
        );
        edition.save();
       
        Course courseBis = new QCourse().id.equalTo(1).findOne();
        System.out.println(courseBis.getNom());
        
        System.out.println("hey");
    }
}
