package com.uptc.frw.casoestudio.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "PRECIO_UNITARIO", precision = 8, scale = 3, nullable = false)
    private Double precioUnitario;



    public Producto() {}


    public Producto(String nombre, Double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

    public Long getIdProducto() {
        return id;
    }

    public String getDescripcion() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.nombre = descripcion;
    }

}
