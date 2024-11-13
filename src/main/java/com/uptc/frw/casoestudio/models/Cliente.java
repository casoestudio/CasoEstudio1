package com.uptc.frw.casoestudio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Cliente {

    @Id
    private Long idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String personaContacto;

    @OneToMany(mappedBy = "cliente")
    private Set<OrdenCompra> ordenesCompra;

    public Cliente() {
    }

    public int getIdCliente() {
        return Math.toIntExact(idCliente);
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public Set<OrdenCompra> getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(Set<OrdenCompra> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", personaContacto='" + personaContacto + '\'' +
                ", ordenesCompra=" + ordenesCompra +
                '}';
    }
}
