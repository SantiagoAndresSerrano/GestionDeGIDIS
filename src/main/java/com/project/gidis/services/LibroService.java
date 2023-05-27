package com.project.gidis.services;

import com.project.gidis.dto.LibroRequestDto;
import com.project.gidis.entities.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> obtenerLibros();
    void guardarLibro(Libro libro);
    void borrarLibroPorId(Long id);
    void editarLibro(Long id, LibroRequestDto libroDto);
    Libro obtenerLibroPorId(Long id);
}
