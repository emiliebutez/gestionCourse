package com.mycompany.gestioncourses.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue
    private Integer id;

    private String nomResponsable;
    private String prenomResponsable;
    private String mailResponsable;
    private String telResponsable;
    private String nationnalite;
    private String nomEquipe;

    @OneToMany
    private List<ParticipationEquipe> participations;
}
