package com.uptc.frw.casoestudio.controller;


import com.uptc.frw.casoestudio.models.Maquina;
import com.uptc.frw.casoestudio.service.Maquinaservice;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maquinas")
public class MaquinaController {

    private final Maquinaservice maquinaservice;
    private final OperacionService operacionService;

    @Autowired
    public MaquinaController(Maquinaservice maquinaService, OperacionService operacionService) {
        this.maquinaservice = maquinaService;
        this.operacionService = operacionService;
    }

        @GetMapping
    public List<Maquina> encuentraMaquina() {
        operacionService.registrarLog("Maquina", "get", "Consultar todas las maquinas");
        return maquinaservice.findMaquinas();
    }

    @GetMapping("{id}")
    public Optional<Maquina> obtenerMaquinaPorId(@PathVariable long id) {
        operacionService.registrarLog("maquina", "get", "Consulta la maquina por id: " + id);
        return maquinaservice.findMaquina(id);
    }

    @PostMapping
    public Maquina crearMaquina(@RequestBody Maquina maquina) {
        operacionService.registrarLog("maquina", "post", "Crear la maquina: " + maquina);
        return maquinaservice.save(maquina);
    }

    @DeleteMapping("/{id}")
    public void eliminarMaquinaPorId(@PathVariable long id) {
        operacionService.registrarLog("maquina", "delete", "Elimina la maquina por id: " + id);
        maquinaservice.deleteMaquina(id);
    }

    @PutMapping
    public Maquina modificarMaquina(@RequestParam long id, @RequestBody Maquina maquina) {
        operacionService.registrarLog("maquina", "put", "Modifica la maquina por id: " + id);
        return maquinaservice.update(id, maquina);
    }

}
