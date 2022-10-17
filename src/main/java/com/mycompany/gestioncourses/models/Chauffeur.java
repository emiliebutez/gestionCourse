package com.mycompany.gestioncourses.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chauffeur {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String prenom;
    private int numPermis;
}
