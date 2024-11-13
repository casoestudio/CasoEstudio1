package com.uptc.frw.casoestudio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Maquina {
    @Id
    private String numeroSerie;
    private String marca;
    private String modelo;
    private LocalDate fechaCompra;

    @ManyToMany(mappedBy = "maquinas")
    private Set<Trabajador> trabajadores;

    @OneToMany(mappedBy = "maquinas")
    private Set<Producto> productos;


    public Maquina() {
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


    @Override
    public String toString() {
        return "Maquina{" +
                "numeroSerie='" + numeroSerie + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", trabajadores=" + trabajadores +
                ", productos=" + productos +
                '}';
    }
}
