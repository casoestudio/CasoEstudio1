package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Trabajador;
import com.uptc.frw.casoestudio.repository.TrabajadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;


    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    public Optional<Trabajador> findById(Long id) {
        return trabajadorRepository.findById(id);
    }


    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador update(Long id, Trabajador trabajador) {
        if (trabajadorRepository.existsById(id)) {
            trabajador.setId(id);  // Aseguramos que el ID sea el correcto para la actualización
            return trabajadorRepository.save(trabajador);
        } else {
            return null; // Retornamos null si no se encuentra el trabajador con el ID especificado
        }
    }

    public void delete(Long id) {
        trabajadorRepository.deleteById(id);
    }
}



