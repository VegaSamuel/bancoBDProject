//IConexionDB.java
package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Esta interfaz establece los métodos necesarios para la conexión a una base de datos
 * @author Samuel Vega & Victor Gonzales
 */
public interface IConexionBD {
    
    /**
     * Este método crea la conexión a una base de datos
     * @return Una conexión a una base de datos
     * @throws SQLException Si la conexión falla
     */
    Connection crearConexion() throws SQLException;
}
