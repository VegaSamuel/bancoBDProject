//Principal.java
package main;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasDAO;
import implementaciones.DomiciliosDAO;
import implementaciones.RetirosDAO;
import implementaciones.TransferenciasDAO;
import interfaces.IConexionBD;
import presentación.InterfazPrincipal;

/**
 * Esta clase ejecuta el programa en sí
 * @author Samuel Vega & Victor Gonzales
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD connection = new ConexionBD("jdbc:mysql://localhost/banco", "root", "itson");
        ClientesDAO clientesDAO = new ClientesDAO(connection);
        CuentasDAO cuentasDAO = new CuentasDAO(connection);
        DomiciliosDAO domiciliosDAO = new DomiciliosDAO(connection);
        RetirosDAO retirosDAO = new RetirosDAO(connection);
        TransferenciasDAO transferenciasDAO = new TransferenciasDAO(connection);
        new InterfazPrincipal(clientesDAO, cuentasDAO, domiciliosDAO, retirosDAO, transferenciasDAO).setVisible(true);
    }
    
}
