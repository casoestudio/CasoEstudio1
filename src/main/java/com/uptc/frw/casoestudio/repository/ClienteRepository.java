package com.uptc.frw.casoestudio.repository;

import com.uptc.frw.casoestudio.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
