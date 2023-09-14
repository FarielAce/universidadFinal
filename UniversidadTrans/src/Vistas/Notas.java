package Vistas;

import Entidades.Alumno;
import AccesoADatos.AlumnoData;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Notas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return c == 2;
        }
    };

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();

        jlseleccion.setText("Seleccione un alumno:");

        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtMaterias);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlseleccion)
                        .addGap(28, 28, 28)
                        .addComponent(jcbAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jbGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbsalir)))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlseleccion)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbsalir)
                    .addComponent(jbGuardar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
     int fila = jtMaterias.getSelectedRow();            //devuelve el numero de la fila seleccionada
     int idMat =(int) modelo.getValueAt(fila, 0);   //devuelve el valor de la fila seleccionada y columna 
     double nota = (double) modelo.getValueAt(fila, 2); 
     Alumno seleccionado = (Alumno)jcbAlumnos.getSelectedItem();
     Principal.controlInsc.actualizarNota(seleccionado.getId(), idMat, nota);
     mostrarMaterias(seleccionado);
     
     
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
dispose();        // cierra la pantalla
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        
        Alumno buscado = (Alumno) jcbAlumnos.getSelectedItem();
        mostrarMaterias(buscado);
        jbGuardar.setEnabled(true);

    }//GEN-LAST:event_jcbAlumnosActionPerformed


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
