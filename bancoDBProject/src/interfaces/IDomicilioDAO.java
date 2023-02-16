//IDomicilio.java
package interfaces;

import dominio.Domicilio;
import excepciones.DAOException;
import java.util.List;
import util.ConfigPaginado;

/**
 *
 * @author Samuel Vega & Victor Gonzales
 */
public interface IDomicilioDAO {
    
    /**
     * Consulta el domicilio de un cliente
     * @param id Id del cliente
     * @return Los datos del domicilio de un cliente
     * @throws DAOException Si no encuentra el domicilio
     */
    Domicilio consultar(Integer id) throws DAOException;
    
    /**
     * Inserta un domicilio
     * @param domicilio El domicilio a insertar
     * @return El domicilio insertado
     * @throws DAOException Si no se puede insertar el domicilio
     */
    Domicilio insertar(Domicilio domicilio) throws DAOException;
    
    /**
     * Elimina un domicilio con su id
     * @param id Id del domicilio
     * @return El domicilio eliminado
     * @throws DAOException Si no encuentra el domicilio o no se pudo eliminar
     */
    Domicilio eliminar(Integer id) throws DAOException;
    
    /**
     * Consulta todos los domicilios de todos los clientes
     * @param configPaginado Configuración de paginación para la tabla
     * @return Una lista de domicilios
     * @throws DAOException Si no encuentra todos los domicilios
     */
    List<Domicilio> consultar(ConfigPaginado configPaginado) throws DAOException;
}
