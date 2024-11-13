package com.uptc.frw.casoestudio.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class OrdenCompra {

    @Id
    private Long idOrden;
    private LocalDate fechaCompra;
    private LocalDate fechaEntregaEsperada;
    private LocalDate fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "ordenCompra")
    private Set<OrdenDetalle> detalles;

    public OrdenCompra() {
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDate getFechaEntregaEsperada() {
        return fechaEntregaEsperada;
    }

    public void setFechaEntregaEsperada(LocalDate fechaEntregaEsperada) {
        this.fechaEntregaEsperada = fechaEntregaEsperada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<OrdenDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<OrdenDetalle> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "idOrden=" + idOrden +
                ", fechaCompra=" + fechaCompra +
                ", fechaEntregaEsperada=" + fechaEntregaEsperada +
                ", fechaEntrega=" + fechaEntrega +
                ", cliente=" + cliente +
                ", detalles=" + detalles +
                '}';
    }
}
