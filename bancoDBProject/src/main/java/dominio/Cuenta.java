//Cuenta.java
package dominio;

import java.sql.Date;

/**
 * Esta clase define a una cuenta
 * @author Samuel Vega & Victor Gonzales
 */
public class Cuenta {
    private Integer noCuenta;
    private Date fechaApertura;
    private Float saldo;
    private Integer idClientes;

    /**
     * Constructor por omisi�n
     */
    public Cuenta() {
        
    }
    
    /**
     * Constructor que inicializa los atributos de la clase
     * @param noCuenta Numero de cuenta
     * @param fechaApertura Fecha de apertura
     * @param saldo Saldo en la cuenta
     * @param idClientes Cliente al que pertenece la cuenta
     */
    public Cuenta(Integer noCuenta, Date fechaApertura, Float saldo, Integer idClientes) {
        this.noCuenta = noCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idClientes = idClientes;
    }
    
    /**
     * Constructor que inicializa los atributos de la clase, excepto el numero de cuenta
     * @param fechaApertura Fecha de apertura
     * @param saldo Saldo en la cuenta
     * @param idClientes Cliente al que pertenece la cuenta
     */
    public Cuenta(Date fechaApertura, Float saldo, Integer idClientes) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idClientes = idClientes;
    }
    
    /**
     * Constructor que inicializa los atributos de la clase, excepto el numero de cuenta y el id del cliente
     * @param fechaApertura Fecha de apertura
     * @param saldo Saldo en la cuenta
     */
    public Cuenta(Date fechaApertura, Float saldo) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }
    /**
     * Constructor que solo inicializa el id del cliente
     * @param idClientes Cliente al que pertenece la cuenta
     */
    public Cuenta(Integer idClientes) {
        this.idClientes = idClientes;
    }
    
    public Integer getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(Integer noCuenta) {
        this.noCuenta = noCuenta;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }
    
    
}
