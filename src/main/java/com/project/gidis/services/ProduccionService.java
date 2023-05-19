package com.project.gidis.services;

import com.project.gidis.dto.ProduccionRequestDto;
import com.project.gidis.entities.Produccion;

import java.util.List;

public interface ProduccionService {

    List<Produccion> obtenerProducciones();
    void guardarProduccion(Produccion produccion);
    void borrarProduccionPorId(Long id);
    void editarProduccion(Long id, ProduccionRequestDto produccionDto);
    Produccion obtenerProduccionPorId(Long id);
}
