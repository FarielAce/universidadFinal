
package AccesoADatos;

import Entidades.Materia;
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

/**
 *
 * @author Usuario
 */
public class MateriaData {
    
    private PreparedStatement ps = null;
    private ResultSet resultado = null;
    
   
      
    public void GuardarMateria(Materia materia){
        String sql = "INSERT INTO Materias (idMateria, nombre, anio, estado) VALUES (?, ?, ?, ?)";
     try {
         PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1, materia.getId());
         ps.setString(2, materia.getNombre());
         ps.setInt(3, materia.getAnio());
         ps.setBoolean(4, materia.isEstado()); 
         ps.executeUpdate();
         ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito."); 
            }
         ps.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage()); 

        }/*finally{
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
   } 
    
    public Materia buscarMateria(int id){
        Materia materia = null;
        String sql = "SELECT nombre, anio, estado FROM materias WHERE idMateria = ?";
        PreparedStatement ps = null;
    
        try {
            ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
         
            if (rs.next()) {
                materia=new Materia();
                materia.setId(id); 
                materia.setNombre(rs.getString("Nombre"));
                materia.setAnio(rs.getInt("Anio")); 
                materia.setEstado(rs.getBoolean("estado")); 
             
            }else {
                JOptionPane.showMessageDialog(null, "No hay materia registrada con ese codigo");
                ps.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return materia;
       
    }
    
    
    public void modificarMateria(Materia materia){
    
     String sql = "UPDATE materias idMateria = ?, nombre = ?, anio = ?, estado = ?"
             + "  WHERE idMateria = ?";
     PreparedStatement ps = null;
     try {
       ps = Conexion.getConexion().prepareStatement(sql);
        ps.setInt(1, materia.getId());
        ps.setString(1, materia.getNombre());
        ps.setInt(2, materia.getAnio());
        ps.setBoolean(3, materia.isEstado());
        
         System.out.println(ps);
        
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "La materia no existe");
        }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia "+ex.getMessage());
        }

     }
    
    public void eliminarMateria(int id) {

        try {
            String sql = "UPDATE materias SET estado = 0 WHERE idMateria = ? ";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();

             if(fila==1){
                 JOptionPane.showMessageDialog(null, " Se eliminó el Materia");
             }
             ps.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia");
        }
    }
    
    public List<Materia> listarMateria() {

    List<Materia> materias = new ArrayList<>();
     try {
        String sql = "SELECT * FROM materias WHERE estado = 1 ";
        PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          Materia materia = new Materia();

        materia.setId(rs.getInt("idMateria"));
        materia.setNombre(rs.getString("nombre"));
        materia.setAnio(rs.getInt("Anio"));
        materia.setEstado(rs.getBoolean("estado"));
        materias.add(materia);

    }
    ps.close();

    
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia "+ex.getMessage());
    }
        return materias;
    
    }
    
 }

   
        
        
    

    
    

    

