//DAOException
package excepciones;

/**
 * Esta clase manda excepciones a errores que puedan suceder en acciones de DAO
 * @author Samuel Vega & Victor Gonzales
 */
public class DAOException extends RuntimeException {
    
    /**
     * Constructor por omisión
     */
    public DAOException() {
        
    }
    
    /**
     * Constructor con mensaje
     * @param msg Mensaje de la excepción
     */
    public DAOException(String msg) {
        super(msg);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param msg Mensaje de la excepción
     * @param cause Causa del error
     */
    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    /**
     * Constructor con solamente una causa
     * @param cause Causa del error
     */
    public DAOException(Throwable cause) {
        super(cause);
    }
    
    public DAOException(String msg, Throwable cause, boolean enableSupression, boolean writeableStackTrace) {
        super(msg, cause, enableSupression, writeableStackTrace);
    }
}
