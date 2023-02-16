//ClientesDAO.java
package implementaciones;

import dominio.Cliente;
import excepciones.DAOException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.util.List;
import java.util.logging.Logger;
import util.ConfigPaginado;

/**
 * Esta clase contiene la gestión de persistencia con los datos de los clientes
 * @author Samuel & Victor Gonzales
 */
public class ClientesDAO implements IClientesDAO {
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANEJADOR_CONEXIONES;
    
    public ClientesDAO(IConexionBD manejadorConexiones) {
        this.MANEJADOR_CONEXIONES = manejadorConexiones;
    }
    
    @Override
    public Cliente consultar(Integer id) throws DAOException {
        return null;
    }
    
    @Override
    public Cliente insertar(Cliente cliente) throws DAOException {
        return null;
    }
    
    @Override
    public Cliente eliminar(Integer id) throws DAOException {
        return null;
    }
    
    @Override
    public List<Cliente> consultar(ConfigPaginado configPaginado) throws DAOException {
        return null;
    }
}
