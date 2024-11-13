package com.uptc.frw.casoestudio.controller;
import com.uptc.frw.casoestudio.models.OrdenCompra;
import com.uptc.frw.casoestudio.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public List<OrdenCompra> getAll() {
        return ordenCompraService.findAll();
    }

    @GetMapping("/{id}")
    public OrdenCompra getById(@PathVariable Long id) {
        return ordenCompraService.findById(id);
    }

    @PostMapping
    public OrdenCompra create(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.save(ordenCompra);
    }

    @PutMapping
    public OrdenCompra update(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.update(ordenCompra);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ordenCompraService.delete(id);
    }

}
