//ConexionBD.java
package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Samuel Vega & Victor Gonzalez
 */
public class ConexionBD implements IConexionBD {
    //Variables de la clase
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;
    /**
     * Constructor que inicializa las variables al valor de sus parámetros
     * @param cadena_conexion
     * @param usuario
     * @param password 
     */
    public ConexionBD(String cadenaConexion, String usuario, String password){
        this.CADENA_CONEXION = cadenaConexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }
    /**
     * Crea una conexión hacia la base de datos que se dicte
     * @return Una conexion a la base de datos
     * @throws java.sql.SQLException
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }
}
