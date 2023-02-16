//ICuentaDAO.java
package interfaces;

import dominio.Cuenta;
import excepciones.DAOException;
import java.util.List;
import util.ConfigPaginado;

/**
 *
 * @author Samuel Vega & Victor Gonzales
 */
public interface ICuentaDAO {
    
    /**
     * Consulta una cuenta de un cliente
     * @param noCuenta Número de cuenta
     * @return Los datos de la cuenta de un cliente
     * @throws DAOException Si no se encuentra la cuenta
     */
    Cuenta consultar(Integer noCuenta) throws DAOException;
    
    /**
     * Inserta una cuenta de un cliente
     * @param cuenta Cuenta a insertar
     * @return
     * @throws DAOException 
     */
    Cuenta insertar(Cuenta cuenta) throws DAOException;
    
    /**
     * Elimina una cuenta de un cliente
     * @param noCuenta Número de cuenta
     * @return La cuenta eliminada
     * @throws DAOException Si no se encuentra la cuenta o no se pudo eliminar
     */
    Cuenta eliminar(Integer noCuenta) throws DAOException;
    
    /**
     * Consulta todas las cuentas de todos los clientes
     * @param condigPaginado Configuración de paginación para la tabla 
     * @return Una lista con todas las cuentas
     * @throws DAOException Si no se pudo consultar a todas las cuentas
     */
    List<Cuenta> consultar(ConfigPaginado condigPaginado) throws DAOException;
}
