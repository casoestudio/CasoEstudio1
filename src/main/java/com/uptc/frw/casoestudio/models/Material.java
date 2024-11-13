package com.uptc.frw.casoestudio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Material {

    @Id
    private Long idMaterial;
    private String nombreMaterial;

    @OneToMany(mappedBy = "material")
    private Set<Producto> productos;

    public Material() {
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Material{" +
                "idMaterial=" + idMaterial +
                ", nombreMaterial='" + nombreMaterial + '\'' +
                ", productos=" + productos +
                '}';
    }
}
