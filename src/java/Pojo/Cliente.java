package Pojo;
// Generated feb 18, 2016 6:40:59 p.m. by Hibernate Tools 4.3.1



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int idcliente;
     private String cedula;
     private String nombre;
     private String telefonoconv;
     private String telefonocel;
     private String direccion;

    public Cliente() {
    }

	
    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public Cliente(int idcliente, String cedula, String nombre, String telefonoconv, String telefonocel, String direccion) {
       this.idcliente = idcliente;
       this.cedula = cedula;
       this.nombre = nombre;
       this.telefonoconv = telefonoconv;
       this.telefonocel = telefonocel;
       this.direccion = direccion;
    }
   
    public int getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefonoconv() {
        return this.telefonoconv;
    }
    
    public void setTelefonoconv(String telefonoconv) {
        this.telefonoconv = telefonoconv;
    }
    public String getTelefonocel() {
        return this.telefonocel;
    }
    
    public void setTelefonocel(String telefonocel) {
        this.telefonocel = telefonocel;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }




}


