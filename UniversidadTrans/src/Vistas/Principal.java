package Vistas;

import AccesoADatos.*;
import Entidades.Alumno;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;


public class Principal extends javax.swing.JFrame {

public static AlumnoData controlAlu = new AlumnoData();
public static MateriaData controlMat = new MateriaData();
public static InscripcionData controlInsc = new InscripcionData();


    public Principal() {
        setTitle("Universidad Transversal");
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

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmGestionAlumnos = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmGestionMaterias = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jmInscripciones = new javax.swing.JMenuItem();
        jmNotas = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmAlumnoPorMateria = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");
        jmAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlumnoActionPerformed(evt);
            }
        });

        jmGestionAlumnos.setText("Formulario de Alumno");
        jmGestionAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionAlumnosActionPerformed(evt);
            }
        });
        jmAlumno.add(jmGestionAlumnos);

        jMenuBar1.add(jmAlumno);

        jmMateria.setText("Materia");

        jmGestionMaterias.setText("Formulario de Materia");
        jmGestionMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionMateriasActionPerformed(evt);
            }
        });
        jmMateria.add(jmGestionMaterias);

        jMenuBar1.add(jmMateria);

        jmAdministracion.setText("Administración");
        jmAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAdministracionActionPerformed(evt);
            }
        });

        jmInscripciones.setText("Manejo de inscripciones");
        jmInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInscripcionesActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmInscripciones);

        jmNotas.setText("Manipulación de Notas");
        jmNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNotasActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmNotas);

        jMenuBar1.add(jmAdministracion);

        jmConsultas.setText("Consultas");

        jmAlumnoPorMateria.setText("Alumnos por materia");
        jmAlumnoPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlumnoPorMateriaActionPerformed(evt);
            }
        });
        jmConsultas.add(jmAlumnoPorMateria);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmSalirMousePressed(evt);
            }
        });
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNotasActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        Notas calific = new Notas();
        calific.setVisible(true);
        Escritorio.add(calific);
        Escritorio.moveToFront(calific);    }//GEN-LAST:event_jmNotasActionPerformed

    private void jmGestionAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionAlumnosActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        GestionAlumnos alu = new GestionAlumnos();
        alu.setVisible(true);
        Escritorio.add(alu);
        Escritorio.moveToFront(alu);

    }//GEN-LAST:event_jmGestionAlumnosActionPerformed

    private void jmAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmAlumnoActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        
    }//GEN-LAST:event_jmSalirActionPerformed

    private void jmGestionMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionMateriasActionPerformed
        // TODO add your handling code here:
        Escritorio.removeAll();
        Escritorio.repaint();
        GestionMaterias mat = new GestionMaterias();
        mat.setVisible(true);
        Escritorio.add(mat);
        Escritorio.moveToFront(mat);
        
    }//GEN-LAST:event_jmGestionMateriasActionPerformed

    private void jmAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAdministracionActionPerformed
       
    }//GEN-LAST:event_jmAdministracionActionPerformed

    private void jmInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInscripcionesActionPerformed
      Escritorio.removeAll();
        Escritorio.repaint();
        InscripcionesForm inscripcion = new InscripcionesForm();
        inscripcion.setVisible(true);
        Escritorio.add(inscripcion);
        Escritorio.moveToFront(inscripcion);
    }//GEN-LAST:event_jmInscripcionesActionPerformed

    private void jmAlumnoPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlumnoPorMateriaActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        ConsultaAlumnMate cam = new ConsultaAlumnMate();
        cam.setVisible(true);
        Escritorio.add(cam);
        Escritorio.moveToFront(cam);                                           

        
    }//GEN-LAST:event_jmAlumnoPorMateriaActionPerformed

    private void jmSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMousePressed
        
        Object[] opciones = {"SI", "NO"};
            
        int opcion = JOptionPane.showOptionDialog(null,
            "¿Desea salir del sistema?",
            "Confirmacion",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.YES_NO_OPTION,
            null, opciones, opciones[1]);
                        
            if (opcion == JOptionPane.YES_OPTION) {
                dispose();
            } else if (opcion == JOptionPane.NO_OPTION) {
          
            }        
    }//GEN-LAST:event_jmSalirMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenuItem jmAlumnoPorMateria;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenuItem jmGestionAlumnos;
    private javax.swing.JMenuItem jmGestionMaterias;
    private javax.swing.JMenuItem jmInscripciones;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenuItem jmNotas;
    private javax.swing.JMenu jmSalir;
    // End of variables declaration//GEN-END:variables
}
