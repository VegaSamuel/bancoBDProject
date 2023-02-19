//Domicilios.java
package implementaciones;

import dominio.Domicilio;
import excepciones.DAOException;
import interfaces.IConexionBD;
import interfaces.IDomicilioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfigPaginado;

/**
 *
 * @author Samuel Vega & Victor Gonzalez
 */
public class DomiciliosDAO implements IDomicilioDAO {
    private static final Logger LOG = Logger.getLogger(DomiciliosDAO.class.getName());
    private final IConexionBD MANAGER;
    
    public DomiciliosDAO(IConexionBD ManejadorConexiones) {
        this.MANAGER = ManejadorConexiones;
    }

    @Override
    public Domicilio consultar(Integer id) throws DAOException {
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement("select * from domicilios where id = ?")
        ) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            Domicilio domicilio = null;
            if(resultado.next()) {
                Integer idDomicilio = resultado.getInt("id");
                String calle = resultado.getString("calle");
                Integer numero = resultado.getInt("numero");
                String colonia = resultado.getString("colonia");
                domicilio = new Domicilio(idDomicilio, calle, numero, colonia);
            }
            return domicilio;
        } catch(SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar el domicilio {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar el domicilio " + ex.getMessage());
        }
    }

    @Override
    public Domicilio insertar(Domicilio domicilio) throws DAOException {
        String sql = "insert into domicilio "
                    + "(calle, numero, colonia)";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS);
        ){
            comando.setString(1, domicilio.getCalle());
            comando.setInt(2, domicilio.getNumero());
            comando.setString(3, domicilio.getColonia());
            comando.executeUpdate();
            ResultSet registroLlaves = comando.getGeneratedKeys();
            if (registroLlaves.next()){
                Integer llave = registroLlaves.getInt(Statement.RETURN_GENERATED_KEYS);
                domicilio.setId(llave);
                return domicilio;
            }
            LOG.log(Level.WARNING, "Se insertó el domicilio sin mostrar la ID");
            throw new DAOException("Se insertó el domicilio sin mostrar la ID");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar el domicilio {0}", ex.getMessage());
            throw new DAOException("No se pudo insertar el domicilio " + ex.getMessage());
        }
    }

    @Override
    public Domicilio eliminar(Integer id) throws DAOException {
        Domicilio domicilio = this.consultar(id);
        String codigoBD = "delete from domicilio where id = ?";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD);
        ){
            comando.setInt(1, id);
            boolean eliminaDomicilio = comando.execute();
            return (eliminaDomicilio) ? domicilio : null;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo eliminar el domicilio {0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar el domicilio " + ex.getMessage());
        }
    }

    @Override
    public List<Domicilio> consultar(ConfigPaginado configPaginado) throws DAOException {
        String sql = "select * from domicilio "
                   + "limit ? offset ?";
        List<Domicilio> listaDomicilio = new LinkedList<>();
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
        ){
            comando.setInt(1, configPaginado.getElemPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()) {
                Integer id = resultado.getInt("id");
                String calle = resultado.getString("calle");
                Integer numero = resultado.getInt("numero");
                String colonia = resultado.getString("colonia");
                Domicilio domicilio = new Domicilio(id, calle, numero, colonia);
                listaDomicilio.add(domicilio);
            }
            return listaDomicilio;
        }catch(SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la lista de domicilios {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar la lista de domicilios " + ex.getMessage());
        }
    } 
}