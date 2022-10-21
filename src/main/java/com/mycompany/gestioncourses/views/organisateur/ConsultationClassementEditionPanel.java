/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.organisateur;

import com.mycompany.gestioncourses.models.Coureur;
import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.services.CoureurService;
import com.mycompany.gestioncourses.services.CourseService;
import com.mycompany.gestioncourses.services.EditionService;
import com.mycompany.gestioncourses.services.EquipeService;
import com.mycompany.gestioncourses.views.MainFrame;
import com.mycompany.gestioncourses.views.utils.DropDownRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Emilie
 */
public class ConsultationClassementEditionPanel extends javax.swing.JPanel implements ActionListener {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private MainFrame frame;
    private EditionService editionService = EditionService.getInstance();
    private CourseService courseService = CourseService.getInstance();
    private CoureurService coureurService = CoureurService.getInstance();
    private EquipeService equipeService = EquipeService.getInstance();
    private List<Course> courses = courseService.courses();
    private Course courseSelectionnee;
    private Edition editionSelectionnee;

    /**
     * Creates new form ConsultationClassementEditionPanel
     */
    public ConsultationClassementEditionPanel(MainFrame frame) {
        this.frame = frame;
        initComponents();
        
        this.choixCourse.removeAllItems();
        this.choixEdition.removeAllItems();
        this.choixCourse.addActionListener(this);
        this.choixEdition.addActionListener(this);
        this.courses.stream().forEach(c -> this.choixCourse.addItem(c));
        this.courseSelectionnee = this.courses.isEmpty() ? null : this.courses.get(0);
        this.choixCourse.setRenderer(new DropDownRenderer<Course>(c -> c.getNom()));

        this.choixEdition.setRenderer(new DropDownRenderer<Edition>(e -> {
            if (e == null) {
                return "Pas d'édition disponible";
            }
            return DATE_FORMAT.format(e.getDateDebut());
        }));
        
        this.invalidate();
        this.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.choixCourse) {
            selectionCourse((Course) this.choixCourse.getSelectedItem());
            return;
        }
        
        if (e.getSource() == this.choixEdition) {
            selectionEdition((Edition) this.choixEdition.getSelectedItem());
            return;
        }
    }
    
    private void selectionCourse(Course value) {
        this.courseSelectionnee = value;
        if (value != null) {
            this.choixEdition.removeAllItems();
            if (this.courseSelectionnee.getEditions() != null) {
                this.courseSelectionnee.getEditions()
                    .stream()
                    .forEach(edition -> this.choixEdition.addItem(edition));                
            }
            this.repaint();
        }
    }
    
    private void selectionEdition(Edition value) {
        this.editionSelectionnee = value;
        if (value != null) {
            
            try {
                List<Coureur> coureurEquipe = this.editionService.classementGeneralEdition(this.editionSelectionnee);
                String nomCoureurs = coureurEquipe.stream()
                            .map(c -> String.format("%s %s %s %s", coureurEquipe.indexOf(c) + 1,"Prenom : " + c.getPrenom(),"    Nom : " + c.getNom(), "Temps : " + this.coureurService.tempsCoureurEdition(this.editionSelectionnee, c)))
                            .collect(Collectors.joining("<br/>", "<html>", "<html/>"));
                    this.classementGeneral.setText(nomCoureurs);
                    
            } catch(Exception e) {
                this.classementGeneral.setText("Classement indisponible");
            }
            
            try {
                List<Equipe> equipes = this.editionService.classementGeneralEditionParEquipe(this.editionSelectionnee);
                String nomEquipes = equipes.stream()
                            .map(c -> String.format("%s %s %s %s", equipes.indexOf(c) + 1, "Equipe : " + c.getNomEquipe(), "Nationalité : " +c.getNationnalite(), "Temps : " +this.equipeService.tempsEquipeEdition(this.editionSelectionnee, c)))
                            .collect(Collectors.joining("<br/>", "<html>", "<html/>"));
                    this.classementEquipe.setText(nomEquipes);
            } catch(Exception e) {
                this.classementEquipe.setText("Classement indisponible");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        retour = new javax.swing.JButton();
        choixCourse = new javax.swing.JComboBox<>();
        choixEdition = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        classementGeneral = new javax.swing.JLabel();
        classementEquipe = new javax.swing.JLabel();

        retour.setText("Retour");
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });

        jLabel1.setText("Course :");

        jLabel2.setText("Edition :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Classement Général");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Classement par équipe");

        classementGeneral.setText("Classement non disponible");

        classementEquipe.setText("Classement non disponible ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel4)))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(retour))
                            .addComponent(classementGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classementEquipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(retour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(classementGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(48, 48, 48)
                .addComponent(classementEquipe)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
        this.frame.displayConsulterClassementPanel();
    }//GEN-LAST:event_retourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Course> choixCourse;
    private javax.swing.JComboBox<Edition> choixEdition;
    private javax.swing.JLabel classementEquipe;
    private javax.swing.JLabel classementGeneral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton retour;
    // End of variables declaration//GEN-END:variables
}
