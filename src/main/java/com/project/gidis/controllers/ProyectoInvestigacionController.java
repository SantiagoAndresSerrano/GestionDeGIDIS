package com.project.gidis.controllers;

import com.project.gidis.dto.ProyectoInvestigacionRequestDto;
import com.project.gidis.entities.ProyectoInvestigacion;
import com.project.gidis.serviceImpl.ProyectoInvestigacionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proyectoInvestigacion")
@RequiredArgsConstructor
public class ProyectoInvestigacionController {
    @Autowired
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
    public ResponseEntity<Void> editProyectoInvestigacion(
            @PathVariable(name = "id") Long id,
            @RequestBody ProyectoInvestigacionRequestDto proyectoInvestigacionDto
                                              ) {
        proyectoInvestigacionService.editProyectoInvestigacion(id, proyectoInvestigacionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoInvestigacion> obtenerProyectoInvestigacionPorId(
            @PathVariable(name = "id") Long id
    ){
        ProyectoInvestigacion proyectoInvestigacion = proyectoInvestigacionService.obtenerProyectoInvestigacionPorId(id);
        return ResponseEntity.ok(proyectoInvestigacion);

    }

}
