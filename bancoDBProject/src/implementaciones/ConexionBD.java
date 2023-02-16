//ConexionBD.java
package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Samuel Vega & Victor Gonzales
 */
public class ConexionBD implements IConexionBD {
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;
    
    /**
     * 
     * @param cadenaConexion
     * @param usuario
     * @param password 
     */
    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.CADENA_CONEXION = cadenaConexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }
}
