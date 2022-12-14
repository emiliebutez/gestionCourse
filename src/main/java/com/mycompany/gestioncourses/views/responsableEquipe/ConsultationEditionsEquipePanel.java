/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.responsableEquipe;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.models.EtatEtape;
import com.mycompany.gestioncourses.services.CourseService;
import com.mycompany.gestioncourses.services.EditionService;
import com.mycompany.gestioncourses.services.ParticipationEquipeService;
import com.mycompany.gestioncourses.views.MainFrame;
import com.mycompany.gestioncourses.views.organisateur.AffichageEquipePanel;
import com.mycompany.gestioncourses.views.utils.DropDownRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BoxLayout;

/**
 *
 * @author David_C
 */
public class ConsultationEditionsEquipePanel extends javax.swing.JPanel implements ActionListener {

  
    /**
     * Creates new form ConsultationEditionsEquipePanel
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");  
    private CourseService courseService = CourseService.getInstance();
    private EditionService editionService = EditionService.getInstance();
    private ParticipationEquipeService participationEquipeService = ParticipationEquipeService.getInstance();
    private List<Course> courses = courseService.courses();
    private Course courseSelectionnee;
    private Etape etapeSelectionnee;
    private Edition editionSelectionnee;
     private MainFrame frame;
    private Equipe equipe;
    
    /**
     * Creates new form ConsulterEditionsPanel
     */
    public ConsultationEditionsEquipePanel(MainFrame frame , Equipe equipe) {
        this.frame = frame;
        this.equipe = equipe;
        initComponents();
        this.choixCourse.addActionListener(this);
        this.choixEdition.addActionListener(this);
        this.choixEtape.addActionListener(this);
        this.courses.stream().forEach(c -> this.choixCourse.addItem(c));
        this.courseSelectionnee = this.courses.isEmpty() ? null : this.courses.get(0);
        
        this.choixCourse.setRenderer(new DropDownRenderer<Course>(c -> c.getNom()));
        this.choixEdition.setRenderer(new DropDownRenderer<Edition>(e -> DATE_FORMAT.format(e.getDateDebut())));
        this.choixEtape.setRenderer(new DropDownRenderer<Etape>(e -> {
            System.out.println(e);
            return String.valueOf(e.getNumOrdre());
        }));
        
        //this.equipesPanel.setLayout(new BoxLayout(this.equipesPanel, BoxLayout.Y_AXIS));
        //this.equipesPanel.add(new AffichageEquipePanel());
        //this.equipesPanel.add(new AffichageEquipePanel());
        //this.equipesPanel.add(new AffichageEquipePanel());
        //this.equipesPanel.add(new AffichageEquipePanel());
        //this.equipesPanel.add(new AffichageEquipePanel());

        this.invalidate();
        this.repaint();
    }
    
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.choixCourse) {
            selectionCourse((Course) this.choixCourse.getSelectedItem());
            return;
        }
        
        if (e.getSource() == this.choixEdition) {
            selectionEdition((Edition) this.choixEdition.getSelectedItem());
            return;
        }
        
        if (e.getSource() == this.choixEtape) {
            selectionEtape((Etape) this.choixEtape.getSelectedItem());
            return;
        }
    }
    
    private void selectionEtape(Etape value) {
        this.etapeSelectionnee = value;
        if (value != null) {
            this.informationsEtape.setText(
                    String.format(
                            "<html>" +
                                "D??part: %s, %s<br/>" + 
                                    "Arriv??e: %s, %s<br/>" +
                                    "Distance: %fkm" +
                                    "</html>", 
                            value.getVilleDepart(),value.getPaysDepart(),
                            value.getVilleArrivee(), value.getPaysArrivee(),
                            value.getDistance()
                    )
            );
            this.repaint();
        } else {
            this.informationsEtape.setText("Informations indisponibles");
        }
    }
    
    private void selectionCourse(Course value) {
        this.courseSelectionnee = value;
        if (value != null) {
            this.choixEdition.removeAllItems();
            this.courseSelectionnee.getEditions()
                    .stream()
                    .forEach(edition -> this.choixEdition.addItem(edition));
            this.repaint();
        }
    }
    
    private void selectionEdition(Edition value) {
        this.editionSelectionnee = value;
        if (value != null) {
            this.choixEtape.removeAllItems();
            this.editionSelectionnee.getEtapes()
                    .stream()
                    .forEach(etape -> this.choixEtape.addItem(etape));
            this.informationsEdition.setText(
                    String.format(
                            "<html>" +
                                "D??part: %s, %s<br/>" + 
                                    "Arriv??e: %s, %s<br/>" + 
                                    "Dates: %s -> %s<br/>" +
                                    "Distance: %fkm" +
                                    "</html>", 
                            value.getVilleDepart(),value.getPaysDepart(),
                            value.getVilleArrivee(), value.getPaysArrivee(),
                            DATE_FORMAT.format(value.getDateDebut()), DATE_FORMAT.format(value.getDateFin()),
                            value.getDistance()
                    )
            );
        } else {
            this.informationsEdition.setText("Informations indisponibles");
        }
        
        this.mettreAJourInscription(value, this.equipe);
        
        this.repaint();
    }

    
    private void mettreAJourInscription(Edition edition, Equipe equipe) {
        if (edition == null || equipe == null) {
            this.labelInscription.setVisible(false);
            this.buttonInscription.setVisible(false);
            return;
        }
        
        if (this.editionService.estInscrit(edition, this.equipe)) {
            this.labelInscription.setText("Vous ??tes inscrit ?? cette ??dition");
            this.labelInscription.setVisible(true);
            this.buttonInscription.setVisible(false);
            return;
        }
        
        
        boolean editionCommencee = edition.getEtapes().stream().anyMatch(e -> e.getEtatEtape() == EtatEtape.Lancee);
        boolean toutesEtapesIndisponibles = edition.getEtapes().stream().noneMatch(e -> e.getEtatEtape() == EtatEtape.Attente);
        if (editionCommencee || toutesEtapesIndisponibles) {
            this.labelInscription.setText("Cette ??dition n'est plus ??ligible aux inscriptions");
            this.buttonInscription.setVisible(false);
            return;
        }
        
        this.labelInscription.setText("Vous n'??tes pas inscrit ?? cette ??dition");
        this.buttonInscription.setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        choixCourse = new javax.swing.JComboBox<>();
        choixEdition = new javax.swing.JComboBox<>();
        choixEtape = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        informationsEdition = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        informationsEtape = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        buttonInscription = new javax.swing.JButton();
        labelInscription = new javax.swing.JLabel();

        jLabel1.setText("Course :");

        jLabel2.setText("Edition :");

        jLabel3.setText("Etape :");

        choixEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choixEditionActionPerformed(evt);
            }
        });

        jLabel4.setText("Informations edition");

        informationsEdition.setText("Informations non disponibles");

        jLabel5.setText("Informations ??tape");

        informationsEtape.setText("Informations non disponibles");

        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        buttonInscription.setText("S'inscrire");
        buttonInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInscriptionActionPerformed(evt);
            }
        });

        labelInscription.setText("Vous n'??tes pas inscrit ?? cette edition");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(labelInscription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInscription))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(197, 197, 197)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(choixEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(informationsEtape)
                            .addComponent(jLabel5)
                            .addComponent(informationsEdition)
                            .addComponent(jLabel4))
                        .addGap(135, 135, 135))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(menu)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(choixEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInscription)
                    .addComponent(labelInscription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationsEdition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationsEtape)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void choixEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choixEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choixEditionActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        this.frame.displayMenuJuryPanel();
    }//GEN-LAST:event_menuActionPerformed

    private void buttonInscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInscriptionActionPerformed
        if (this.equipe == null || this.editionSelectionnee == null) {
            return;
        }
        
        this.frame.displayComposerEquipePanel(this.equipe, this.editionSelectionnee);
    }//GEN-LAST:event_buttonInscriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInscription;
    private javax.swing.JComboBox<Course> choixCourse;
    private javax.swing.JComboBox<Edition> choixEdition;
    private javax.swing.JComboBox<Etape> choixEtape;
    private javax.swing.JLabel informationsEdition;
    private javax.swing.JLabel informationsEtape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelInscription;
    private javax.swing.JButton menu;
    // End of variables declaration//GEN-END:variables
}
