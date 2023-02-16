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
public class Retiro {
    private Integer id_retiro;
    private Float monto_retirado;
    private Integer folio;
    private Integer contraseña;
    private Cuenta cuenta;

    public Retiro() {
    }

    public Retiro(Integer id_retiro, Float monto_retirado, Integer folio, Integer contraseña, Cuenta cuenta) {
        this.id_retiro = id_retiro;
        this.monto_retirado = monto_retirado;
        this.folio = folio;
        this.contraseña = contraseña;
        this.cuenta = cuenta;
    }

    public Integer getId_retiro() {
        return id_retiro;
    }

    public void setId_retiro(Integer id_retiro) {
        this.id_retiro = id_retiro;
    }

    public Float getMonto_retirado() {
        return monto_retirado;
    }

    public void setMonto_retirado(Float monto_retirado) {
        this.monto_retirado = monto_retirado;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getContraseña() {
        return contraseña;
    }

    public void setContraseña(Integer contraseña) {
        this.contraseña = contraseña;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
}
