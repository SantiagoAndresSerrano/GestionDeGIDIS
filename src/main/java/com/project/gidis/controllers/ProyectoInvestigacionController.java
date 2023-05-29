package com.project.gidis.controllers;

import com.project.gidis.dto.ProyectoInvestigacionRequestDto;
import com.project.gidis.entities.ProyectoInvestigacion;
import com.project.gidis.serviceImpl.ProyectoInvestigacionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articulo")
@RequiredArgsConstructor
public class ProyectoInvestigacionController {

    private final ProyectoInvestigacionServiceImpl proyectoInvestigacionService;

    @GetMapping
    public ResponseEntity<List<ProyectoInvestigacion>> obtenerProyectosInvestigacion() {
        List<ProyectoInvestigacion> proyectosInvestigacion = proyectoInvestigacionService.obtenerProyectosInvestigacion();
        return ResponseEntity.ok(proyectosInvestigacion);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarProyectoInvestigacion(@RequestBody ProyectoInvestigacion proyectoInvestigacion) {
        proyectoInvestigacionService.guardarProyectoInvestigacion(proyectoInvestigacion);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarProyectoInvestigacion(@PathVariable(name = "id") Long id) {
        proyectoInvestigacionService.borrarProyectoInvestigacionPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editarProyectoInvestigacion(
            @PathVariable(name = "id") Long id,
            @RequestBody ProyectoInvestigacionRequestDto proyectoInvestigacionDto
                                              ) {
        proyectoInvestigacionService.editarProyectoInvestigacion(id, proyectoInvestigacionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoInvestigacion> obtenerProyectoInvestigacionPorId(
            @PathVariable(name = "id") Long id
    ){
        ProyectoInvestigacion articulo = proyectoInvestigacionService.obtenerProyectoInvestigacionPorId(id);
        return ResponseEntity.ok(articulo);

    }

}
