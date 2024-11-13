package com.uptc.frw.casoestudio.service.logs;

import com.uptc.frw.casoestudio.models.Logs.Operacion;
import com.uptc.frw.casoestudio.repository.logs.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;

    public void registrarLog(String entidad, String operacion, String detalles){
        Operacion log = new Operacion();
        log.setId(UUID.randomUUID().toString());
        log.setEntidad(entidad);
        log.setOperacion(operacion);
        log.setDetalles(detalles);
        log.setFecha(new Date());
        System.out.println(log.getId());
        operacionRepository.save(log);
    }



}
