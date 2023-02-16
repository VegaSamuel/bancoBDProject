//IClientesDAO.java
package interfaces;

import dominio.Cliente;
import excepciones.DAOException;
import java.util.List;
import util.ConfigPaginado;

/**
 * Esta interfaz establece los métodos para la gestión de persistencia en los clientes
 * @author Samuel Vega & Victor Gonzales
 */
public interface IClientesDAO {
    
    /**
     * Consulta los datos de un cliente
     * @param id Id del cliente a consultar
     * @return Los datos de un cliente
     * @throws DAOException Si no se encuentra al cliente
     */
    Cliente consultar(Integer id) throws DAOException;
    
    /**
     * Insertar un cliente a la base de datos
     * @param cliente Cliente a insertar
     * @return El cliente que se insertó
     * @throws DAOException Si no se logra insertar el cliente
     */
    Cliente insertar(Cliente cliente) throws DAOException;
    
    /**
     * Eliminar a un cliente de la base de datos
     * @param id Id del cliente a eliminar
     * @return El cliente eliminado
     * @throws DAOException Si no se logra eliminar el cliente
     */
    Cliente eliminar(Integer id) throws DAOException;
    
    /**
     * Consulta los datos de todos los clientes
     * @param configPaginado Configuración de paginación para la tabla
     * @return Una lista con los datos de todos los clientes
     * @throws DAOException Si no se pudo consultar a todos los clientes
     */
    List<Cliente> consultar(ConfigPaginado configPaginado) throws DAOException;
}
