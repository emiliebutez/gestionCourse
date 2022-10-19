package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etape extends Model {
    @Id
    @GeneratedValue @NotNull
    private Integer id;

    private String villeDepart;
    private String villeArrivee;
    private String paysDepart;
    private String paysArrivee;
    private float distance;
    private int numOrdre;
    private EtatEtape etatEtape;

    @ManyToOne
    private Edition edition;
    @OneToMany
    private List<Performance> performances;
    private int nbSprint;
    private int nbCol;
}
