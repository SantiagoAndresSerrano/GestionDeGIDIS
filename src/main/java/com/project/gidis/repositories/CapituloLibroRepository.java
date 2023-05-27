package com.project.gidis.repositories;

import com.project.gidis.entities.CapituloLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapituloLibroRepository extends JpaRepository<CapituloLibro, Long> {
}
