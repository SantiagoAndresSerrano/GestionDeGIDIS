package com.project.gidis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroRequestDto {

    private String isbn;
    private String titulo;
    private String lugarPublicacion;
    private String editorial;
    private String disciplina;
    private String certificadoCreditos;
    private String certificadoInstitucionAvala;
}
