package com.project.gidis.repositories;

import com.project.gidis.entities.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsUsuarioByEmailAndClave(String email, String clave);
}
