package com.uptc.frw.casoestudio.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
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
    private BigDecimal precioUnitario;

    @ManyToMany
    @JoinTable(
            name = "producto_maquina",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_maquina"))
    private Set<Maquina> maquinas;

    @ManyToOne
    @JoinColumn(name = "id_material")  // Definimos la propiedad para la relación con Material
    private Material material;

    public Producto() {}


    public Producto(String nombre, BigDecimal precioUnitario) {
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

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", maquinas=" + maquinas +
                ", material=" + material +
                '}';
    }
}
