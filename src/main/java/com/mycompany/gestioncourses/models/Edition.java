package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edition extends Model {
    @Id
    @GeneratedValue
    private Integer id;

    private int annee;
    private Date dateDebut;
    private Date dateFin;
    private String villeDepart;
    private String villeArrivee;
    private String paysDepart;
    private String paysArrivee;
    private float distance;
    private boolean annulee;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Etape> etapes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ParticipationEquipe> participationEquipes;

    @ManyToOne(optional = false)
    private Course course;

    public void ajouterEtape(Etape etape) {
        this.etapes.add(etape);
    }

    public List<Equipe> classementEquipe() {
        throw new IllegalStateException("classement équipe non implémenté");
    }

}
