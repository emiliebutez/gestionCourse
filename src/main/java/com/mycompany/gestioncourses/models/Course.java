package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
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
public class Course extends Model implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Edition> editions;

    public String afficherNom(){
        return this.nom;
    }

    public Course(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
        //this.editions = new List<Edition>();
    }

    public void afficherEdition(Edition edition){
       for(int i=0;i<this.editions.size();i++){
        if(this.editions.get(i) == edition){
            System.out.println("Année : "+edition.getAnnee());
            System.out.println("Date de début : "+edition.getDateDebut());
            System.out.println("Date de fin : "+edition.getDateFin());
        }
      }
    }

    public void afficherListEdition(){
        for(Edition e : editions){
            System.out.println(e.getId()+"\t"+e.getAnnee()+"\t"+e.getDateDebut()+"\t"+e.getDateFin()+"\t"+e.getPaysDepart()+"\t"+e.getPaysArrivee()+"\t"+e.getDistance());
        }
    }

    public void rechercherCourse(String nomCourse){
        //this.editions.contains(nomCourse);
    }

    public List<Edition>recupererListesEditions(){
         Iterator iter = editions.iterator();
         List<Edition>list = new ArrayList<>();
        while (iter.hasNext()){
            list.add((Edition) iter.next());
        }
        return list;
    }

    public void addEdition(Edition edition){
        this.editions.add(edition);
    }
}
