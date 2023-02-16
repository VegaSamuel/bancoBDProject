//Cliente.java
package dominio;

import java.util.Date;

/**
 * Esta clase define a un cliente
 * @author Samuel Vega & Victor Gonzales
 */
public class Cliente {
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private Integer idDomicilio;

    /**
     * Constructor por omisión
     */
    public Cliente() {
        
    }
    
    /**
     * Constructor que inicializa los atributos de la clase, excepto el id
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param idDomicilio Domicilio del cliente
     */
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Integer idDomicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;
    }
    
    /**
     * Constructor que inicializa los atributos de la clase, excepto el id
     * @param id id del cliente
     * @param nombre Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param idDomicilio Domicilio del cliente
     */
    public Cliente(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Integer idDomicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }
    
    public void crearCuenta(){
        
    }
    
    public void iniciarSesión(){
        
    }
    
    public void realizarRetiro(){
        
    }
}
