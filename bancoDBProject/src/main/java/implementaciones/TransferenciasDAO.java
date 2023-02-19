/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Transferencia;
import excepciones.DAOException;
import interfaces.IConexionBD;
import interfaces.ITransferenciaDAO;
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
public class TransferenciasDAO implements ITransferenciaDAO {
    private static final Logger LOG = Logger.getLogger(RetirosDAO.class.getName());
    private final IConexionBD MANAGER;

    public TransferenciasDAO(IConexionBD manejadorConexiones) {
        this.MANAGER = manejadorConexiones;
    }

    @Override
    public Transferencia consultar(Integer noCuenta) throws DAOException {
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(
                "select * from transferencias where no_cuenta = ?");  
        ){
            comando.setInt(1, noCuenta);
            ResultSet resultado = comando.executeQuery();
            Transferencia transfer = null;
            if (resultado.next()){
                Integer idTransfer = resultado.getInt("id_transferencia");
                Float montoATransferir = resultado.getFloat("monto_a_transferir");
                Integer cuentaTransfer = resultado.getInt("cuenta_transfer");
                Integer cuentaRecibo = resultado.getInt("cuenta_recibo");
                transfer = new Transferencia(idTransfer, montoATransferir, cuentaTransfer, cuentaRecibo);
            }
            return transfer;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la transferencia {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar la transferencia " + ex.getMessage());
        }
    }

    @Override
    public Transferencia insertar(Transferencia transfer) throws DAOException {
        String sql = "insert into transferencias "
                    + "(monto_a_transferir, cuenta_transfer, cuenta_recibo)";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS);
        ){
            comando.setFloat(1, transfer.getMonto_a_transferir());
            comando.setInt(2, transfer.getCuenta_transfer());
            comando.setInt(3, transfer.getCuenta_recibo());
            comando.executeUpdate();
            ResultSet registroLlaves = comando.getGeneratedKeys();
            if (registroLlaves.next()){
                Integer llave = registroLlaves.getInt(Statement.RETURN_GENERATED_KEYS);
                transfer.setId_transferencia(llave);
                return transfer;
            }
            LOG.log(Level.WARNING, "Se insertó la transferencia sin mostrar la ID");
            throw new DAOException("Se insertó la transferencia sin mostrar la ID");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo insertar la transferencia {0}", ex.getMessage());
            throw new DAOException("No se pudo insertar la transferencia " + ex.getMessage());
        }
    }

    @Override
    public Transferencia eliminar(Integer id) throws DAOException {
        Transferencia transfer = this.consultar(id);
        String codigoBD = "delete from transferencias where id_transferencia = ?";
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoBD);
        ){
            comando.setInt(1, id);
            boolean eliminaTransfer = comando.execute();
            return (eliminaTransfer) ? transfer : null;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo eliminar la transferencia {0}", ex.getMessage());
            throw new DAOException("No se pudo eliminar la transferencia " + ex.getMessage());
        }
    }

    @Override
    public List<Transferencia> consultar(ConfigPaginado configPaginado) throws DAOException {
        String sql = "select * from transferencias "
                   + "limit ? offset ?";
        List<Transferencia> listaTransfer = new LinkedList<>();
        try(
            Connection conexion = MANAGER.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
        ){
            comando.setInt(1, configPaginado.getElemPagina());
            comando.setInt(2, configPaginado.getElementosASaltar());
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()) {
                Integer idTransfer = resultado.getInt("id_transferencia");
                Float montoATransferir = resultado.getFloat("monto_a_transferir");
                Integer cuentaTransfer = resultado.getInt("cuenta_transfer");
                Integer cuentaRecibo = resultado.getInt("cuenta_recibo");
                Transferencia transfer = new Transferencia(idTransfer, 
                        montoATransferir, cuentaTransfer, cuentaRecibo);
                listaTransfer.add(transfer);
            }
            return listaTransfer;
        }catch(SQLException ex) {
            LOG.log(Level.SEVERE, "No se pudo consultar la lista de tranferencias {0}", ex.getMessage());
            throw new DAOException("No se pudo consultar la lista de tranferencias " + ex.getMessage());
        }
    }   
}
