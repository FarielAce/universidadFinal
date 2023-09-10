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
       InscripcionData inscribe = new InscripcionData();
       
       inscribe.obtenerInscripciones();
    }
    
}
