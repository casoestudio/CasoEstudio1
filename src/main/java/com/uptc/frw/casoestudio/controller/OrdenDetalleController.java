package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.OrdenDetalle;
import com.uptc.frw.casoestudio.service.OrdenDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden-detalles")
public class OrdenDetalleController {


    private OrdenDetalleService ordenDetalleService;

    @Autowired
    public OrdenDetalleController(OrdenDetalleService ordenDetalleService) {
        this.ordenDetalleService = ordenDetalleService;
    }

    @GetMapping
    public List<OrdenDetalle> getAll() {
        return ordenDetalleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDetalle> getById(@PathVariable Long id) {
        return ordenDetalleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdenDetalle create(@RequestBody OrdenDetalle ordenDetalle) {
        return ordenDetalleService.save(ordenDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenDetalle> update(@PathVariable Long id, @RequestBody OrdenDetalle ordenDetalle) {
        OrdenDetalle updatedOrdenDetalle = ordenDetalleService.update(id, ordenDetalle);
        return updatedOrdenDetalle != null ? ResponseEntity.ok(updatedOrdenDetalle) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordenDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
