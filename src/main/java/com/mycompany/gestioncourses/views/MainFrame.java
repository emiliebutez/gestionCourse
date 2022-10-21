/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestioncourses.views;

import com.mycompany.gestioncourses.models.Coureur;
import com.mycompany.gestioncourses.models.Course;
import com.mycompany.gestioncourses.models.Edition;
import com.mycompany.gestioncourses.views.coureur.ConnexionCoureurPanel;
import com.mycompany.gestioncourses.views.coureur.ConnexionCoureurPanel;
import com.mycompany.gestioncourses.models.Equipe;
import com.mycompany.gestioncourses.models.Etape;
import com.mycompany.gestioncourses.views.coureur.ConsultationEditionsCoureurPanel;
import com.mycompany.gestioncourses.views.coureur.MenuCoureurPanel;
import com.mycompany.gestioncourses.views.organisateur.ConsultationClassementPanel;
import com.mycompany.gestioncourses.views.organisateur.ConsultationEditionsPanel;
import com.mycompany.gestioncourses.views.organisateur.CreationCoursePanel;
import com.mycompany.gestioncourses.views.organisateur.CreationEditionPanel;
import com.mycompany.gestioncourses.views.organisateur.MenuOrganisateurPanel;
import com.mycompany.gestioncourses.views.coureur.ConsultationInscriptionsPanel;
import com.mycompany.gestioncourses.views.coureur.InscriptionCoureurPanel;
import com.mycompany.gestioncourses.views.jury.ConsultationClassementJuryPanel;
import com.mycompany.gestioncourses.views.jury.ConsultationEditionsJuryPanel;
import com.mycompany.gestioncourses.views.jury.CourseEnCoursPanel;
import com.mycompany.gestioncourses.views.jury.MenuJuryPanel;
import com.mycompany.gestioncourses.views.organisateur.AjoutEtapePanel;
import com.mycompany.gestioncourses.views.organisateur.ConsultationMeilleursCategoriePanel;
import com.mycompany.gestioncourses.views.responsableEquipe.ComposerEquipePanel;
import com.mycompany.gestioncourses.views.responsableEquipe.ConnexionEquipePanel;
import com.mycompany.gestioncourses.views.responsableEquipe.ConsultationEditionsEquipePanel;
import com.mycompany.gestioncourses.views.responsableEquipe.ConsultationInscriptionsEquipePanel;
import com.mycompany.gestioncourses.views.responsableEquipe.InscriptionEquipePanel;
import com.mycompany.gestioncourses.views.responsableEquipe.MenuResponsablePanel;
import io.ebean.DB;
import java.awt.Container;
import java.sql.Date;
import java.util.Collections;

/**
 *
 * @author Emilie
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        DB.getDefault().script().run("/db-init.sql");
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setMainFrame(new UtilisateurPanel(frame));
                frame.setVisible(true);
            }
        });
    }
    
    private void setMainFrame(Container c) {
        this.setContentPane(c);
        this.pack();
        this.revalidate();
        this.repaint();
    }
    
    public void displayUtilisateur() {
        this.setMainFrame(new UtilisateurPanel(this));
    }
    
    public void displayMenuCoureurPanel(Coureur coureur) {
        this.setMainFrame(new MenuCoureurPanel(this, coureur));
    }
    
    public void displayConsultationInscriptionsPanel(Coureur coureur) {
        this.setMainFrame(new ConsultationInscriptionsPanel(this, coureur));
    }
    
    public void displayConsulterEditionsPanel() {
        this.setMainFrame(new ConsultationEditionsPanel(this));
    }
    
    public void displayMenuOrganisateur() {
        this.setMainFrame(new MenuOrganisateurPanel(this));
    }
    
    public void displayCreationCoursePanel() {
        this.setMainFrame(new CreationCoursePanel(this));
    }
    
    public void displayCreationEditionPanel(Course course) {
        this.setMainFrame(new CreationEditionPanel(this, course));
    }
    
    public void displayConsulterClassementPanel() {
        this.setMainFrame(new ConsultationClassementPanel(this));
    }
    
    public void displayMenuJuryPanel() {
        this.setMainFrame(new MenuJuryPanel(this));
    }
    
    public void displayMenuResponsablePanel(Equipe equipe) {
        this.setMainFrame(new MenuResponsablePanel(this, equipe));
    }
    
    public void displayConsultationEditionsJuryPanel() {
        this.setMainFrame(new ConsultationEditionsJuryPanel(this));
    }
    
    public void displayConsultationClassementJuryPanel() {
        this.setMainFrame(new ConsultationClassementJuryPanel(this));
    }
    
    public void displayAjoutEtapePanel() {
        this.setMainFrame(new AjoutEtapePanel(this));
    }
    
    public void displayConnexionCoureurPanel() {
        this.setMainFrame(new ConnexionCoureurPanel(this));
    }
    
    public void displayInscriptionCoureurPanel() {
        this.setMainFrame(new InscriptionCoureurPanel(this));
    }
    
    public void displayInscriptionEquipe() {
        this.setMainFrame(new InscriptionEquipePanel(this));
    }
    
    public void displayComposerEquipePanel(Equipe equipe, Edition editionSelectionnee) {
        this.setMainFrame(new ComposerEquipePanel(this, equipe, editionSelectionnee));
    }
    
    public void displayConnexionEquipePanel() {
        this.setMainFrame(new ConnexionEquipePanel(this));
    }
    
    public void displayConsultationEditionsEquipePanel(Equipe equipe) {
        this.setMainFrame(new ConsultationEditionsEquipePanel(this, equipe));
    }
    
    public void displayConsultationInscriptionsEquipePanel(Equipe equipe) {
        this.setMainFrame(new ConsultationInscriptionsEquipePanel(this, equipe));
    }
    
    public void displayConsultationEditionsCoureurPanel(Coureur coureur) {
        this.setMainFrame(new ConsultationEditionsCoureurPanel(this, coureur));
    }
    
    public void displayCourseEnCoursPanel(Etape etape) {
        this.setMainFrame(new CourseEnCoursPanel(this, etape));
    }
    
    public void displayConsultationMeilleursCategoriePanel() {
        this.setMainFrame(new ConsultationMeilleursCategoriePanel(this));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
