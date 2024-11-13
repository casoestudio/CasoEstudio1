package com.uptc.frw.casoestudio.repository;

import com.uptc.frw.casoestudio.models.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
    Optional<Maquina> findByNumeroSerie(String numeroSerie);

}
