/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadtrans;

import AccesoADatos.Conexion;
import AccesoADatos.InscripcionData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Test
 */
public class UniversidadTrans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        
        
       String SQL = "SELECT\n" +
"    a.idAlumno,\n" +
"    a.nombre AS nombre_alumno,\n" +
"    a.apellido AS apellido_alumno,\n" +
"    a.dni,\n" +
"    a.fechaNac,\n" +
"    a.estado AS estado_alumnos,\n" +
"    m.idMateria,\n" +
"    m.nombre AS nombre_materias,\n" +
"    m.anio,\n" +
"    m.estado AS estado_materias,\n" +
"    i.idInscripciones,\n" +
"    i.nota\n" +
"FROM\n" +
"    alumnos AS a\n" +
"INNER JOIN\n" +
"    inscripciones AS i ON a.idAlumno = i.idAlumno\n" +
"INNER JOIN\n" +
"    materias AS m ON i.idMateria = m.idMateria;";
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                System.out.println(resultado.getString(1)+resultado.getString(2)+resultado.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }

    }
    
}
