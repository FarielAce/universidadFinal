package AccesoADatos;

import Entidades.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlumnoData {

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public AlumnoData() {
    }

    public void GuardarAlum(Alumno alumno) {

        String sql = "INSERT INTO alumnos (dni, apellido, nombre, fechaNac, estado)"
                + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));//localDate a Date
            ps.setBoolean(5, alumno.isEstado()); // if reducido
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1)); //modifique para que tome el id generado
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            }

        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) { //verifica si el error se debe al DNI duplicado
                JOptionPane.showMessageDialog(null, "El DNI ya esta cargado en la Base de Datos, puede buscarlo y editarlo de ser necesario");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
            }
        } finally {
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT dni, apellido, nombre, fechaNac FROM alumnos WHERE idAlumno = ?";
        ps = null;
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }

        return alumno;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        String sql = "SELECT idAlumno, dni, apellido, nombre, estado, fechaNac FROM alumnos WHERE dni=?";
        ps = null;
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        } finally {
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }

            return alumno;
        }
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumnos WHERE estado = 1 ";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }finally{
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumnos SET dni = ? , apellido = ?, nombre = ?, fechaNac = ?, estado = ? WHERE idAlumno = ?";
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getId());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
                System.out.println(alumno.toString() + alumno.getId());
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }finally{
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarAlumno(int id) {

        try {
            String sql = "UPDATE alumnos SET estado = 0 WHERE idAlumno = ? ";
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }finally{
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
