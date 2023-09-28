package AccesoADatos;

import Entidades.*;
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
                + " VALUES (?,?,?)";

        try {
            ps = Conexion.getConexion().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getId());
            ps.setInt(2, insc.getMateria().getId());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();

            resultado = ps.getGeneratedKeys();
            if (resultado.next()) {
                insc.setId(resultado.getInt(1));
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

        SQL = "SELECT a.idAlumno, a.nombre AS nombre_alumno, a.apellido AS apellido_alumno, a.dni, a.fechaNac, a.estado AS estado_alumnos, "
                + "m.idMateria, m.nombre AS nombre_materias, m.anio, m.estado AS estado_materias, i.idInscripciones, i.nota "
                + "FROM alumnos AS a "
                + "INNER JOIN inscripciones AS i ON a.idAlumno = i.idAlumno "
                + "INNER JOIN materias AS m ON i.idMateria = m.idMateria;";
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                
                nuevo = new Alumno(resultado.getInt("idAlumno"), resultado.getString("apellido_alumno"), resultado.getString("nombre_alumno"), resultado.getInt("dni"), resultado.getDate("fechaNac").toLocalDate(), resultado.getBoolean("estado_alumnos"));
                mate = new Materia(resultado.getInt("idMateria"), resultado.getString("nombre_materias"), resultado.getInt("anio"), resultado.getBoolean("estado_materias"));
                encontrada = new Inscripcion(resultado.getInt("idInscripciones"), nuevo, mate, resultado.getDouble("nota"));
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
        SQL = "SELECT i.idMateria, i.idInscripciones, i.nota, m.nombre, m.anio,m.idMateria, a.idAlumno, a.nombre AS nombre_alumno, a.apellido, a.dni, a.fechaNac, a.estado "
            + "FROM inscripciones AS i, materias AS m, alumnos AS a "
            + "WHERE i.idMateria = m.idMateria AND i.idAlumno = ? AND a.idAlumno = ? AND m.estado = 1";
        Inscripcion nueva;
        Alumno nuevo;
        Materia mate;

        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, id);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                nuevo = new Alumno(resultado.getInt("idAlumno"), resultado.getString("apellido"), resultado.getString("nombre_alumno"), resultado.getInt("dni"), resultado.getDate("fechaNac").toLocalDate(), resultado.getBoolean("estado"));
                mate = new Materia(resultado.getInt("idMateria"), resultado.getString("nombre"), resultado.getInt("anio"), true);
                nueva = new Inscripcion(resultado.getInt("idInscripciones"), nuevo, mate, resultado.getDouble("nota"));
                lista.add(nueva);
                
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
        return lista;

    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> lista = new ArrayList<>();
        SQL = "SELECT m.idMateria, m.nombre, m.anio, m.estado "
                + "FROM materias AS m "
                + "INNER JOIN inscripciones AS i ON m.idMateria = i.idMateria "
                + "WHERE i.idAlumno = ? AND m.estado = 1;";
        Materia nueva;
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                nueva = new Materia(resultado.getInt("idMateria"), resultado.getString("nombre"), resultado.getInt("anio"), true);
                lista.add(nueva);
                
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
        return lista;
    }

    public List<Materia> obtenerMateriasNOCursadas(int id) {
        List<Materia> lista = new ArrayList<>();
        SQL = "SELECT m.idMateria, m.nombre, m.anio, m.estado "
            + "FROM materias AS m "
            + "LEFT JOIN inscripciones AS i ON m.idMateria = i.idMateria AND i.idAlumno = ? "
            + "WHERE i.idInscripciones IS NULL AND m.estado = 1;";
        Materia nueva;
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, id);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                nueva = new Materia(resultado.getInt("idMateria"), resultado.getString("nombre"), resultado.getInt("anio"), true);
                lista.add(nueva);
                
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
        return lista;

    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        SQL = "SELECT * FROM alumnos "
                + "INNER JOIN inscripciones AS i ON alumnos.idAlumno = i.idAlumno "
                + "WHERE i.idMateria = ? AND alumnos.estado = 1;";
        ArrayList alumnos = new ArrayList<>();
        Alumno encontrado;

        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, idMateria);
            resultado = ps.executeQuery();
            while (resultado.next()) {

                encontrado = new Alumno(resultado.getInt("idAlumno"), resultado.getString("apellido"), resultado.getString("nombre"), resultado.getInt("dni"), resultado.getDate("fechaNac").toLocalDate(), true);
                alumnos.add(encontrado);
                
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
        return alumnos;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        SQL = "DELETE FROM inscripciones WHERE idMateria = ? AND idAlumno = ?;";
        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            int estado = ps.executeUpdate();
            if (estado > 0) {
                JOptionPane.showMessageDialog(null, "Borrado Correctamente");
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
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        System.out.println(nota);
        SQL = "UPDATE inscripciones SET nota = ? WHERE idMateria = ? AND idAlumno = ?";

        try {
            ps = Conexion.getConexion().prepareStatement(SQL);
            ps.setDouble(1, nota);
            ps.setInt(2, idMateria);
            ps.setInt(3, idAlumno);
            System.out.println(ps);
            int estado = ps.executeUpdate();
            if (estado>0) {
                JOptionPane.showMessageDialog(null, "Actualizacion Correcta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Actualizacion Incorrecta");
        } finally {
            try {
                resultado.close();
                ps.close();
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
