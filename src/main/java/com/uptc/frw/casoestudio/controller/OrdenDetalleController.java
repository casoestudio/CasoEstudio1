package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.OrdenDetalle;
import com.uptc.frw.casoestudio.service.OrdenDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-detalle")
public class OrdenDetalleController {

    @Autowired
    private OrdenDetalleService ordenDetalleService;

    @GetMapping
    public List<OrdenDetalle> getAll() {
        return ordenDetalleService.findAll();
    }

    @GetMapping("/{id}")
    public OrdenDetalle getById(@PathVariable Long id) {
        return ordenDetalleService.findById(id);
    }

    @PostMapping
    public OrdenDetalle create(@RequestBody OrdenDetalle ordenDetalle) {
        return ordenDetalleService.save(ordenDetalle);
    }

    @PutMapping
    public OrdenDetalle update(@RequestBody OrdenDetalle ordenDetalle) {
        return ordenDetalleService.update(ordenDetalle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ordenDetalleService.delete(id);
    }



}
