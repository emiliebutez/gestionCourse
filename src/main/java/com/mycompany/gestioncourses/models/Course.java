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
@ToString
public class Course extends Model {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Edition> editions;
    
    public void addEdition(Edition edition){
        this.editions.add(edition);
    }
    
    
}
