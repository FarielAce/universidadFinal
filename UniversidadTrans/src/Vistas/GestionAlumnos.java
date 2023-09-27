/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Alumno;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;

/**
 * @author Fernando Acevedo
 */
public class GestionAlumnos extends javax.swing.JInternalFrame {

    /*                               DECLARACION VARIABLE GLOBALES.
      -Se declara la variable Alumno buscado para utilizar el alumno recuperado en la busqueda
      en los diferentes botones(editar, eliminar)
      -Se declara el boolean alumnoEditadoGuardado para saber si es un alumno nuevo o bien procedente de
      una busqueda. de esta manera informa a al boton guardar que debe hacer si crear un nuevo alumno o 
      editar el seleccionado en la busqueda.
     */
    private Alumno buscado;
    private boolean alumnoEditadoGuardado = false;
    private boolean salir = false;

    /**
     * interface grafica para la gestion de alumnos
     */
    public GestionAlumnos() {
        setTitle("Gestion Alumnos");  //coloca en la barra de titulo el nombre
        initComponents();
        bloquear(false);              //bloquea los jTextField/jDateChoser para que no puedan editarse
        blkEliminar(false);           //Inicializa el boton Eliminar "apagado"
        blkGuardar(false);            //Inicializa el boton Guardar "apagado"
        
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
        jbEditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Documento:");

        jtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtDocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDocumentoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento:");

        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidoKeyTyped(evt);
            }
        });

        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jdFechaNac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdFechaNacMouseClicked(evt);
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

        jbNuevo.setText("Nuevo");
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

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jbBuscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jbNuevo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbEditar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addComponent(jbGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbSalir))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jrEstado)
                                .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                .addComponent(jtNombre))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jbSalir)
                    .addComponent(jbEditar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Captura el evento de tocar el JButton = jbBuscar. informa por pantalla de
     * encontrar el DNI del alumno buscado. ademas de habilitar o deshabilitar
     * los botones Guardar/Eliminar en caso de encontrar un alumno dado de baja.
     *
     */
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
       buscar();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        limpiarJt();
        jbBuscar.setEnabled(false);
        bloquear(true);
        blkGuardar(true);
        blkEliminar(false);
        jbEditar.setEnabled(false);
        salir = true;
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Date fecha = jdFechaNac.getDate();
        try {
            if (jtDocumento.getText().isEmpty() || jtApellido.getText().isEmpty() || jtNombre.getText().isEmpty() || fecha == null) {
                JOptionPane.showMessageDialog(null, "todos los datos son obligatorios");
            } else {
                Object[] opciones = {"SI", "NO", "CANCELAR"};       //Crea un Vector con los textos a mostrar
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
                    boolean estado = jrEstado.isSelected();
                    // verifica si el alumno a guardar es nuevo o se edita uno ya creado
                    if (alumnoEditadoGuardado) {
                        Alumno nuevo = new Alumno(buscado.getId(), apellido, nombre, dni, fechaNac, estado);
                        Principal.controlAlu.modificarAlumno(nuevo);
                        limpiarJt();
                        blkGuardar(false);
                        bloquear(false);
                        jbBuscar.setEnabled(true);
                        alumnoEditadoGuardado = false;
                    } else {
                        Alumno nuevo = new Alumno(apellido, nombre, dni, fechaNac, true);
                        Principal.controlAlu.GuardarAlum(nuevo);
                        limpiarJt();
                        blkGuardar(false);
                        bloquear(false);
                        jbBuscar.setEnabled(true);
                    }
                } else if (opcion == JOptionPane.NO_OPTION) {

                } else if (opcion == JOptionPane.CANCEL_OPTION) {
                    limpiarJt();
                    bloquear(false);
                    blkGuardar(false);
                    jbBuscar.setEnabled(true);
                }

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "el DNI solo puede contener numeros");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        if (salir) {
            Object[] opciones = {"Volver", "Salir"};

            int opcion = JOptionPane.showOptionDialog(null,
                    "¿Desea volver al menu anterior?",
                    "Confirmacion",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.YES_NO_OPTION,
                    null, opciones, opciones[1]);

            if (opcion == JOptionPane.YES_OPTION) {
                bloquear(false);
                blkEliminar(false);
                blkGuardar(false);
                jbBuscar.setEnabled(true);
                salir = false;
            } else {
                dispose();
            }

        } else {
            dispose();
        }
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
            jbEditar.setEnabled(false);

        } else if (opcion == JOptionPane.NO_OPTION) {

        } else if (opcion == JOptionPane.CANCEL_OPTION) {
            limpiarJt();
            bloquear(false);
            blkEliminar(false);
            jbEditar.setEnabled(false);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        bloquear(true);
        blkGuardar(true);
        blkEliminar(false);
        alumnoEditadoGuardado = true;
        jrEstado.setEnabled(true);
    }//GEN-LAST:event_jbEditarActionPerformed
    /*
    capturan la aplicacion de una tecla y valida que sea un caracter valido segun corresponda en 
    el jTextField qeu corresponde.
    */
    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped
         char c = evt.getKeyChar();
            if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE && c!= '\'') {
                evt.consume(); // Consumir el evento si no es una letra o espacio
            }
    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
    char c = evt.getKeyChar();
            if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                evt.consume(); // Consumir el evento si no es una letra o espacio
            }
             
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDocumentoKeyTyped
        char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Consumir el evento si no es una letra o espacio
            }
    }//GEN-LAST:event_jtDocumentoKeyTyped
    // reinicia el jDateChooser cada ves que se le hace clic. ya que una ves puesta la fecha no permitia modificarla
    private void jdFechaNacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdFechaNacMouseClicked
        jdFechaNac.setDate(null);
    }//GEN-LAST:event_jdFechaNacMouseClicked

    private void jtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDocumentoKeyPressed
       char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            buscar();
        }
    }//GEN-LAST:event_jtDocumentoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEditar;
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
        jbEditar.setEnabled(estado);
        if (!estado) {
            jtApellido.setDisabledTextColor(Color.BLACK);
            jtNombre.setDisabledTextColor(Color.BLACK);
            jtDocumento.setDisabledTextColor(Color.BLACK);
            //para poder editar los colores del JDateChooser
            //Castea el jTextField del JDateChooser en la variable editor para poder modificar su formato
            JTextFieldDateEditor editor = (JTextFieldDateEditor) jdFechaNac.getDateEditor();
            // se bloquea el JTextField que acompaña al JDateChooser
            editor.setEditable(estado);
            //Se le pone color negro al JtexField asociado
            editor.setDisabledTextColor(Color.BLACK);

        }
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
    
    public void buscar(){
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

                    if (buscado.isEstado()) {
                        blkEliminar(true);
                        jbEditar.setEnabled(true);
                    } else {
                        blkEliminar(false);
                        jbEditar.setEnabled(true);
                    }
                }
           
        }
 }
    }
