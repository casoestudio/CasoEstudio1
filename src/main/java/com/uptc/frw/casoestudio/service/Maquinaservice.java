package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Maquina;
import com.uptc.frw.casoestudio.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class Maquinaservice {
    @Autowired
    private MaquinaRepository maquinaRepository;
    public List<Maquina> findAll(){
        return maquinaRepository.findAll();
    }

    public Maquina findMaquina(String numeroSerie) {
        return maquinaRepository.findByNumeroSerie(numeroSerie).orElse(null);
    }


    public Maquina save(Maquina maquina){
        return maquinaRepository.save(maquina);
    }
    public Maquina update(Maquina maquina) {
        Maquina maquinaOne = findMaquina(maquina.getNumeroSerie());
        maquinaOne.setModelo(maquina.getModelo());
        return save(maquinaOne);
    }


    public void deleteMaquina(Maquina maquina){
        maquinaRepository.delete(maquina);
    }


}























