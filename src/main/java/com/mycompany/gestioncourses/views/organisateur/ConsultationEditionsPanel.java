/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gestioncourses.views.organisateur;

import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.services.CourseService;
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
public class ConsultationEditionsPanel extends javax.swing.JPanel implements ActionListener {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private MainFrame frame;   
    private CourseService courseService = CourseService.getInstance();
    private List<Course> courses = courseService.courses();
    private Course courseSelectionnee;
    private Etape etapeSelectionnee;
    private Edition editionSelectionnee;
    
    /**
     * Creates new form ConsulterEditionsPanel
     */
    public ConsultationEditionsPanel(MainFrame frame) {
        this.frame = frame;
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
        
        this.equipesPanel.setLayout(new BoxLayout(this.equipesPanel, BoxLayout.Y_AXIS));
        this.equipesPanel.add(new AffichageEquipePanel());
        this.equipesPanel.add(new AffichageEquipePanel());
        this.equipesPanel.add(new AffichageEquipePanel());
        this.equipesPanel.add(new AffichageEquipePanel());
        this.equipesPanel.add(new AffichageEquipePanel());

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
                            value.getPaysDepart(), value.getPaysArrivee(),
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        choixCourse = new javax.swing.JComboBox<>();
        choixEdition = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        equipesPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        choixEtape = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        informationsEdition = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        informationsEtape = new javax.swing.JLabel();

        jLabel1.setText("Course");

        jLabel2.setText("Edition");

        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout equipesPanelLayout = new javax.swing.GroupLayout(equipesPanel);
        equipesPanel.setLayout(equipesPanelLayout);
        equipesPanelLayout.setHorizontalGroup(
            equipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        equipesPanelLayout.setVerticalGroup(
            equipesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jLabel5.setText("Etape");

        jLabel3.setText("Informations edition");

        informationsEdition.setText("Informations non disponibles");

        jLabel4.setText("Informations étape");

        informationsEtape.setText("Informations non disponibles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(choixEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menu)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationsEtape)
                    .addComponent(jLabel4)
                    .addComponent(informationsEdition)
                    .addComponent(jLabel3)
                    .addComponent(equipesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(menu)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choixEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(choixEtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationsEdition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationsEtape)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equipesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        this.frame.displayMenuOrganisateur();
    }//GEN-LAST:event_menuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Course> choixCourse;
    private javax.swing.JComboBox<Edition> choixEdition;
    private javax.swing.JComboBox<Etape> choixEtape;
    private javax.swing.JPanel equipesPanel;
    private javax.swing.JLabel informationsEdition;
    private javax.swing.JLabel informationsEtape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu;
    // End of variables declaration//GEN-END:variables
}
