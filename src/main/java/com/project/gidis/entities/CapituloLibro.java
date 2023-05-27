package com.project.gidis.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "capitulo")
public class CapituloLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paginaFinal;
    private String paginaInicial;
    private String tituloLibro;
    private String serieLibro;
    private String edicion;
    private String lugarPublicacion;
    private String disciplina;
    private String coautores;
    private String areaDeConocimiento;

}
