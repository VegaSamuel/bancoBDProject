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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfigPaginado;

/**
 *
 * @author Samuel Vega & Victor Gonzales
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
                Integer numero = resultado.getInt("calle");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Domicilio eliminar(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Domicilio> consultar(ConfigPaginado configPaginado) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
