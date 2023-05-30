package com.project.gidis.controllers;

import com.project.gidis.dto.LoginRequestDto;
import com.project.gidis.dto.LoginResponseDto;
import com.project.gidis.dto.RegistroResponseDto;
import com.project.gidis.dto.UsuarioRequestDto;
import com.project.gidis.entities.Usuario;
import com.project.gidis.serviceImpl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/guardar")
    public ResponseEntity<RegistroResponseDto> guardarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.guardarUsuario(usuario);
            return new ResponseEntity(new RegistroResponseDto(true),HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(new RegistroResponseDto(false),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable(name = "id") Long id) {
        usuarioService.borrarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> editarUsuario(
            @PathVariable(name = "id") Long id,
            @RequestBody UsuarioRequestDto usuarioDto
                                              ) {
        usuarioService.editarUsuario(id, usuarioDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(
            @PathVariable(name = "id") Long id
    ){
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUsuario(
            @RequestBody LoginRequestDto loginRequestDto
    ) {
       if (usuarioService.loginUsuario(loginRequestDto)) {
           return ResponseEntity.ok(new LoginResponseDto(true));
       }
        return new ResponseEntity<> (new LoginResponseDto(false),HttpStatus.BAD_REQUEST);

    }


}
