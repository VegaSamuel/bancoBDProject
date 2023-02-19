/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Transferencia;
import excepciones.DAOException;
import java.util.List;
import util.ConfigPaginado;

/**
 * @author Samuel Vega y Victor González
 */
public interface ITransferenciaDAO {
    /**
     * Consulta la transferencia de una cuenta
     * @param noCuenta Numero de la cuenta
     * @return Los datos de la transferencia de una cuenta
     * @throws DAOException Si no encuentra la transferencia
     */
    Transferencia consultar(Integer noCuenta) throws DAOException;
    /**
     * Inserta una transferencia
     * @param transfer Transferencia a insertar
     * @return La transferencia insertada
     * @throws DAOException Si no se puede insertar la transferencia
     */
    Transferencia insertar(Transferencia transfer) throws DAOException;
    /**
     * Elimina una transferencia con su id
     * @param id Id de la transferencia
     * @return La transferencia eliminada
     * @throws DAOException Si no encuentra la transferencia o no se pudo eliminar
     */
    Transferencia eliminar(Integer id) throws DAOException;
    /**
     * Consulta todas las transferencias de todas las cuentas
     * @param configPaginado Configuración de paginación para la tabla
     * @return Una lista de transferencias
     * @throws DAOException Si no encuentra todas las transferencias
     */
    List<Transferencia> consultar(ConfigPaginado configPaginado) throws DAOException;
}
