package com.uptc.frw.casoestudio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class OrdenDetalle {

    @Id
    private Long idDetalle;
    private Integer cantidad;
    private BigDecimal precioVenta;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public OrdenDetalle() {
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "OrdenDetalle{" +
                "idDetalle=" + idDetalle +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                ", ordenCompra=" + ordenCompra +
                ", producto=" + producto +
                '}';
    }
}
