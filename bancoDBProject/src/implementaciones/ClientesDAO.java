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
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(
                "select nombres, apellido_paterno, "
                + "apellido_materno, fecha_nacimiento, "
                + "id_domicilio from clientes where id = ?");  
        ){
            comando.setInt(1, id);
            ResultSet registro = comando.executeQuery();
            Cliente cliente = null;
            if (registro.next()){
                String nombres = registro.getString("nombres");
                String apellido_paterno = 
                        registro.getString("apellido_paterno");
                String apellido_materno = 
                        registro.getString("apellido_materno");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Integer id_domicilio = registro.getInt("id_domicilio");
                cliente = new Cliente(nombres, apellido_paterno, 
                        apellido_materno, fecha_nacimiento, id_domicilio);
            }
            return cliente;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar el cliente "
                    + "{0}", ex.getMessage());
            throw new DAOException("No se pudo consultar el "
                    + "cliente " + ex.getMessage());
        }
    }
    
    @Override
    public Cliente insertar(Cliente cliente) throws DAOException {
        String codigoBD = "insert into clientes "
                    + "(nombres, apellido_paterno, apellido_materno, "
                    + "fecha_nacimiento, id_domicilio)";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD, 
                    Statement.RETURN_GENERATED_KEYS);
        ){
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellido_paterno());
            comando.setString(3, cliente.getApellido_materno());
            comando.setDate(4, cliente.getFecha_nacimiento());
            comando.setInt(5, cliente.getId_domicilio());
            comando.executeUpdate();
            ResultSet registroLlaves = comando.getGeneratedKeys();
            if (registroLlaves.next()){
                Integer llave = registroLlaves.getInt(Statement.RETURN_GENERATED_KEYS);
                cliente.setId(llave);
                return cliente;
            }
            LOG.log(Level.WARNING, "Se insertó el cliente sin mostrar la ID");
            throw new DAOException("Se insertó el cliente sin mostrar la ID");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar al cliente "
                    + "{0}", ex.getMessage());
            throw new DAOException("No se pudo insertar al "
                    + "cliente " + ex.getMessage());
        }
    }
    
    @Override
    public Cliente eliminar(Integer id) throws DAOException {
        Cliente cliente = this.consultar(id);
        String codigoBD = "delete from clientes where id = ?";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD);
        ){
            comando.setInt(1, id);
            boolean eliminaCliente = comando.execute();
            return (eliminaCliente) ? cliente : null;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo eliminar el cliente "
                    + "{0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar el "
                    + "cliente " + ex.getMessage());
        }
    }
    
    @Override
    public List<Cliente> consultar(ConfigPaginado configPaginado) throws DAOException {
        String codigoBD = "select nombres, apellido_paterno, "
                + "apellido_materno, fecha_nacimiento, id_direccion from clientes "
                + "limit ? offset ?";
        List<Cliente> listaClientes = new LinkedList<>();
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD);
        ){
            comando.setInt(1, configPaginado.getElemPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet registro = comando.executeQuery();
            while(registro.next()){
                String nombres = registro.getString("nombres");
                String apellido_paterno = 
                        registro.getString("apellido_paterno");
                String apellido_materno = 
                        registro.getString("apellido_materno");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Integer id_domicilio = registro.getInt("id_domicilio");
                Cliente cliente = new Cliente(id, nombre, apellido_paterno, 
                        apellido_materno, id_direccion);
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo eliminar el cliente "
                    + "{0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar el "
                    + "cliente " + ex.getMessage());
        }
    }
}
