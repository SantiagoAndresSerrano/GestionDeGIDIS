package com.project.gidis.controllers;

import com.project.gidis.dto.ProduccionRequestDto;
import com.project.gidis.entities.Produccion;
import com.project.gidis.serviceImpl.ProduccionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produccion")
@RequiredArgsConstructor
public class ProduccionController {

    private final ProduccionServiceImpl produccionService;

    @GetMapping
    public ResponseEntity<List<Produccion>> obtenerProducciones() {
        List<Produccion> producciones = produccionService.obtenerProducciones();
        return ResponseEntity.ok(producciones);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarProduccion(@RequestBody Produccion produccion) {
        produccionService.guardarProduccion(produccion);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarProduccion(@PathVariable(name = "id") Long id) {
        produccionService.borrarProduccionPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editarProduccion(
            @PathVariable(name = "id") Long id,
            @RequestBody ProduccionRequestDto produccionDto
                                              ) {
        produccionService.editarProduccion(id, produccionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produccion> obtenerProduccionPorId(
            @PathVariable(name = "id") Long id
    ){
        Produccion produccion = produccionService.obtenerProduccionPorId(id);
        return ResponseEntity.ok(produccion);

    }

}
