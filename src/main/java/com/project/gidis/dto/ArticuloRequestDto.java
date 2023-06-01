package com.project.gidis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloRequestDto {

    private String titulo;
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
}
