package com.uptc.frw.casoestudio.controller;
import com.uptc.frw.casoestudio.models.OrdenCompra;
import com.uptc.frw.casoestudio.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    private OrdenCompraService ordenCompraService;
    @Autowired
    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping
    public List<OrdenCompra> getAllOrdenes() {
        return ordenCompraService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra>getById(@PathVariable Long id) {
        return ordenCompraService.getOrdenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdenCompra create(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.save(ordenCompra);
    }

    @PutMapping
    public ResponseEntity<OrdenCompra> update(@PathVariable Long id, @RequestBody OrdenCompra ordenCompra) {
        OrdenCompra updatedOrden = ordenCompraService.update(id, ordenCompra);
        return updatedOrden != null ? ResponseEntity.ok(updatedOrden) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        ordenCompraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
