package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Material;
import com.uptc.frw.casoestudio.service.MaterialService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    private OperacionService operacionService;

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        return materialService.getMaterialById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialService.saveMaterial(material);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material material) {
        Material updatedMaterial = materialService.updateMaterial(id, material);
        return updatedMaterial != null ? ResponseEntity.ok(updatedMaterial) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
