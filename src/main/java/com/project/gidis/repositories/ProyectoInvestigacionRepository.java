package com.project.gidis.repositories;

import com.project.gidis.entities.ProyectoInvestigacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProyectoInvestigacionRepository extends JpaRepository<ProyectoInvestigacion, Long> {
    @Modifying
    @Query("UPDATE ProyectoInvestigacion p SET " +
            "p.titulo = COALESCE(:titulo, p.titulo), " +
            "p.tipoProyecto = COALESCE(:tipoProyecto, p.tipoProyecto), " +
            "p.mesInicio = COALESCE(:mesInicio, p.mesInicio), " +
            "p.mesFin = COALESCE(:mesFin, p.mesFin), " +
            "p.anioInicio = COALESCE(:anioInicio, p.anioInicio), " +
            "p.anioFin = COALESCE(:anioFin, p.anioFin), " +
            "p.financiado = COALESCE(:financiado, p.financiado), " +
            "p.fuenteFinanciacion = COALESCE(:fuenteFinanciacion, p.fuenteFinanciacion), " +
            "p.ambito = COALESCE(:ambito, p.ambito), " +
            "p.resumen = COALESCE(:resumen, p.resumen), " +
            "p.instituciones = COALESCE(:instituciones, p.instituciones) " +
            "WHERE p.id = :id"
    )
    void updateProyectoInvestigacion(@Param("id") Long id,
                        @Param("titulo") String titulo,
                        @Param("tipoProyecto") String tipoProyecto,
                        @Param("mesInicio") String mesInicio,
                        @Param("mesFin") String mesFin,
                        @Param("anioInicio") String anioInicio,
                        @Param("anioFin") String anioFin,
                        @Param("financiado") boolean financiado,
                        @Param("fuenteFinanciacion") String fuenteFinanciacion,
                        @Param("ambito") String ambito,
                        @Param("resumen") String resumen,
                        @Param("instituciones") String instituciones
    );

}
