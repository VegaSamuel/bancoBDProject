//CuentaDAO.java
package implementaciones;

import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

import dominio.Cuenta;
import excepciones.DAOException;
import interfaces.IConexionBD;
import interfaces.ICuentaDAO;
import util.ConfigPaginado;

/**
 *
 * @author Samuel Vega & Victor Gonzalez
 */
public class CuentaDAO implements ICuentaDAO {
    private static final Logger log = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD Manager;

    @Override
    public Cuenta consultar(Integer numero) throws DAOException {
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(
                "select * from cuentas where id = ?");  
        ){
            comando.setInt(1, numero);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()){
                Integer no_cuenta = resultado.getInt("no_cuenta");
                Date fecha_apertura = resultado.getDate("fecha_apertura");
                Float saldo = resultado.getFloat("saldo");
                Integer id_cliente = resultado.getInt("id_cliente");
                Cuenta cuenta = new Cuenta(no_cuenta, fecha_apertura, saldo, id_cliente);
            }
            return cuenta;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la cuenta "
                    + "{0}", ex.getMessage());
            throw new DAOException("No se pudo consultar la "
                    + "cuenta " + ex.getMessage());
        }
    }

    @Override
    public Cuenta insertar(Cuenta cuenta) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cuenta eliminar(Integer noCuenta) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Cuenta> consultar(ConfigPaginado condigPaginado) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
