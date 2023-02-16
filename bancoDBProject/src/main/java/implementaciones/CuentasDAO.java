//CuentaDAO.java
package implementaciones;

import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;
import dominio.Cuenta;
import excepciones.DAOException;
import interfaces.IConexionBD;
import interfaces.ICuentaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import util.ConfigPaginado;

/**
 *
 * @author Samuel Vega & Victor Gonzalez
 */
public class CuentasDAO implements ICuentaDAO {
    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD MANAGER;

    public CuentasDAO(IConexionBD manejadorConexiones) {
        this.MANAGER = manejadorConexiones;
    }
    
    @Override
    public Cuenta consultar(Integer noCuenta) throws DAOException {
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(
                "select * from cuentas where id = ?");  
        ){
            comando.setInt(1, noCuenta);
            ResultSet resultado = comando.executeQuery();
            Cuenta cuenta = null;
            if (resultado.next()){
                Integer no_cuenta = resultado.getInt("no_cuenta");
                Date fecha_apertura = resultado.getDate("fecha_apertura");
                Float saldo = resultado.getFloat("saldo");
                Integer id_cliente = resultado.getInt("id_cliente");
                cuenta = new Cuenta(no_cuenta, fecha_apertura, saldo, id_cliente);
            }
            return cuenta;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la cuenta {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar la cuenta " + ex.getMessage());
        }
    }

    @Override
    public Cuenta insertar(Cuenta cuenta) throws DAOException {
        String sql = "insert into cuentas "
                    + "(fecha_apertura, saldo, id_cliente)";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS);
        ){
            comando.setDate(1, (Date) cuenta.getFechaApertura());
            comando.setFloat(2, cuenta.getSaldo());
            comando.setInt(3, cuenta.getIdClientes());
            comando.executeUpdate();
            ResultSet registroLlaves = comando.getGeneratedKeys();
            if (registroLlaves.next()){
                Integer llave = registroLlaves.getInt(Statement.RETURN_GENERATED_KEYS);
                cuenta.setNoCuenta(llave);;
                return cuenta;
            }
            LOG.log(Level.WARNING, "Se insertó la cuenta sin mostrar la ID");
            throw new DAOException("Se insertó la cuenta sin mostrar la ID");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar la cuenta {0}", ex.getMessage());
            throw new DAOException("No se pudo insertar la cuenta " + ex.getMessage());
        }
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
