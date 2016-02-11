package Pojo;
// Generated feb 6, 2016 11:16:57 a.m. by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tventa generated by hbm2java
 */
public class Tventa  implements java.io.Serializable {


     private Integer idVenta;
     private BigDecimal precioVentaTotal;
     private Date fechaRegistro;
     private Set tventadetalles = new HashSet(0);

    public Tventa() {
    }

	
    public Tventa(BigDecimal precioVentaTotal, Date fechaRegistro) {
        this.precioVentaTotal = precioVentaTotal;
        this.fechaRegistro = fechaRegistro;
    }
    public Tventa(BigDecimal precioVentaTotal, Date fechaRegistro, Set tventadetalles) {
       this.precioVentaTotal = precioVentaTotal;
       this.fechaRegistro = fechaRegistro;
       this.tventadetalles = tventadetalles;
    }
   
    public Integer getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public BigDecimal getPrecioVentaTotal() {
        return this.precioVentaTotal;
    }
    
    public void setPrecioVentaTotal(BigDecimal precioVentaTotal) {
        this.precioVentaTotal = precioVentaTotal;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set getTventadetalles() {
        return this.tventadetalles;
    }
    
    public void setTventadetalles(Set tventadetalles) {
        this.tventadetalles = tventadetalles;
    }




}


