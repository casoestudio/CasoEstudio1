package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.OrdenDetalle;
import com.uptc.frw.casoestudio.service.OrdenDetalleService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ordendetalles")
public class OrdenDetalleController {
    @Autowired
    private final OrdenDetalleService ordenDetalleService;
    @Autowired
    private final OperacionService operacionService;


    public OrdenDetalleController(OrdenDetalleService ordenDetalleService, OperacionService operacionService) {
        this.ordenDetalleService = ordenDetalleService;
        this.operacionService = operacionService;
    }

    @GetMapping
    public List<OrdenDetalle> obtenerOrdenesDetalle() {
        operacionService.registrarLog("ordenDetalle", "get", "Consulta todos los detalles de las ordenes");
        return ordenDetalleService.findAll();
    }

    @GetMapping("{id}")
    public Optional<OrdenDetalle> obtenerOrdenDetallePorId(@PathVariable long id) {
        operacionService.registrarLog("ordenDetalle", "get", "Consulta el detalle de la orden por id: " + id);
        return ordenDetalleService.findById(id);
    }

    @PostMapping
    public OrdenDetalle crearOrdenDetalle(@RequestBody OrdenDetalle ordenDetalle) {
        operacionService.registrarLog("ordenDetalle", "post", "Crear el detalle de la orden: " + ordenDetalle);
        return ordenDetalleService.save(ordenDetalle);
    }

    @DeleteMapping("/{id}")
    public void eliminarOrdenDetallePorId(@PathVariable long id) {
        operacionService.registrarLog("ordenDetalle", "delete", "Elimina el detalle de la orden por id: " + id);
        ordenDetalleService.delete(id);
    }

    @PutMapping
    public OrdenDetalle modificarOrdenDetalle(@RequestParam long id, @RequestBody OrdenDetalle ordenDetalle) {
        operacionService.registrarLog("ordenDetalle", "put", "Modifica el detalle de la orden por id: " + id);
        return ordenDetalleService.update(id, ordenDetalle);
    }


}
