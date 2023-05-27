package com.project.gidis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProyectoInvestigacionRequestDto {

    private String titulo;
    private String mesFin;
    private String anioFin;
    private String fuenteFinanciacion;
    private String instituciones;
}
