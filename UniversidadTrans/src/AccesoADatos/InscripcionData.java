package AccesoADatos;

import Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private String SQL;
    private PreparedStatement ps = null;
    private ResultSet resultado = null;

    public InscripcionData() {

    }

    public void guardarInscripcion(Inscripcion insc) {
        SQL = "INSERT INTO `inscripciones`(`idAlumno`, `idMateria`, `nota`)"
                + " VALUES ('?','?','?')";

        try {
            ps = Conexion.getConexion().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getId());
            ps.setInt(2, insc.getAlumno().getId());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();

            resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                insc.setId(resultado.getInt("idInscripciones"));
                JOptionPane.showMessageDialog(null, "Inscripcion Correcta");
            } else {
                JOptionPane.showMessageDialog(null, "Error de inscripcion");
            }

        } catch (SQLException ex) {

            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultado.close();
                ps.close();
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "se perdio la conexion con el servidor");
                Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList();
        inscripciones = null;
        Inscripcion encontrada;
        SQL = "SELECT  a.idAlumno,a.nombre AS nombre_alumno, a.apellido AS apellido_alumno,"
                + "a.dni, a.fechaNac, a.estado AS estado_alumno, m.idMateria,"
                + "m.nombre AS nombre_materia, m.anio,  m.estado AS estado_materia,"
                + "i.idInscripcion, i.nota"
                + "FROM alumno AS a  INNER JOIN inscripciones AS i ON a.idAlumno = i.idAlumno"
                + "INNER JOIN materia AS m ON i.idMateria = m.idMateria;";
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                System.out.println(resultado.getString(1)+resultado.getString(2)+resultado.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return inscripciones;
    }
//    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
//    
//    
//    }
 }
