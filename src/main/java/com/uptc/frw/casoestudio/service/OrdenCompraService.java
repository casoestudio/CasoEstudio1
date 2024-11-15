package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.OrdenCompra;
import com.uptc.frw.casoestudio.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {

    @Autowired
    private final OrdenCompraRepository ordenCompraRepository;


    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
        this.ordenCompraRepository = ordenCompraRepository;
    }

    public List<OrdenCompra> getAllOrdenes() {
        return ordenCompraRepository.findAll();
    }

    public Optional <OrdenCompra> getOrdenById(Long id) {
        return ordenCompraRepository.findById(id);
    }

    public OrdenCompra save(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public OrdenCompra update(Long id, OrdenCompra ordenCompra) {
        if (ordenCompraRepository.existsById(id)) {
            ordenCompra.setIdOrden(id);
            return ordenCompraRepository.save(ordenCompra);
        } else {
            return null;
        }
    }
    public void delete(Long id) {
        ordenCompraRepository.deleteById(id);
    }


}
