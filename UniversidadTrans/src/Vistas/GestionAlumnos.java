/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Alumno;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class GestionAlumnos extends javax.swing.JInternalFrame {
    
    Alumno buscado; //declaro el alumno buscado como variable global. para poder utilizarla en el boton eliminar.-

    /**
     * Creates new form GestionAlumno
     */
    public GestionAlumnos() {
        setTitle("Gestion Alumnos");
        initComponents();
        bloquear(false);
        blkEliminar(false);
        blkGuardar(false);
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
        jtDocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jrEstado = new javax.swing.JRadioButton();
        jdFechaNac = new com.toedter.calendar.JDateChooser();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Documento:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento:");

        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LUPA.png"))); // NOI18N
        jbBuscar.setText("buscar");
        jbBuscar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LUPA.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNuevo.setText("nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jbNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrEstado)
                            .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(jtNombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jbBuscar)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtApellido)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtNombre)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrEstado)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbEliminar)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (jtDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un DNI");
        } else {
            int dni = Integer.parseInt(jtDocumento.getText());
            buscado = Principal.controlAlu.buscarAlumnoPorDni(dni);
            if (buscado == null) {
                JOptionPane.showMessageDialog(null, "No se encuentra el alumno");
            } else {
                jtNombre.setText(buscado.getNombre());
                jtApellido.setText(buscado.getApellido());
                jrEstado.setSelected(buscado.isEstado());
                jdFechaNac.setDate(java.sql.Date.valueOf(buscado.getFechaNac()));
                blkEliminar(true);
            }
            
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarJt();
        bloquear(true);
        blkGuardar(true);

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Date fecha = jdFechaNac.getDate();
        if (jtDocumento.getText().isEmpty() || jtApellido.getText().isEmpty() || jtNombre.getText().isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(null, "todos los datos son obligatorios");
        } else {
            Object[] opciones = {"SI", "NO", "CANCELAR"};
            
            int opcion = JOptionPane.showOptionDialog(null,
                    "¿Todos los datos son Correctos?",
                    "Confirmacion",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    null, opciones, opciones[2]);
            jrEstado.setSelected(true);
            jrEstado.setEnabled(false);
            
            if (opcion == JOptionPane.YES_OPTION) {
                int dni = Integer.parseInt(jtDocumento.getText());
                String nombre = jtNombre.getText();
                String apellido = jtApellido.getText();
                LocalDate fechaNac = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                System.out.println(dni + " " + nombre + apellido + fechaNac);
                Alumno nuevo = new Alumno(apellido, nombre, dni, fechaNac, true);
                Principal.controlAlu.GuardarAlum(nuevo);
                limpiarJt();
                blkGuardar(false);
            } else if (opcion == JOptionPane.NO_OPTION) {
                
            } else if (opcion == JOptionPane.CANCEL_OPTION) {
                limpiarJt();
                bloquear(false);
                blkGuardar(false);
            }
            
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();

    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
        Object[] opciones = {"SI", "NO", "CANCELAR"};
        
        int opcion = JOptionPane.showOptionDialog(null,
                "¿Esta seguro de eliminar el alumno?",
                "Confirmacion",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.YES_NO_CANCEL_OPTION,
                null, opciones, opciones[2]);
        
        if (opcion == JOptionPane.YES_OPTION) {
            Principal.controlAlu.eliminarAlumno(buscado.getId());
            limpiarJt();
            blkEliminar(false);
            
        } else if (opcion == JOptionPane.NO_OPTION) {
            
        } else if (opcion == JOptionPane.CANCEL_OPTION) {
            limpiarJt();
            bloquear(false);
            blkEliminar(false);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdFechaNac;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
    public void bloquear(boolean estado) {
        jtApellido.setEnabled(estado);
        jtNombre.setEnabled(estado);
        jrEstado.setEnabled(estado);
        jdFechaNac.setEnabled(estado);
    }
    
    public void blkEliminar(boolean estado) {
        
        jbEliminar.setEnabled(estado);
    }
    
    public void blkGuardar(boolean estado) {
        jbGuardar.setEnabled(estado);
    }
    
    public void limpiarJt() {
        jtApellido.setText("");
        jtNombre.setText("");
        jtDocumento.setText("");
        jdFechaNac.setDate(null);
        
    }
}
