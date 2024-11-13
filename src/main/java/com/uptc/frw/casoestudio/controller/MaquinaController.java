package com.uptc.frw.casoestudio.controller;


import com.uptc.frw.casoestudio.models.Maquina;
import com.uptc.frw.casoestudio.service.Maquinaservice;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/maquinas")
public class MaquinaController {

    @Autowired
    private Maquinaservice maquinaservice;

    @Autowired
    private OperacionService operacionService;

    @GetMapping
    public List<Maquina> encuentraMaquina() {
        operacionService.registrarLog("Maquina", "get", "Consultar todas las maquinas");
        return maquinaservice.findMaquinas();
    }


    @GetMapping("/{id}")
    public Maquina buscarMaquinaPorNumerodeSerie(@PathVariable long id) {
        operacionService.registrarLog("maquina", "get", "Consultar maquina por Numero de serie: " + id);
        return maquinaservice.findMaquina(id).orElse(null);
    }

    @PostMapping
    public Maquina guardarMaquina(@RequestBody Maquina maquina) {
        operacionService.registrarLog("maquina", "post", "Crear maquina: "+ maquina);
        return maquinaservice.save(maquina);
    }

    @DeleteMapping("/{id}")
    public void eliminarMaquina(@PathVariable long id) {
        operacionService.registrarLog("maquina", "delete", "Eliminar maquina por id: " + id);
        maquinaservice.deleteMaquina(id);
    }

    public Maquina actualizarMaquina(@RequestBody Maquina maquina, @RequestParam long id) {
        operacionService.registrarLog("maquina", "put", "Actualizar maquina por id: " + id);
        return maquinaservice.update(id, maquina);
    }


}
