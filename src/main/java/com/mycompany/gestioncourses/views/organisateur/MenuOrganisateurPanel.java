/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.organisateur;

import com.mycompany.gestioncourses.views.MainFrame;

/**
 *
 * @author Emilie
 */
public class MenuOrganisateurPanel extends javax.swing.JPanel {

    private MainFrame frame;
    /**
     * Creates new form CreationCoursePanel
     */
    public MenuOrganisateurPanel(MainFrame frame) {
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

        jLabel1 = new javax.swing.JLabel();
        creationCourse = new javax.swing.JButton();
        creationEdition = new javax.swing.JButton();
        ConsulterEdition = new javax.swing.JButton();
        utilisateur = new javax.swing.JButton();
        ajouterEtape = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setText("Accueil Organisateur");

        creationCourse.setText("Création d'une course");
        creationCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creationCourseActionPerformed(evt);
            }
        });

        creationEdition.setText("Creation édition");
        creationEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creationEditionActionPerformed(evt);
            }
        });

        ConsulterEdition.setText("Consulter édition");
        ConsulterEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsulterEditionActionPerformed(evt);
            }
        });

        utilisateur.setText("Choix Utilisateur");
        utilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilisateurActionPerformed(evt);
            }
        });

        ajouterEtape.setText("Ajouter étape");
        ajouterEtape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterEtapeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(creationCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(creationEdition)
                .addGap(75, 75, 75)
                .addComponent(ajouterEtape)
                .addGap(116, 116, 116)
                .addComponent(ConsulterEdition)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(utilisateur)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(utilisateur)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creationCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creationEdition)
                    .addComponent(ajouterEtape)
                    .addComponent(ConsulterEdition))
                .addGap(123, 123, 123))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void creationCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creationCourseActionPerformed
        frame.displayCreationCoursePanel();
    }//GEN-LAST:event_creationCourseActionPerformed

    private void creationEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creationEditionActionPerformed
        frame.displayCreationEditionPanel(null);
    }//GEN-LAST:event_creationEditionActionPerformed

    private void utilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilisateurActionPerformed
        frame.displayUtilisateur();
    }//GEN-LAST:event_utilisateurActionPerformed

    private void ConsulterEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsulterEditionActionPerformed
        frame.displayConsulterEditionsPanel();
    }//GEN-LAST:event_ConsulterEditionActionPerformed

    private void ajouterEtapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterEtapeActionPerformed
        frame.displayAjoutEtapePanel();
    }//GEN-LAST:event_ajouterEtapeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsulterEdition;
    private javax.swing.JButton ajouterEtape;
    private javax.swing.JButton creationCourse;
    private javax.swing.JButton creationEdition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton utilisateur;
    // End of variables declaration//GEN-END:variables
}
