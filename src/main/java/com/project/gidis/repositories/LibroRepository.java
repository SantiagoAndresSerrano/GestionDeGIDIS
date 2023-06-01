package com.project.gidis.repositories;

import com.project.gidis.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Modifying
    @Query("UPDATE Libro l SET " +
            "l.isbn = COALESCE(:isbn, l.isbn), " +
            "l.titulo = COALESCE(:titulo, l.titulo), " +
            "l.lugarPublicacion = COALESCE(:lugarPublicacion, l.lugarPublicacion), " +
            "l.editorial = COALESCE(:editorial, l.editorial), " +
            "l.disciplina = COALESCE(:disciplina, l.disciplina), " +
            "l.certificadoCreditos = COALESCE(:certificadoCreditos, l.certificadoCreditos), " +
            "l.certificadoInstitucionAvala = COALESCE(:certificadoInstitucionAvala, l.certificadoInstitucionAvala) " +
            "WHERE l.id = :id"
    )
    void updateLibro(@Param("id") Long id,
                                     @Param("isbn") String isbn,
                                     @Param("titulo") String titulo,
                                     @Param("lugarPublicacion") String lugarPublicacion,
                                     @Param("editorial") String editorial,
                                     @Param("disciplina") String disciplina,
                                     @Param("certificadoCreditos") String certificadoCreditos,
                                     @Param("certificadoInstitucionAvala") String certificadoInstitucionAvala
    );
}
