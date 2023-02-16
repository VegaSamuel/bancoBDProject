/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 * @author Samuel Vega y Victor González
 * @version IDE 8.2
 */
public class Transferencia {
    private Integer id_transferencia;
    private Float monto_a_transferir;
    private Cuenta cuenta_transfer, cuenta_recibo;

    public Transferencia() {
    }

    public Transferencia(Integer id_transferencia, Float monto_a_transferir, Cuenta cuenta_transfer, Cuenta cuenta_recibo) {
        this.id_transferencia = id_transferencia;
        this.monto_a_transferir = monto_a_transferir;
        this.cuenta_transfer = cuenta_transfer;
        this.cuenta_recibo = cuenta_recibo;
    }

    public Integer getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public Float getMonto_a_transferir() {
        return monto_a_transferir;
    }

    public void setMonto_a_transferir(Float monto_a_transferir) {
        this.monto_a_transferir = monto_a_transferir;
    }

    public Cuenta getCuenta_transfer() {
        return cuenta_transfer;
    }

    public void setCuenta_transfer(Cuenta cuenta_transfer) {
        this.cuenta_transfer = cuenta_transfer;
    }

    public Cuenta getCuenta_recibo() {
        return cuenta_recibo;
    }

    public void setCuenta_recibo(Cuenta cuenta_recibo) {
        this.cuenta_recibo = cuenta_recibo;
    }
    
}
