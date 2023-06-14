package com.project.gidis.repositories;

import com.project.gidis.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    @Modifying
    @Query("UPDATE Articulo a SET " +
            "a.titulo = COALESCE(:titulo, a.titulo), " +
            "a.paginaInicial = COALESCE(:paginaInicial, a.paginaInicial), " +
            "a.paginaFinal = COALESCE(:paginaFinal, a.paginaFinal), " +
            "a.nombreRevista = COALESCE(:nombreRevista, a.nombreRevista), " +
            "a.tipoArticulo = COALESCE(:tipoArticulo, a.tipoArticulo), " +
            "a.volumen = COALESCE(:volumen, a.volumen), " +
            "a.fasciculoRevista = COALESCE(:fasciculoRevista, a.fasciculoRevista), " +
            "a.serieRevista = COALESCE(:serieRevista, a.serieRevista), " +
            "a.ciudad = COALESCE(:ciudad, a.ciudad), " +
            "a.digitalObjectIdentifierDOI = COALESCE(:digitalObjectIdentifierDOI, a.digitalObjectIdentifierDOI), " +
            "a.medioDivulgacion = COALESCE(:medioDivulgacion, a.medioDivulgacion), " +
            "a.coautores = COALESCE(:coautores, a.coautores), " +
            "a.idioma = COALESCE(:idioma, a.idioma) " +
            "WHERE a.id = :id"
    )
    void updateArticulo(@Param("id") Long id,
                        @Param("titulo") String titulo,
                        @Param("paginaInicial") String paginaInicial,
                        @Param("paginaFinal") String paginaFinal,
                        @Param("nombreRevista") String nombreRevista,
                        @Param("tipoArticulo") String tipoArticulo,
                        @Param("volumen") String volumen,
                        @Param("fasciculoRevista") String fasciculoRevista,
                        @Param("serieRevista") String serieRevista,
                        @Param("ciudad") String ciudad,
                        @Param("digitalObjectIdentifierDOI") String digitalObjectIdentifierDOI,
                        @Param("medioDivulgacion") String medioDivulgacion,
                        @Param("coautores") String coautores,
                        @Param("idioma") String idioma
    );
}
