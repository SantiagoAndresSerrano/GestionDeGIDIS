package com.project.gidis.services;

import com.project.gidis.dto.ArticuloRequestDto;
import com.project.gidis.entities.Articulo;

import java.util.List;

public interface ArticuloService {

    List<Articulo> obtenerArticulos();
    void guardarArticulo(Articulo articulo) throws Exception;
    void borrarArticuloPorId(Long id);
    void editarArticulo(Long id, ArticuloRequestDto articuloDto);
    void editArticulo(Long id, ArticuloRequestDto articuloDto);
    Articulo obtenerArticuloPorId(Long id);
}
