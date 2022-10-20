/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.organisateur;

import com.mycompany.gestioncourses.controllers.OrganisateurController;
import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.services.CourseService;
import com.mycompany.gestioncourses.services.EditionService;
import com.mycompany.gestioncourses.services.VehiculeService;
import com.mycompany.gestioncourses.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Emilie
 */
public class CreationEditionPanel extends javax.swing.JPanel implements ActionListener {

    private MainFrame frame;
    private OrganisateurController controller;
    private EditionService editionService = EditionService.getInstance();
    private CourseService courseService = CourseService.getInstance();
    private Map<String, Course> courses = courseService.coursesParNom();
    private Course courseSelectionnee;
    
    
    /**
     * Creates new form CreationCoursePanel
     */
    public CreationEditionPanel(MainFrame frame) {
        this(frame, null);
    }
    
    /**
     * Creates new form CreationCoursePanel
     */
    public CreationEditionPanel(MainFrame frame, Course course) {
        this.frame = frame;
        initComponents();
        this.controller = new OrganisateurController();
        this.choixCourse.addActionListener(this);
        this.courses.keySet().forEach(c -> this.choixCourse.addItem(c));
        if (course != null) {
            this.choixCourse.setSelectedItem(course.getNom());
            this.courseSelectionnee = course;
        } else {
            this.courseSelectionnee = this.courses.get(this.choixCourse.getItemAt(0));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JComboBox)) {
            return;
        }
        
        JComboBox<String> target = (JComboBox<String>) e.getSource();
        String value = (String) target.getSelectedItem();
        if (value != null) {
            this.courseSelectionnee = this.courses.get(value);
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

        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        nomCourse = new javax.swing.JLabel();
        valider = new javax.swing.JButton();
        choixCourse = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        villeDepartEtape = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        paysDepartEtape = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        villeArriveeEtape = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        paysArriveeEtape = new javax.swing.JTextField();
        annee = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dateDebutEdition = new javax.swing.JTextField();
        distanceEtape = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateFinEdition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        villeDepartEdition = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        paysDepartEdition = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        paysArriveeEdition = new javax.swing.JTextField();
        villeArriveeEdition = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nbSprint = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nbCol = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Creation edition");

        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        nomCourse.setText("Course :");

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        jLabel9.setText("Ville départ : ");

        villeDepartEtape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeDepartEtapeActionPerformed(evt);
            }
        });

        jLabel10.setText("Pays :");

        jLabel11.setText("Ville arrivée : ");

        jLabel2.setText("Edition :    Année : ");

        annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeActionPerformed(evt);
            }
        });

        jLabel12.setText("Pays :");

        jLabel3.setText("Date :        début : ");

        jLabel13.setText("Distance : ");

        jLabel4.setText("fin : ");

        jLabel5.setText("Ville départ : ");

        villeDepartEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeDepartEditionActionPerformed(evt);
            }
        });

        jLabel6.setText("Pays :");

        jLabel7.setText("Ville arrivée : ");

        jLabel8.setText("Pays :");

        jLabel14.setText("Etape 1 :");

        jLabel15.setText("Nombre sprint :");

        jLabel16.setText("Nombre Col :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(nbSprint, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(nbCol, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateDebutEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFinEdition)
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(villeArriveeEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paysArriveeEdition))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 48, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(nomCourse, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(villeDepartEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paysDepartEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(villeDepartEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paysDepartEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(27, 27, 27))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(villeArriveeEtape)
                                            .addComponent(distanceEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paysArriveeEtape, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(104, 104, 104)
                .addComponent(menu)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(valider)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomCourse)
                            .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateDebutEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(dateFinEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(villeDepartEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paysDepartEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(villeArriveeEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paysArriveeEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(villeDepartEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paysDepartEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(villeArriveeEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paysArriveeEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(distanceEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nbSprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(nbCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(valider)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        this.frame.displayMenuOrganisateur();
    }//GEN-LAST:event_menuActionPerformed

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Edition edition = courseService.creerEdition(
                    courseSelectionnee,
                    Integer.parseInt(annee.getText()),
                    format.parse(dateDebutEdition.getText()),
                    format.parse(dateFinEdition.getText()),
                    villeDepartEdition.getText(),
                    villeArriveeEdition.getText(),
                    paysDepartEdition.getText(),
                    paysArriveeEdition.getText()
            );
            editionService.ajouterEtape(
                    edition,
                    villeDepartEtape.getText(),
                    villeArriveeEtape.getText(),
                    paysDepartEtape.getText(),
                    paysArriveeEtape.getText(),
                    Float.parseFloat(distanceEtape.getText()),
                    Integer.parseInt(nbSprint.getText()),
                    Integer.parseInt(nbCol.getText())
            );
            frame.displayMenuOrganisateur();
        } catch (ParseException ex) {
            Logger.getLogger(CreationEditionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_validerActionPerformed

    private void villeDepartEtapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeDepartEtapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeDepartEtapeActionPerformed

    private void anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeActionPerformed

    private void villeDepartEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeDepartEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_villeDepartEditionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField annee;
    private javax.swing.JComboBox<String> choixCourse;
    private javax.swing.JTextField dateDebutEdition;
    private javax.swing.JTextField dateFinEdition;
    private javax.swing.JTextField distanceEtape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton menu;
    private javax.swing.JTextField nbCol;
    private javax.swing.JTextField nbSprint;
    private javax.swing.JLabel nomCourse;
    private javax.swing.JTextField paysArriveeEdition;
    private javax.swing.JTextField paysArriveeEtape;
    private javax.swing.JTextField paysDepartEdition;
    private javax.swing.JTextField paysDepartEtape;
    private javax.swing.JButton valider;
    private javax.swing.JTextField villeArriveeEdition;
    private javax.swing.JTextField villeArriveeEtape;
    private javax.swing.JTextField villeDepartEdition;
    private javax.swing.JTextField villeDepartEtape;
    // End of variables declaration//GEN-END:variables
}
