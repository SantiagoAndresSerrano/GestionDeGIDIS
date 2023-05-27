package com.project.gidis.services;

import com.project.gidis.dto.CapituloLibroRequestDto;
import com.project.gidis.entities.CapituloLibro;

import java.util.List;

public interface CapituloLibroService {

    List<CapituloLibro> obtenerCapitulosLibros();
    void guardarUsuario(CapituloLibro capituloLibro);
    void borrarCapituloLibroPorId(Long id);
    void editarCapituloLibro(Long id, CapituloLibroRequestDto capituloLibroDto);
    CapituloLibro obtenerCapituloLibroPorId(Long id);
}
