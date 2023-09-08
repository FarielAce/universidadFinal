
package AccesoADatos;
import Entidades.Inscripcion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InscripcionData {
    private String SQL;
    private PreparedStatement ps = null;
    private ResultSet resultado = null;
    
    public InscripcionData(){}
    
    public void guardarInscripcion(Inscripcion insc){
    SQL = "INSERT INTO `inscripciones`(`idAlumno`, `idMateria`, `nota`)"
            + " VALUES ('?','?','?')";
        try {
            Conexion.getConexion().prepareStatement();
        } finally {
        }
    
    }
    
}
