package com.mycompany.gestioncourses.models;

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
public class VehiculeAssistance {
    @Id
    @GeneratedValue
    private Integer id;

    private String immatriculation;
    @ManyToOne
    private Chauffeur chauffeur;
    @ManyToOne
    private ParticipationEquipe participationEquipe;
}
