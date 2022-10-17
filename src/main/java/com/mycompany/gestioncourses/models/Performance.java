package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Performance extends Model {

    @Id
    @GeneratedValue
    private Integer id;
    private float temps;
    private int pointsSprint;
    private int pointsGrimp;

    @ManyToOne
    private Participation participation;

    @ManyToOne
    private Etape etape;

}
