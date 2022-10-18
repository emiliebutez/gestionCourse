package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToMany
    private ArrayList<Etape>etapes;

    @OneToMany
    private ArrayList<Participation> participations;

    @OneToMany
    private ArrayList<ParticipationEquipe> participationEquipes;

    @ManyToOne
    private Course course;

    public Edition(Integer id, int annee, Date dateDebut, Date dateFin, String villeDepart, String villeArrivee, String paysDepart, String paysArrivee, float distance, boolean annulee){
        this.id = id;
        this.annee = annee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.paysDepart = paysDepart;
        this.paysArrivee = paysArrivee;
        this.distance = distance;
        this.annulee = annulee;
        this.etapes = new ArrayList<Etape>();
        this.participations = new ArrayList<Participation>();
        this.participationEquipes = new ArrayList<ParticipationEquipe>();
        this.course = course;
    }
    
   
    public void ajouterEtape(Etape etape) {
        this.etapes.add(etape);
    }

//    public ArrayList<Equipe>classementEquipe() {
//       return etapes;
//    }
//    
//    public ArrayList<Equipe>classementGeneral() {
//       return 0;
//    }
    
    public void afficherCoureurs(){
          Iterator iter = participations.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    
    public void afficherEquipes(){
        Iterator iter = participationEquipes.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    
    public void afficherEtapes(){
       Iterator iter = etapes.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        } 
    }
    
    public void modifierInformations(int annee, Date dateDebut , Date dateFin, String villeDepart, String villeArrivee, String paysArrivee, String paysDepart){
        this.annee = annee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.paysArrivee = paysArrivee;
        this.paysDepart = paysDepart;   
    }
    
    public boolean annulerEdition(){
        return this.annulee = true;
    }
    
    public void afficherInformations(){
        System.out.println("Année :"+this.annee);
        System.out.println("Ville de départ: "+this.villeDepart);
        System.out.println("Ville d'arrivée: "+this.villeArrivee);
        System.out.println("Date de début: "+this.dateDebut);
        System.out.println("Date de fin : "+this.dateFin);
        System.out.println("Pays de départ : "+this.paysDepart);
        System.out.println("Pays d'arrivée : "+this.paysArrivee);        
    }
    
//    public Coureur recupererMeilleurSprinteur(){
//        
//    }
//    
//    public Coureur recupererMeilleurGrimpeur(){
//        
//    }
//    
//    public Coureur recupererMeilleurJeune(){
//        
//    }
//    
//    public float tempsMoyenCoureur(){
//        
//    }
    
    
    
    public void afficherPlusLongueCourse(){
       
    }

    
}
