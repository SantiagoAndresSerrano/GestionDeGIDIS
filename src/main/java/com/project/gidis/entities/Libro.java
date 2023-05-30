package com.project.gidis.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISBN;
    private String titulo;
    private String lugarPublicacion;
    private String editorial;
    private String disciplina;
    private String certificadoCreditos;
    private String certificadoInstitucionAvala;

    @ManyToMany (mappedBy = "libro")
    private Set<Usuario> usuario;

}
