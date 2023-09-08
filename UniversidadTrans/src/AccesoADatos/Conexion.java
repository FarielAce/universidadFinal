package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
       private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String USER = "root";
    private static final String PASS = "";
         
    public static Connection getConexion(){
        Connection conexion = null;   
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERROR DE CONEXION CON EL SERVIDOR");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR DE DRIVER");
        }
    return conexion;
    }
    
}
