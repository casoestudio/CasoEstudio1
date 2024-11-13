package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.OrdenCompra;
import com.uptc.frw.casoestudio.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {

@Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public List<OrdenCompra> findAll() {
        return ordenCompraRepository.findAll();
    }

    public OrdenCompra findById(Long id) {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    public OrdenCompra save(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public OrdenCompra update(OrdenCompra ordenCompra) {
        OrdenCompra existingOrden = findById(ordenCompra.getIdOrden());
        existingOrden.setFechaCompra(ordenCompra.getFechaCompra());
        existingOrden.setFechaEntregaEsperada(ordenCompra.getFechaEntregaEsperada());
        existingOrden.setFechaEntrega(ordenCompra.getFechaEntrega());
        return save(existingOrden);
    }

    public void delete(Long id) {
        ordenCompraRepository.deleteById(id);
    }








}
