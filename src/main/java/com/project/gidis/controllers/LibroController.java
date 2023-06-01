package com.project.gidis.controllers;

import com.project.gidis.dto.LibroRequestDto;
import com.project.gidis.entities.Libro;
import com.project.gidis.serviceImpl.LibroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
@RequiredArgsConstructor
public class LibroController {

    private final LibroServiceImpl libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerLibros() {
        List<Libro> libros = libroService.obtenerLibros();
        return ResponseEntity.ok(libros);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarLibro(@RequestBody Libro libro) {
        libroService.guardarLibro(libro);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarLibro(@PathVariable(name = "id") Long id) {
        libroService.borrarLibroPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editLibro(
            @PathVariable(name = "id") Long id,
            @RequestBody LibroRequestDto libroDto
                                              ) {
        libroService.editLibro(id, libroDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(
            @PathVariable(name = "id") Long id
    ){
        Libro libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);

    }

}
