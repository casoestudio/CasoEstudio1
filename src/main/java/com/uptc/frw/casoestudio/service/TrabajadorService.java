package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Trabajador;
import com.uptc.frw.casoestudio.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    public Trabajador findById(Long id) {
        return trabajadorRepository.findById(id.intValue()).orElse(null);
    }


    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador update(Trabajador trabajador) {
        Trabajador existingTrabajador = findById(trabajador.getId());
        existingTrabajador.setNombre(trabajador.getNombre());
        existingTrabajador.setApellido(trabajador.getApellido());
        existingTrabajador.setFechaNacimiento(trabajador.getFechaNacimiento());
        existingTrabajador.setDireccion(trabajador.getDireccion());
        existingTrabajador.setHabilidades(trabajador.getHabilidades());
        return save(existingTrabajador);
    }

    public void delete(Long id) {
        trabajadorRepository.deleteById(id.intValue());
    }

}

