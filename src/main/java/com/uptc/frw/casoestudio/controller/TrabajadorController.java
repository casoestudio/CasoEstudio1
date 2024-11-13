package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Trabajador;
import com.uptc.frw.casoestudio.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {

    private TrabajadorService trabajadorService;

    @Autowired
    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public List<Trabajador> getAll() {
        return trabajadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> getById(@PathVariable Long id) {
        return trabajadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trabajador create(@RequestBody Trabajador trabajador) {
        return trabajadorService.save(trabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> update(@PathVariable Long id, @RequestBody Trabajador trabajador) {
        Trabajador updatedTrabajador = trabajadorService.update(id, trabajador);
        return updatedTrabajador != null ? ResponseEntity.ok(updatedTrabajador) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trabajadorService.delete(id);
    }


}
