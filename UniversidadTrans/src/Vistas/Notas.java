package Vistas;

import Entidades.Alumno;
import AccesoADatos.AlumnoData;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Notas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    private boolean salir = false;          // revisa que se haya guardado el ultimo dato antes de salir
    private boolean noGuardada = true;      // revisa que se guarde la ultima nota antes permitir modificar otra

    public Notas() {
        setTitle("Carga de Notas");
        initComponents();
        cargarCombo();
        cargaCabecera();
        jbGuardar.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlseleccion = new javax.swing.JLabel();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jbGuardar = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();

        jlseleccion.setText("Seleccione un alumno:");

        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlseleccion)
                        .addGap(28, 28, 28)
                        .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbGuardar)
                                .addGap(258, 258, 258)
                                .addComponent(jbsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlseleccion)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbsalir)
                    .addComponent(jbGuardar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int fila = jtMaterias.getSelectedRow();            //devuelve el numero de la fila seleccionada
        int idMat = (int) modelo.getValueAt(fila, 0);   //devuelve el valor de la fila seleccionada y columna 
        double nota = (double) modelo.getValueAt(fila, 2);
        System.out.println(fila + ", " + idMat + ", " + nota);
        Alumno seleccionado = (Alumno) jcbAlumnos.getSelectedItem();
        Principal.controlInsc.actualizarNota(seleccionado.getId(), idMat, nota);
        mostrarMaterias(seleccionado);
        jbGuardar.setEnabled(false);
        salir = true;
        noGuardada = true;

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        if (!salir) {
            int condicion = JOptionPane.showConfirmDialog(this, "La ultima modificacion no fue guardada ¿Desea salir sin Guardar?");

            if (condicion == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }

        // cierra la pantalla
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed

        Alumno buscado = (Alumno) jcbAlumnos.getSelectedItem();
        mostrarMaterias(buscado);


    }//GEN-LAST:event_jcbAlumnosActionPerformed

    private void jtMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMateriasMouseClicked
       
        
        
        String dato = JOptionPane.showInputDialog("ingrese la nota a modificar");
        if (noGuardada) {

            try {
                double nota = Double.parseDouble(dato);
                if (nota <= 10 && nota > 0) {
                    jtMaterias.setValueAt(nota, jtMaterias.getSelectedRow(), 2);
                    jbGuardar.setEnabled(true);
                    salir = false;
                    noGuardada=false;
                } else {
                    JOptionPane.showMessageDialog(this, "la nota debe estar entre 1 y 10");
                }
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(this, "debe ingresar un numero");

            }
        }else{
        JOptionPane.showMessageDialog(this, "debe primero Guardar la ultima Modificacion");
        }
    }//GEN-LAST:event_jtMateriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbsalir;
    private javax.swing.JComboBox<Alumno> jcbAlumnos;
    private javax.swing.JLabel jlseleccion;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        for (Alumno aluCombo : Principal.controlAlu.listarAlumnos()) {
            jcbAlumnos.addItem(aluCombo);
        }
    }

    private void cargaCabecera() {
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jtMaterias.setModel(modelo);
    }

    private void limpiarTabla() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void mostrarMaterias(Alumno buscado) {
        limpiarTabla();
        for (Inscripcion inscripcion : Principal.controlInsc.obtenerInscripcionesPorAlumno(buscado.getId())) {
            modelo.addRow(new Object[]{inscripcion.getMateria().getId(), inscripcion.getMateria().getNombre(), inscripcion.getNota()});
        }
    }
}
