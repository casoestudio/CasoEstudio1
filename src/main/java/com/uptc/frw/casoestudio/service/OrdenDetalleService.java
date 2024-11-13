package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.OrdenDetalle;
import com.uptc.frw.casoestudio.repository.OrdenDetalleRepository;
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
        existingDetalle.setCantidad(ordenDetalle.getCantidad());
        existingDetalle.setPrecioVenta(ordenDetalle.getPrecioVenta());
        return save(existingDetalle);
    }

    public void delete(Long id) {
        ordenDetalleRepository.deleteById(id);
    }
}
