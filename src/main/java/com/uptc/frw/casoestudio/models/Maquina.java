package com.uptc.frw.casoestudio.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Maquina {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "maquina_seq")
    @SequenceGenerator(name = "maquina_seq_gen", sequenceName = "maquina_seq", allocationSize = 1)
    private long id;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private LocalDate fechaCompra;

    @ManyToMany(mappedBy = "maquinas") // Mapeamos con la propiedad 'maquinas' de la clase Producto
    private Set<Producto> productos;

    @ManyToMany(mappedBy = "maquinas")
    private Set<Trabajador> trabajadores;


    public Maquina() {
    }

    public Maquina(long id, String numeroSerie, String marca, String modelo, LocalDate fechaCompra, Set<Trabajador> trabajadores, Set<Producto> productos) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaCompra = fechaCompra;
           }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Set<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Set<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "id=" + id +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", trabajadores=" + trabajadores +
                ", productos=" + productos +
                '}';
    }
}
