/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Retiro;
import excepciones.DAOException;
import java.util.List;
import util.ConfigPaginado;

/**
 * @author Samuel Vega y Victor González
 */
public interface IRetiroDAO {
    /**
     * Consulta el retiro de una cuenta
     * @param noCuenta Numero de la cuenta
     * @return Los datos del retiro de una cuenta
     * @throws DAOException Si no encuentra el retiro
     */
    Retiro consultar(Integer noCuenta) throws DAOException;
    /**
     * Inserta un retiro
     * @param retiro Retiro a insertar
     * @return El retiro insertado
     * @throws DAOException Si no se puede insertar el retiro
     */
    Retiro insertar(Retiro retiro) throws DAOException;
    /**
     * Elimina un retiro con su id
     * @param id Id del retiro
     * @return El retiro eliminado
     * @throws DAOException Si no encuentra el retiro o no se pudo eliminar
     */
    Retiro eliminar(Integer id) throws DAOException;
    /**
     * Consulta todos los retiros de todas las cuentas
     * @param configPaginado Configuración de paginación para la tabla
     * @return Una lista de retiros
     * @throws DAOException Si no encuentra todos los retiros
     */
    List<Retiro> consultar(ConfigPaginado configPaginado) throws DAOException;
}
