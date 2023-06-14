package com.project.gidis.repositories;

import com.project.gidis.entities.Produccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface ProduccionRepository extends JpaRepository<Produccion, Long> {
}
