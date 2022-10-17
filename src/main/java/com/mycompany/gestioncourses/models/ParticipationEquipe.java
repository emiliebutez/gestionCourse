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
public class ParticipationEquipe extends Model {
    @Id
    @GeneratedValue
    private Integer numInscription;
    private Etat etatParticipation;
    @ManyToMany
    private List<Coureur> coureurs;
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Edition edition;
    @OneToMany
    List<VehiculeAssistance> vehicules;
}
