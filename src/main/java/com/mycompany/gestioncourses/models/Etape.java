package com.mycompany.gestioncourses.models;

import io.ebean.Model;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etape extends Model {
    @Id
    @GeneratedValue @NotNull
    private Integer id;

    private String villeDepart;
    private String villeArrivee;
    private String paysDepart;
    private String paysArrivee;
    private float distance;
    private int numOrdre;
    private EtatEtape etatEtape;

    @ManyToOne
    private Edition edition;
    @OneToMany
    private List<Performance> performances;

    public Etape(Integer id, String villeDepart, String villeArrivee, String paysDepart, String paysArrivee, float distance, int numOrdre, EtatEtape etatEtape) {
        this.id = id;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.paysDepart = paysDepart;
        this.paysArrivee = paysArrivee;
        this.distance = distance;
        this.numOrdre = numOrdre;
        this.etatEtape = EtatEtape.Attente;
        this.edition = edition;
        this.performances = performances;
    }
    
    public void etablirClassementEtape(){
        
    }
    
    public EtatEtape annulerEtape(){
        return this.etatEtape.Annulee;
    }
    
    public EtatEtape cloturerEtape(){
        return this.etatEtape.Cloturee;
    }
    
    public EtatEtape lancerEtape(){
        return this.etatEtape.Lancee;
    }
    
    public void afficherEtape(){
        
    }
    
//    public float tempsMoyenCoureurEtape(){
//        
//    }
    
    public void recupererDistance(){
        
    }

    @Override
    public String toString() {
        return "Etape" + numOrdre + " : " + villeDepart + "-" + villeArrivee + "  " + paysDepart + "-" + paysArrivee + ", distance=" + distance + ", etatEtape=" + etatEtape +'}';
    }
    
    
    
    
    
}
