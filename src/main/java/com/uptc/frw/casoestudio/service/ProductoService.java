package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Producto;
import com.uptc.frw.casoestudio.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Producto producto) {
        Producto existingProducto = findById(producto.getId());
        if (existingProducto == null) {
            throw new EntityNotFoundException("Producto no encontrado con ID: " + producto.getId());
        }
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setPrecioUnitario(producto.getPrecioUnitario());
        return productoRepository.save(existingProducto);
    }


    public void delete(Long id) {
        productoRepository.deleteById(id);
    }



}
