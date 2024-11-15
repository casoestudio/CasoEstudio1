package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Maquina;
import com.uptc.frw.casoestudio.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class Maquinaservice {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public List<Maquina> findMaquinas() {
        return maquinaRepository.findAll();
    }

    public Optional<Maquina> findMaquina(long id) {
        return maquinaRepository.findById(id);
    }

    public Maquina save(Maquina maquina) {
        return maquinaRepository.save(maquina);
    }

    public void deleteMaquina(long id) {
        maquinaRepository.deleteById(id);
    }

    public Maquina update(long id, Maquina maquina) {
        if (maquinaRepository.existsById(id)) {
            maquina.setId(id);
            return maquinaRepository.save(maquina);
        } else {
            return null;
        }


    }
}






















