package com.project.gidis.services;

import com.project.gidis.dto.ProyectoInvestigacionRequestDto;
import com.project.gidis.entities.ProyectoInvestigacion;

import java.util.List;

public interface ProyectoInvestigacionService {

    List<ProyectoInvestigacion> obtenerProyectosInvestigacion();
    void guardarProyectoInvestigacion(ProyectoInvestigacion proyectoInvestigacion);
    void borrarProyectoInvestigacionPorId(Long id);
    void editarProyectoInvestigacion(Long id, ProyectoInvestigacionRequestDto proyectoInvestigacionDto);

    void editProyectoInvestigacion(Long id, ProyectoInvestigacionRequestDto proyectoInvestigacionDto);
    ProyectoInvestigacion obtenerProyectoInvestigacionPorId(Long id);
}
