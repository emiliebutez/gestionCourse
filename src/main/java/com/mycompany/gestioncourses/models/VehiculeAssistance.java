package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeAssistance extends Model {
    @Id
    @GeneratedValue
    private Integer id;

    private String immatriculation;
    @ManyToOne
    private Chauffeur chauffeur;
    @ManyToOne
    private ParticipationEquipe participationEquipe;
}
