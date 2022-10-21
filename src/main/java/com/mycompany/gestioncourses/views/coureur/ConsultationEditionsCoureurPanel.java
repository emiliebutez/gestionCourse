/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.coureur;

import com.mycompany.gestioncourses.models.Coureur;
import com.mycompany.gestioncourses.views.organisateur.*;
import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.services.CourseService;
import com.mycompany.gestioncourses.services.EditionService;
import com.mycompany.gestioncourses.views.MainFrame;
import com.mycompany.gestioncourses.views.utils.DropDownRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

/**
 *
 * @author Emilie
 */
public class ConsultationEditionsCoureurPanel extends javax.swing.JPanel implements ActionListener {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private MainFrame frame;   
    private CourseService courseService = CourseService.getInstance();
    private EditionService editionService = EditionService.getInstance();
    private List<Course> courses = courseService.courses();
    private Course courseSelectionnee;
    private Etape etapeSelectionnee;
    private Edition editionSelectionnee;
    private Coureur coureur;
    
    /**
     * Creates new form ConsulterEditionsPanel
     */
    public ConsultationEditionsCoureurPanel(MainFrame frame, Coureur coureur) {
        this.frame = frame;
        this.coureur = coureur;
        initComponents();
        this.choixCourse.removeAllItems();
        this.choixEdition.removeAllItems();
        this.choixEtape.removeAllItems();
        this.choixCourse.addActionListener(this);
        this.choixEdition.addActionListener(this);
        this.choixEtape.addActionListener(this);
        this.courses.stream().forEach(c -> this.choixCourse.addItem(c));
        this.courseSelectionnee = this.courses.isEmpty() ? null : this.courses.get(0);
        this.choixCourse.setRenderer(new DropDownRenderer<Course>(c -> c.getNom()));

        this.choixEdition.setRenderer(new DropDownRenderer<Edition>(e -> {
            if (e == null) {
                return "Pas d'édition disponible";
            }
            return DATE_FORMAT.format(e.getDateDebut());
        }));
        this.choixEtape.setRenderer(new DropDownRenderer<Etape>(e -> {
            if (e == null) {
                return "Pas d'étape disponible";
            }
            return String.valueOf(e.getNumOrdre());
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
                                "Départ: %s, %s<br/>" + 
                                    "Arrivée: %s, %s<br/>" +
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
            this.choixEtape.removeAllItems();
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
            this.choixEtape.removeAllItems();
            if (this.editionSelectionnee.getEtapes() != null) {
                this.editionSelectionnee.getEtapes()
                    .stream()
                    .forEach(etape -> this.choixEtape.addItem(etape));
            }
            
            this.informationsEdition.setText(
                    String.format(
                            "<html>" +
                                "Départ: %s, %s<br/>" + 
                                    "Arrivée: %s, %s<br/>" + 
                                    "Dates: %s -> %s<br/>" +
                                    "Distance: %fkm" +
                                    "</html>", 
                            value.getVilleDepart(),value.getPaysDepart(),
                            value.getVilleArrivee(), value.getPaysArrivee(),
                            DATE_FORMAT.format(value.getDateDebut()), DATE_FORMAT.format(value.getDateFin()),
                            value.getDistance()
                    )
            );
            this.repaint();
        } else {
            this.informationsEdition.setText("Informations indisponibles");
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

        choixEtape = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        choixEdition = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        choixCourse = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        informationsEdition = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        informationsEtape = new javax.swing.JLabel();

        jLabel5.setText("Etape");

        jLabel2.setText("Edition");

        jLabel1.setText("Course");

        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jLabel3.setText("Informations édition :");

        informationsEdition.setText("Informations non disponibles");

        jLabel4.setText("Informations étape :");

        informationsEtape.setText("Informations non disponibles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(menu)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(choixEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(informationsEdition)
                            .addComponent(jLabel3)
                            .addComponent(informationsEtape)
                            .addComponent(jLabel4))
                        .addGap(217, 217, 217))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(choixEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationsEdition)
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationsEtape)
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        this.frame.displayMenuCoureurPanel(this.coureur);
    }//GEN-LAST:event_menuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton menu;
    // End of variables declaration//GEN-END:variables
}
