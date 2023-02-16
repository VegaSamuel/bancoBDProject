//Principal.java
package main;

import implementaciones.ConexionBD;
import interfaces.IConexionBD;
import presentación.ClienteForm;

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
        new ClienteForm().setVisible(true);
    }
    
}
