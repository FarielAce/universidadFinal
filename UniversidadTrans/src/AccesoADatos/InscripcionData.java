package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
        List<Inscripcion> inscripciones = new ArrayList<>();
        Inscripcion encontrada;
        Alumno nuevo;
        Materia mate;

        SQL = "SELECT a.idAlumno, a.nombre AS nombre_alumno, a.apellido AS apellido_alumno, a.dni, a.fechaNac, a.estado AS estado_alumnos,\n"
                + "m.idMateria, m.nombre AS nombre_materias, m.anio, m.estado AS estado_materias, i.idInscripciones, i.nota\n"
                + "FROM alumnos AS a\n"
                + "INNER JOIN inscripciones AS i ON a.idAlumno = i.idAlumno\n"
                + "INNER JOIN materias AS m ON i.idMateria = m.idMateria;";
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                //(, , , resultado.getInt("dni"), , )
                nuevo = new Alumno(resultado.getInt("idAlumno"), resultado.getString("apellido_alumno"), resultado.getString("nombre_alumno"), resultado.getInt("dni"), resultado.getDate("fechaNac").toLocalDate(), resultado.getBoolean("estado_alumnos"));
                mate = new Materia(resultado.getInt("idMateria"), resultado.getString("nombre_materias"), resultado.getInt("anio"), resultado.getBoolean("estado_materias"));
                encontrada = new Inscripcion(resultado.getInt("idInscripciones"), nuevo, mate, resultado.getDouble("nota"));
                System.out.println(encontrada.toString() + "/n" + nuevo.toString() + "/n" + mate.toString());
                inscripciones.add(encontrada);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                resultado.close();
                ps.close();
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> lista = new ArrayList<>();
        SQL = "SELECT inscripciones.idMateria, nombre, anio "
                + "FROM inscripciones, materias "
                + "WHERE inscripciones.idMateria = materias.idMateria AND inscripciones.idAlumno = ?";
        Inscripcion nueva;
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            while (resultado.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return lista;

    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> lista = new ArrayList<>();
        SQL = "SELECT inscripciones.idMateria, nombre, anio "
                + "FROM inscripciones, materias "
                + "WHERE inscripciones.idMateria = materias.idMateria AND inscripciones.idAlumno = ?";
        Materia nueva;
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                nueva = new Materia(resultado.getInt("idMateria"), resultado.getString("nombre"), resultado.getInt("anio"), resultado.getBoolean("estado"));
                lista.add(nueva);
                System.out.println(nueva.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return lista;
    }

    public List<Materia> obtenerMatereiasNOCursadas(int id) {
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
    }

    public void actualizarNota(int idAlumno, int IdMateria, double nota) {
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
    }

}
