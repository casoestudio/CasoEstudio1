package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Trabajador;
import com.uptc.frw.casoestudio.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {


    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> getAll() {
        return trabajadorService.findAll();
    }

    @GetMapping("/{id}")
    public Trabajador getById(@PathVariable Long id) {
        return trabajadorService.findById(id);
    }

    @PostMapping
    public Trabajador create(@RequestBody Trabajador trabajador) {
        return trabajadorService.save(trabajador);
    }

    @PutMapping
    public Trabajador update(@RequestBody Trabajador trabajador) {
        return trabajadorService.update(trabajador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trabajadorService.delete(id);
    }


}
