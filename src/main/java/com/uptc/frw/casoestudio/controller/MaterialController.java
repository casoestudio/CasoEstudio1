package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Material;
import com.uptc.frw.casoestudio.service.MaterialService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materiales")
public class MaterialController {

    @Autowired
    private final MaterialService materialService;
    @Autowired
    private final OperacionService operacionService;



    public MaterialController(MaterialService materialService, OperacionService operacionService) {
        this.materialService = materialService;
        this.operacionService = operacionService;
    }

    @GetMapping
    public List<Material> obtenerMateriales() {
        operacionService.registrarLog("material", "get", "Consulta todos los materiales");
        return materialService.getAllMaterials();
    }

    @GetMapping("{id}")
    public Optional<Material> obtenerMaterialPorId(@PathVariable long id) {
        operacionService.registrarLog("material", "get", "Consulta el material por id: " + id);
        return materialService.getMaterialById(id);
    }

    @PostMapping
    public Material crearMaterial(@RequestBody Material material) {
        operacionService.registrarLog("material", "post", "Crear el material: " + material);
        return materialService.saveMaterial(material);
    }

    @DeleteMapping("/{id}")
    public void eliminarMaterialPorId(@PathVariable long id) {
        operacionService.registrarLog("material", "delete", "Elimina el material por id: " + id);
        materialService.deleteMaterial(id);
    }

    @PutMapping
    public Material modificarMaterial(@RequestParam long id, @RequestBody Material material) {
        operacionService.registrarLog("material", "put", "Modifica el material por id: " + id);
        return materialService.updateMaterial(id, material);
    }
}
