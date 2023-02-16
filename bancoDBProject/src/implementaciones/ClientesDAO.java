//ClientesDAO.java
package implementaciones;

import dominio.Cliente;
import excepciones.DAOException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import util.ConfigPaginado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;

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
        String sql = "select * from clientes where id = ?";
        try(Connection conexion = MANEJADOR_CONEXIONES.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);){
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            while(resultado.next()){
                Integer idCliente = resultado.getInt("id");
                String nombre = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Integer idDomicilio = resultado.getInt("id_domicilio");
                cliente = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio);
            }
            conexion.close();
            return cliente;
        }catch(SQLException e){
            LOG.log(Level.SEVERE, "No se pudo consultar el cliente ", e.getMessage());
            throw new DAOException("No se pudo consultar el cliente " + e.getMessage());
        }
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
