package com.project.gidis.controllers;

import com.project.gidis.dto.ArticuloRequestDto;
import com.project.gidis.entities.Articulo;
import com.project.gidis.serviceImpl.ArticuloServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articulo")
@RequiredArgsConstructor
public class ArticuloController {

    private final ArticuloServiceImpl articuloService;

    @GetMapping
    public ResponseEntity<List<Articulo>> obtenerArticulos() {
        List<Articulo> articulos = articuloService.obtenerArticulos();
        return ResponseEntity.ok(articulos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarArticulo(@RequestBody Articulo articulo) {
        articuloService.guardarArticulo(articulo);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarArticulo(@PathVariable(name = "id") Long id) {
        articuloService.borrarArticuloPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editarArticulo(
            @PathVariable(name = "id") Long id,
            @RequestBody ArticuloRequestDto articuloDto
                                              ) {
        articuloService.editarArticulo(id, articuloDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerArticuloPorId(
            @PathVariable(name = "id") Long id
    ){
        Articulo articulo = articuloService.obtenerArticuloPorId(id);
        return ResponseEntity.ok(articulo);

    }

}
