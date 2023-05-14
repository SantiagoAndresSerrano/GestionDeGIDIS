package com.project.gidis.services;

import com.project.gidis.dto.UsuarioRequestDto;
import com.project.gidis.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> obtenerUsuarios();
    void guardarUsuario(Usuario usuario);
    void borrarUsuarioPorId(Long id);
    void editarUsuario(Long id, UsuarioRequestDto usuarioDto);
    Usuario obtenerUsuarioPorId(Long id);
}
