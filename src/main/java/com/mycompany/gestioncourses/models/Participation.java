package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participation extends Model {
    @Id
    @GeneratedValue
    private Integer numInscription;
    private Etat etatParticipation;
    @OneToMany
    private List<Performance> performances;
    @ManyToOne
    private ParticipationEquipe participationEquipe;
    @ManyToOne
    private Coureur coureur;

    public void annulerParticipation() {
        this.etatParticipation = Etat.Annulee;
    }

    public void eliminerParticipant() {
        this.etatParticipation = Etat.Eliminee;
    }
}
