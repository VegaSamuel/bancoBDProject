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
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;

/**
 * Esta clase contiene la gestión de persistencia con los datos de los clientes
 * @author Samuel & Victor Gonzalez
 */
public class ClientesDAO implements IClientesDAO {
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD MANAGER;
    
    public ClientesDAO(IConexionBD manejadorConexiones) {
        this.MANAGER = manejadorConexiones;
    }
    
    @Override
    public Cliente consultar(Integer id) throws DAOException {
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(
                "select * from clientes where id = ?");  
        ){
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()){
                String nombres = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Integer idDomicilio = resultado.getInt("id_domicilio");
                cliente = new Cliente(nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio);
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
        String sql = "insert into clientes "
                    + "(nombres, apellido_paterno, apellido_materno, "
                    + "fecha_nacimiento, id_domicilio)";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS);
        ){
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setDate(4, cliente.getFechaNacimiento());
            comando.setInt(5, cliente.getIdDomicilio());
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
            LOG.log(Level.SEVERE, "No se pudo insertar al cliente {0}", ex.getMessage());
            throw new DAOException("No se pudo insertar al cliente " + ex.getMessage());
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
            LOG.log(Level.SEVERE, "No se pudo eliminar el cliente {0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar el cliente " + ex.getMessage());
        }
    }
    
    @Override
    public List<Cliente> consultar(ConfigPaginado configPaginado) throws DAOException {
        String codigoBD = "select nombres, apellido_paterno, "
                + "apellido_materno, fecha_nacimiento, id_domicilio from clientes "
                + "limit ? offset ?";
        List<Cliente> listaClientes = new LinkedList<>();
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD);
        ){
            comando.setInt(1, configPaginado.getElemPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Integer idDomicilio = resultado.getInt("id_domicilio");
                Cliente cliente = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio);
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo eliminar el cliente {0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar el cliente " + ex.getMessage());
        }
    }
}
