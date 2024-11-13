package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Material;
import com.uptc.frw.casoestudio.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Material findById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }


    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public Material update(Material material) {
    Material materialOne = findById(material.getIdMaterial()); // Usa el Long directamente
    materialOne.setNombreMaterial(material.getNombreMaterial());
    return materialRepository.save(materialOne);
    }




    public void deleteMaterial(Material material) {
        materialRepository.deleteById(material.getIdMaterial());
    }



}