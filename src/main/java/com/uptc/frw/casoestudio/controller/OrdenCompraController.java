package com.uptc.frw.casoestudio.controller;
import com.uptc.frw.casoestudio.models.OrdenCompra;
import com.uptc.frw.casoestudio.service.OrdenCompraService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController {

    private OrdenCompraService ordenCompraService;
    private final OperacionService operacionService;

    @Autowired
    public OrdenCompraController(OrdenCompraService ordenCompraService, OperacionService operacionService) {
        this.ordenCompraService = ordenCompraService;
        this.operacionService = operacionService;
    }

    @GetMapping
    public List<OrdenCompra> obtenerOrdenesCompra() {
        operacionService.registrarLog("ordenCompra", "get", "Consulta todas las ordenes de compra");
        return ordenCompraService.getAllOrdenes();
    }

    @GetMapping("{id}")
    public Optional<OrdenCompra> obtenerOrdenCompraPorId(@PathVariable long id) {
        operacionService.registrarLog("ordenCompra", "get", "Consulta la orden de compra por id: " + id);
        return ordenCompraService.getOrdenById(id);
    }

    @PostMapping
    public OrdenCompra crearOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        operacionService.registrarLog("ordenCompra", "post", "Crear la orden de compra: " + ordenCompra);
        return ordenCompraService.save(ordenCompra);
    }

    @DeleteMapping("/{id}")
    public void eliminarOrdenCompraPorId(@PathVariable long id) {
        operacionService.registrarLog("ordenCompra", "delete", "Elimina la orden de compra por id: " + id);
        ordenCompraService.delete(id);
    }

    @PutMapping
    public OrdenCompra modificarOrdenCompra(@RequestParam long id, @RequestBody OrdenCompra ordenCompra) {
        operacionService.registrarLog("ordenCompra", "put", "Modifica la orden de compra por id: " + id);
        return ordenCompraService.update(id, ordenCompra);
    }
}
