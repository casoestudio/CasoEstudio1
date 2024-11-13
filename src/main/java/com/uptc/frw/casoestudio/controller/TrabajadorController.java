package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Trabajador;
import com.uptc.frw.casoestudio.service.TrabajadorService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {
    private final TrabajadorService trabajadorService;
    private final OperacionService operacionService;

    @Autowired
    public TrabajadorController(TrabajadorService trabajadorService, OperacionService operacionService) {
        this.trabajadorService = trabajadorService;
        this.operacionService = operacionService;
    }

    @GetMapping
    public List<Trabajador> obtenerTrabajadores() {
        operacionService.registrarLog("trabajador", "get", "Consulta todos los trabajadores");
        return trabajadorService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Trabajador> obtenerTrabajadorPorId(@PathVariable long id) {
        operacionService.registrarLog("trabajador", "get", "Consulta el trabajador por id: " + id);
        return trabajadorService.findById(id);
    }

    @PostMapping
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador) {
        operacionService.registrarLog("trabajador", "post", "Crear el trabajador: " + trabajador);
        return trabajadorService.save(trabajador);
    }

    @DeleteMapping("/{id}")
    public void eliminarTrabajadorPorId(@PathVariable long id) {
        operacionService.registrarLog("trabajador", "delete", "Elimina el trabajador por id: " + id);
        trabajadorService.delete(id);
    }

    @PutMapping
    public Trabajador modificarTrabajador(@RequestParam long id, @RequestBody Trabajador trabajador) {
        operacionService.registrarLog("trabajador", "put", "Modifica el trabajador por id: " + id);
        return trabajadorService.update(id, trabajador);
    }

}
