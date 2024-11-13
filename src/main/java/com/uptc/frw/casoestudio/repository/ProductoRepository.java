package com.uptc.frw.casoestudio.repository;

import com.uptc.frw.casoestudio.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
