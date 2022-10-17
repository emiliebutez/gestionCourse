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
public class Coureur extends Model {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String groupeSanguin;
    @ManyToMany
    private List<Participation> participations;
}
