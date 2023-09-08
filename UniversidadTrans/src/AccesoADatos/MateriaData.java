/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MateriaData {
    private String SQL;
    private PreparedStatement ps = null;
    private ResultSet resultado = null;
    
   
      
    public void guardarMateria(Materia materia){
        String sql = "INSERT INTO Materia (id, nombre, anio, estado) VALUES (?, ?, ?, ?)";
     try {
         PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1, materia.getId());
         ps.setString(2, materia.getNombre());
         ps.setInt(3, materia.getAnio());
         ps.setBoolean(4, materia.isEstado()); 
         ps.executeUpdate();
         ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
             materia.setId(rs.getInt("idMateria"));
         JOptionPane.showMessageDialog(null, "Materia añadida con exito."); 

            }
         ps.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia"+ex.getMessage()); 

        }finally{
            try {
                ps.close();
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   } 
    
   /* public void buscarMateria(int id){
        String sql = "SELECT id, nombre, anio, estado FROM materia WHERE idMateria = ? AND estado = 1";
        
        try {
         PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1, id);
         
    
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
}  
   
        
        
    

    
    

    

