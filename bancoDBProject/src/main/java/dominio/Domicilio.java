//Domicilio.java
package dominio;

/**
 * Esta clase define un domicilio
 * @author Samuel Vega & Victor Gonzalez
 */
public class Domicilio {
    private Integer id;
    private String calle;
    private Integer numero;
    private String colonia;

    /**
     * Constructor por omisión
     */
    public Domicilio() {
        
    }
    
    /**
     * Constructor que inicializa los atributos de la clase, excepto el id
     * @param calle Calle en la que vive el cliente
     * @param numero Numero de casa del cliente
     * @param colonia Colonia en la que vive el cliente
     */
    public Domicilio(String calle, Integer numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }
    
    /**
     * Constructor que inicializa los atributos de la clase
     * @param id id del domicilio
     * @param calle Calle en la que vive el cliente
     * @param numero Numero de casa del cliente
     * @param colonia Colonia en la que vive el cliente
     */
    public Domicilio(Integer id, String calle, Integer numero, String colonia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
}
