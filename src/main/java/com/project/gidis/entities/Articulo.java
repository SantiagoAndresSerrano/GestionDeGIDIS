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
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paginaInicial;
    private String paginaFinal;
    private String nombreRevista;
    private String tipoArticulo;
    private String volumen;
    private String fasciculoRevista;
    private String serieRevista;
    private String ciudad;
    private String digitalObjectIdentifierDOI;
    private String medioDivulgacion;
    private String coautores;
    private String idioma;
    @ManyToMany (mappedBy = "articulo")
    private Set<Usuario> usuario;
}
