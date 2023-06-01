package com.project.gidis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProyectoInvestigacionRequestDto {

    private String titulo;
    private String tipoProyecto;
    private String mesInicio;
    private String mesFin;
    private String anioInicio;
    private String anioFin;
    private boolean financiado;
    private String fuenteFinanciacion;
    private String ambito;
    private String resumen;
    private String instituciones;


}
