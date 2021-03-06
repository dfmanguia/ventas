package Pojo;
// Generated feb 18, 2016 6:40:59 p.m. by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Tventadetalle generated by hbm2java
 */
public class Tventadetalle  implements java.io.Serializable {


     private Integer idVentaDetalle;
     private Tproducto tproducto;
     private Tventa tventa;
     private String codigoBarrasProducto;
     private String nombreProducto;
     private BigDecimal precioVentaUnitarioProducto;
     private int cantidad;
     private BigDecimal totalPrecioVenta;

    public Tventadetalle() {
    }

    public Tventadetalle(Tproducto tproducto, Tventa tventa, String codigoBarrasProducto, String nombreProducto, BigDecimal precioVentaUnitarioProducto, int cantidad, BigDecimal totalPrecioVenta) {
       this.tproducto = tproducto;
       this.tventa = tventa;
       this.codigoBarrasProducto = codigoBarrasProducto;
       this.nombreProducto = nombreProducto;
       this.precioVentaUnitarioProducto = precioVentaUnitarioProducto;
       this.cantidad = cantidad;
       this.totalPrecioVenta = totalPrecioVenta;
    }
   
    public Integer getIdVentaDetalle() {
        return this.idVentaDetalle;
    }
    
    public void setIdVentaDetalle(Integer idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }
    public Tproducto getTproducto() {
        return this.tproducto;
    }
    
    public void setTproducto(Tproducto tproducto) {
        this.tproducto = tproducto;
    }
    public Tventa getTventa() {
        return this.tventa;
    }
    
    public void setTventa(Tventa tventa) {
        this.tventa = tventa;
    }
    public String getCodigoBarrasProducto() {
        return this.codigoBarrasProducto;
    }
    
    public void setCodigoBarrasProducto(String codigoBarrasProducto) {
        this.codigoBarrasProducto = codigoBarrasProducto;
    }
    public String getNombreProducto() {
        return this.nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public BigDecimal getPrecioVentaUnitarioProducto() {
        return this.precioVentaUnitarioProducto;
    }
    
    public void setPrecioVentaUnitarioProducto(BigDecimal precioVentaUnitarioProducto) {
        this.precioVentaUnitarioProducto = precioVentaUnitarioProducto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getTotalPrecioVenta() {
        return this.totalPrecioVenta;
    }
    
    public void setTotalPrecioVenta(BigDecimal totalPrecioVenta) {
        this.totalPrecioVenta = totalPrecioVenta;
    }




}


