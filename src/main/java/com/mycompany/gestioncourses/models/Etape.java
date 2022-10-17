package com.mycompany.gestioncourses.models;

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
public class Etape {
    @Id
    @GeneratedValue
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
}
