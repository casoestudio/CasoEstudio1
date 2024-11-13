package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.OrdenDetalle;
import com.uptc.frw.casoestudio.repository.OrdenDetalleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenDetalleService {


    private OrdenDetalleRepository ordenDetalleRepository;

    @Autowired
    public OrdenDetalleService(OrdenDetalleRepository ordenDetalleRepository) {
        this.ordenDetalleRepository = ordenDetalleRepository;
    }

    public List<OrdenDetalle> findAll() {
        return ordenDetalleRepository.findAll();
    }
    public Optional<OrdenDetalle> findById(Long id) {
        return ordenDetalleRepository.findById(id);
    }


    public OrdenDetalle save(OrdenDetalle ordenDetalle) {
        return ordenDetalleRepository.save(ordenDetalle);
    }

    public OrdenDetalle update(Long id, OrdenDetalle ordenDetalle) {
        if (ordenDetalleRepository.existsById(id)) {
            ordenDetalle.setIdDetalle(id);
            return ordenDetalleRepository.save(ordenDetalle);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        ordenDetalleRepository.deleteById(id);
    }
}
