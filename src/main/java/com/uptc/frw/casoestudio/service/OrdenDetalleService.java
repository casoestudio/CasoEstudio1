package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.OrdenDetalle;
import com.uptc.frw.casoestudio.repository.OrdenDetalleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenDetalleService {

    @Autowired
    private OrdenDetalleRepository ordenDetalleRepository;

    public List<OrdenDetalle> findAll() {
        return ordenDetalleRepository.findAll();
    }

    public OrdenDetalle findById(Long id) {
        return ordenDetalleRepository.findById(id).orElse(null);
    }

    public OrdenDetalle save(OrdenDetalle ordenDetalle) {
        return ordenDetalleRepository.save(ordenDetalle);
    }

    public OrdenDetalle update(OrdenDetalle ordenDetalle) {
        OrdenDetalle existingDetalle = findById(ordenDetalle.getIdDetalle());
        if (existingDetalle == null) {
            throw new EntityNotFoundException("Detalle de Orden no encontrado con ID: " + ordenDetalle.getIdDetalle());
        }
        existingDetalle.setCantidad(ordenDetalle.getCantidad());
        existingDetalle.setPrecioVenta(ordenDetalle.getPrecioVenta());
        return ordenDetalleRepository.save(existingDetalle);
    }


    public void delete(Long id) {
        ordenDetalleRepository.deleteById(id);
    }
}
