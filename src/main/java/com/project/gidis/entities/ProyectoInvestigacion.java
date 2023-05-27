package com.project.gidis.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "proyectoInvestigacion")
public class ProyectoInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
