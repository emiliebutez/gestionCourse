/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.coureur;

import com.mycompany.gestioncourses.models.Coureur;
import com.mycompany.gestioncourses.views.MainFrame;

/**
 *
 * @author Emilie
 */
public class MenuCoureurPanel extends javax.swing.JPanel {
    
    private MainFrame frame;
    private Coureur coureur;

    /**
     * Creates new form MenuCoureurPanel
     */
    public MenuCoureurPanel(MainFrame frame, Coureur coureur) {
        this.coureur = coureur;
        this.frame = frame;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utilisateur = new javax.swing.JButton();
        editions = new javax.swing.JButton();
        inscriptions = new javax.swing.JButton();

        utilisateur.setText("Choix utilisateur");
        utilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilisateurActionPerformed(evt);
            }
        });

        editions.setText("Consultation des éditions");
        editions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editionsActionPerformed(evt);
            }
        });

        inscriptions.setText("Consultation des inscriptions");
        inscriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(utilisateur)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editions)
                .addGap(56, 56, 56)
                .addComponent(inscriptions)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(utilisateur)
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editions)
                    .addComponent(inscriptions))
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void utilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilisateurActionPerformed
        this.frame.displayUtilisateur();
    }//GEN-LAST:event_utilisateurActionPerformed

    private void editionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionsActionPerformed
        this.frame.displayConsultationEditionsCoureurPanel(this.coureur);
    }//GEN-LAST:event_editionsActionPerformed

    private void inscriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscriptionsActionPerformed
        this.frame.displayConsultationInscriptionsPanel();
    }//GEN-LAST:event_inscriptionsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editions;
    private javax.swing.JButton inscriptions;
    private javax.swing.JButton utilisateur;
    // End of variables declaration//GEN-END:variables
}
