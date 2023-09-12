
package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlumnoData {
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    public AlumnoData(){
    }
    public void GuardarAlum(Alumno alumno){
         
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        }finally{
            try {
               //ps.close();
               // rs.close();
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT dni, apellido, nombre, fechaNac FROM alumnos WHERE idAlumno = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1,id );

            ResultSet rs = ps.executeQuery(); 
                
            if (rs.next()) {
                alumno=new Alumno();
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        
        return alumno; 
    }

     
    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNac FROM alumnos WHERE dni=? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1,dni );
            ResultSet rs = ps.executeQuery(); 
        
            if (rs.next()) {
                alumno=new Alumno();
                alumno.setId(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true); 
            
            } 
//            else {
//                JOptionPane.showMessageDialog(null, "No existe el alumno");
//            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
        }
    
        return alumno;
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
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
        }
        return alumnos;
    }

     
    public void modificarAlumno(Alumno alumno){
        
        String sql = "UPDATE alumnos SET dni = ? , apellido = ?, nombre = ?, fechaNac = ? WHERE idAlumno = ?";
        PreparedStatement ps = null; 
        
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getId());
            int exito = ps.executeUpdate(); 
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El alumno no existe");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
            }
    }
     
    public void eliminarAlumno(int id) { 
        
    try {
        String sql = "UPDATE alumnos SET estado = 0 WHERE idAlumno = ? ";
        PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
        ps.setInt(1, id);
        int fila=ps.executeUpdate(); 
        if(fila==1){
            JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
        }
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
    }
    }
    

}