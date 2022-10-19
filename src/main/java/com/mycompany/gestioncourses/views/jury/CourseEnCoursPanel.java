/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.jury;

import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.services.EtapeService;
import com.mycompany.gestioncourses.views.MainFrame;
import java.util.Objects;

/**
 *
 * @author Emilie
 */
public class CourseEnCoursPanel extends javax.swing.JPanel {
    
    private MainFrame frame;
    private Etape etape;
    private EtapeService etapeService = EtapeService.getInstance();

    /**
     * Creates new form CourseEnCoursPanel
     */
    public CourseEnCoursPanel(MainFrame frame, Etape etape) {
        this.frame = frame;
        this.etape = etape;
        initComponents();
        
        this.pointGrimp.setVisible(false);
        this.pointSprint.setVisible(false);
        this.panelTemps.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choixType = new javax.swing.ButtonGroup();
        menu = new javax.swing.JButton();
        cloturer = new javax.swing.JButton();
        coureur = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        validation = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        numSprintOuGrimp = new javax.swing.JComboBox<>();
        selectSprint = new javax.swing.JRadioButton();
        selectCol = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        pointGrimp = new javax.swing.JTextField();
        pointSprint = new javax.swing.JTextField();
        panelTemps = new javax.swing.JPanel();
        temps = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        menu.setBackground(new java.awt.Color(0, 102, 153));
        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        cloturer.setBackground(new java.awt.Color(204, 0, 51));
        cloturer.setForeground(new java.awt.Color(255, 255, 255));
        cloturer.setText("Cloturer");
        cloturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cloturerActionPerformed(evt);
            }
        });

        jLabel2.setText("Coureur :");

        jLabel4.setText("Point sprint :");

        validation.setBackground(new java.awt.Color(0, 102, 51));
        validation.setText("Ajouter");

        jLabel5.setText("Point grimper :");

        numSprintOuGrimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numSprintOuGrimpActionPerformed(evt);
            }
        });

        choixType.add(selectSprint);
        selectSprint.setText("Sprint");
        selectSprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSprintActionPerformed(evt);
            }
        });

        choixType.add(selectCol);
        selectCol.setText("Col");
        selectCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectColActionPerformed(evt);
            }
        });

        jLabel6.setText("Numéro :");

        temps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempsActionPerformed(evt);
            }
        });

        jLabel3.setText("Temps :");

        javax.swing.GroupLayout panelTempsLayout = new javax.swing.GroupLayout(panelTemps);
        panelTemps.setLayout(panelTempsLayout);
        panelTempsLayout.setHorizontalGroup(
            panelTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTempsLayout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(temps, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTempsLayout.setVerticalGroup(
            panelTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTempsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelTempsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cloturer)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(coureur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(numSprintOuGrimp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(selectSprint)
                        .addGap(67, 67, 67)
                        .addComponent(selectCol)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pointSprint)
                            .addComponent(pointGrimp))))
                .addGap(406, 406, 406))
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(validation)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(panelTemps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coureur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSprint)
                    .addComponent(selectCol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numSprintOuGrimp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pointSprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(cloturer)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pointGrimp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelTemps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(validation)
                        .addGap(122, 122, 122))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tempsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempsActionPerformed

    private void selectSprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSprintActionPerformed
        this.pointGrimp.setVisible(false);
        this.panelTemps.setVisible(true);
        this.numSprintOuGrimp.removeAllItems();
        if (this.etape.getNbSprint() > 0) {
            this.pointSprint.setVisible(true);
           if (this.etape.getNbSprint() == 1) {
               this.temps.setVisible(true);
           }
            for (int i = 0; i < this.etape.getNbSprint(); i++) {
                this.numSprintOuGrimp.addItem(i + 1);
            }
        }
        this.repaint();
    }//GEN-LAST:event_selectSprintActionPerformed

    private void numSprintOuGrimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numSprintOuGrimpActionPerformed
         if (this.selectSprint.isSelected() && this.numSprintOuGrimp != null ) {
             if(Objects.equals(this.numSprintOuGrimp.getSelectedItem(), this.etape.getNbSprint())) {
                 this.panelTemps.setVisible(true);
             }
             else {
                 this.panelTemps.setVisible(false);
             }
         }
         
    }//GEN-LAST:event_numSprintOuGrimpActionPerformed

    private void selectColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectColActionPerformed
        this.numSprintOuGrimp.removeAllItems();
        this.pointSprint.setVisible(false);
        this.panelTemps.setVisible(false);
        if (this.etape.getNbCol() > 0) {
            this.pointGrimp.setVisible(true);
            for (int i = 0; i < this.etape.getNbSprint(); i++) {
               this.numSprintOuGrimp.addItem(i + 1);
            }
        }
    }//GEN-LAST:event_selectColActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        this.frame.displayConsultationEditionsJuryPanel();
    }//GEN-LAST:event_menuActionPerformed

    private void cloturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cloturerActionPerformed
        this.etapeService.cloturerEtape(etape);
    }//GEN-LAST:event_cloturerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup choixType;
    private javax.swing.JButton cloturer;
    private javax.swing.JComboBox<String> coureur;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton menu;
    private javax.swing.JComboBox<Integer> numSprintOuGrimp;
    private javax.swing.JPanel panelTemps;
    private javax.swing.JTextField pointGrimp;
    private javax.swing.JTextField pointSprint;
    private javax.swing.JRadioButton selectCol;
    private javax.swing.JRadioButton selectSprint;
    private javax.swing.JTextField temps;
    private javax.swing.JButton validation;
    // End of variables declaration//GEN-END:variables
}