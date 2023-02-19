/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 * @author Samuel Vega y Victor González
 * @version IDE 8.2
 */
public class Retiro {
    private Integer id_retiro;
    private Float monto_retirado;
    private Integer folio;
    private Integer contraseña;
    private Integer cuenta_retiro;

    public Retiro() {
    }

    public Retiro(Integer id_retiro, Float monto_retirado, Integer folio, Integer contraseña, Integer cuenta_retiro) {
        this.id_retiro = id_retiro;
        this.monto_retirado = monto_retirado;
        this.folio = folio;
        this.contraseña = contraseña;
        this.cuenta_retiro = cuenta_retiro;
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

    public Integer getCuentaRetiro() {
        return cuenta_retiro;
    }

    public void setCuentaRetiro(Integer cuenta_retiro) {
        this.cuenta_retiro = cuenta_retiro;
    }
    
}