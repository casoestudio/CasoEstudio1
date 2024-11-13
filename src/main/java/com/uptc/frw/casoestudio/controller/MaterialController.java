package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Material;
import com.uptc.frw.casoestudio.service.MaterialService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MaterialController {


    @Autowired
    private MaterialService materialService;

    @Autowired
    private OperacionService operacionService;

    @GetMapping
    public List<Material> listarMaterials() {
        operacionService.registrarLog("Material", "get", "listarMaterials");
   return materialService.listarMaterials;
    }





}
