package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Material;
import com.uptc.frw.casoestudio.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }
    public Optional<Material> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }
    public Material updateMaterial(Long id, Material material) {
        if (materialRepository.existsById(id)) {
            material.setIdMaterial(id);
            return materialRepository.save(material);
        } else {
            return null; // Maneja el caso de entidad no encontrada
        }
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }



}