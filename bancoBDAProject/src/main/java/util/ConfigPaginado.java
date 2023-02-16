//ConfigPaginado.java
package util;

/**
 * Esta clase contiene la configuración para las paginas de las tablas de datos.
 * @author Samuel Vega & Victor Gonzales
 */
public class ConfigPaginado {
    private int numPagina;
    private int elemPagina;
    
    /**
     * Constructor que inicializa los parametros de la clase en 0 y 3
     */
    public ConfigPaginado() {
        this.numPagina = 0;
        this.elemPagina = 3;
    }
    
    /**
     * Constructor que inicializa los atributos de la clase con los parametros
     * @param numPagina Número de pagina
     * @param elemPagina Cantidad de elementos que tendra una página
     */
    public ConfigPaginado(int numPagina, int elemPagina) {
        this.numPagina = numPagina;
        this.elemPagina = elemPagina;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public int getElemPagina() {
        return elemPagina;
    }

    public void setElemPagina(int elemPagina) {
        this.elemPagina = elemPagina;
    }
    
    /**
     * Regresa los elementos a saltar
     * @return Los elementos a saltar
     */
    public int getElementosASaltar() {
        return this.numPagina * this.elemPagina;
    }
    
    /**
     * Avanza a la siguiente pagina de la tabla
     */
    public void avanzarPagina() {
        this.numPagina++;
    }
    
    /**
     * Retrocede a la pagina anterior de la tabla
     */
    public void retrocederPagina() {
        if(this.numPagina < 0)
            this.numPagina--;
    }
}
