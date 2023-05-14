package com.project.gidis.serviceImpl;

import com.project.gidis.dto.UsuarioRequestDto;
import com.project.gidis.entities.Usuario;
import com.project.gidis.repositories.UsuarioRepository;
import com.project.gidis.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.project.gidis.util.Rol.DOCENTE;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setRol(DOCENTE);
        usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editarUsuario(Long id, UsuarioRequestDto usuarioDto) {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setClave(usuarioDto.getClave());

        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }
}
