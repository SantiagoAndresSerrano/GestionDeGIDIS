package com.project.gidis.controllers;

import com.project.gidis.dto.CapituloLibroRequestDto;
import com.project.gidis.entities.CapituloLibro;
import com.project.gidis.serviceImpl.CapituloLibroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articulo")
@RequiredArgsConstructor
public class CapituloLibroController {

    private final CapituloLibroServiceImpl capituloLibroService;

    @GetMapping
    public ResponseEntity<List<CapituloLibro>> obtenerCapitulosLibros() {
        List<CapituloLibro> capituloLibros = capituloLibroService.obtenerCapitulosLibros();
        return ResponseEntity.ok(capituloLibros);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarCapituloLibro(@RequestBody CapituloLibro capituloLibro) {
        capituloLibroService.guardarCapituloLibro(capituloLibro);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarCapituloLibro(@PathVariable(name = "id") Long id) {
        capituloLibroService.borrarCapituloLibroPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editarLibro(
            @PathVariable(name = "id") Long id,
            @RequestBody CapituloLibroRequestDto capituloLibroDto
                                              ) {
        capituloLibroService.editarCapituloLibro(id, capituloLibroDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapituloLibro> obtenerCapituloLibroPorId(
            @PathVariable(name = "id") Long id
    ){
        CapituloLibro capituloLibro = capituloLibroService.obtenerCapituloLibroPorId(id);
        return ResponseEntity.ok(capituloLibro);

    }

}
