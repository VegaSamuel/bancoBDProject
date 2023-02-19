/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Retiro;
import excepciones.DAOException;
import interfaces.IConexionBD;
import interfaces.IRetiroDAO;
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
 * @author Samuel Vega y Victor González
 */
public class RetirosDAO implements IRetiroDAO {
    private static final Logger LOG = Logger.getLogger(RetirosDAO.class.getName());
    private final IConexionBD MANAGER;

    public RetirosDAO(IConexionBD manejadorConexiones) {
        this.MANAGER = manejadorConexiones;
    }

    @Override
    public Retiro consultar(Integer noCuenta) throws DAOException {
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(
                "select * from retiros where no_cuenta = ?");  
        ){
            comando.setInt(1, noCuenta);
            ResultSet resultado = comando.executeQuery();
            Retiro retiro = null;
            if (resultado.next()){
                Integer id_retiro = resultado.getInt("id_retiro");
                Float monto_retirado = resultado.getFloat("monto_retirado");
                Integer folio = resultado.getInt("folio");
                Integer contraseña = resultado.getInt("contraseña");
                Integer cuenta_retiro = resultado.getInt("cuenta_retiro");
                retiro = new Retiro(id_retiro, monto_retirado, folio, contraseña, cuenta_retiro);
            }
            return retiro;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar el retiro {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar el retiro " + ex.getMessage());
        }
    }

    @Override
    public Retiro insertar(Retiro retiro) throws DAOException {
        String sql = "insert into retiros(monto_retirado, folio, contraseña, cuenta_retiro)"
                   + "values (?, ?, ?, ?)";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            comando.setFloat(1, retiro.getMonto_retirado());
            comando.setInt(2, retiro.getFolio());
            comando.setInt(3, retiro.getContraseña());
            comando.setInt(4, retiro.getCuentaRetiro());
            comando.executeUpdate();
            ResultSet registroLlaves = comando.getGeneratedKeys();
            if (registroLlaves.next()){
                Integer llave = registroLlaves.getInt(Statement.RETURN_GENERATED_KEYS);
                retiro.setId_retiro(llave);
                return retiro;
            }
            LOG.log(Level.WARNING, "Se insertó el retiro sin mostrar la ID");
            throw new DAOException("Se insertó el retiro sin mostrar la ID");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar el retiro {0}", ex.getMessage());
            throw new DAOException("No se pudo insertar el retiro " + ex.getMessage());
        }
    }

    @Override
    public Retiro eliminar(Integer id) throws DAOException {
        Retiro retiro = this.consultar(id);
        String codigoBD = "delete from retiros where id_retiro = ?";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD);
        ){
            comando.setInt(1, id);
            boolean eliminaRetiro = comando.execute();
            return (eliminaRetiro) ? retiro : null;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo eliminar el retiro {0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar el retiro " + ex.getMessage());
        }
    }

    @Override
    public List<Retiro> consultar(ConfigPaginado configPaginado) throws DAOException {
        String sql = "select * from retiros "
                   + "limit ? offset ?";
        List<Retiro> listaRetiro = new LinkedList<>();
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
        ){
            comando.setInt(1, configPaginado.getElemPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()) {
                Integer idRetiro = resultado.getInt("id_cuenta");
                Float montoRetirado = resultado.getFloat("monto_retirado");
                Integer folio = resultado.getInt("folio");
                Integer contraseña = resultado.getInt("contraseña");
                Integer cuentaRetiro = resultado.getInt("cuenta_retiro");
                Retiro retiro = new Retiro(idRetiro, montoRetirado, folio, contraseña, cuentaRetiro);
                listaRetiro.add(retiro);
            }
            return listaRetiro;
        }catch(SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la lista de retiros {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar la lista de retiros " + ex.getMessage());
        }
    }    
}