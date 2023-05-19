package com.project.gidis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduccionRequestDto {

    private String titulo;
    private String anio;
    private String mes;
    private String medioDivulgacion;
    private String documentoEvidencia;
}
