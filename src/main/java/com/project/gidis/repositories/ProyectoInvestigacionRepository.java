package com.project.gidis.repositories;

import com.project.gidis.entities.ProyectoInvestigacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoInvestigacionRepository extends JpaRepository<ProyectoInvestigacion, Long> {
}
