package com.project.gidis.serviceImpl;

import com.project.gidis.dto.LibroRequestDto;
import com.project.gidis.entities.Libro;
import com.project.gidis.repositories.LibroRepository;
import com.project.gidis.services.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void borrarLibroPorId(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public void editarLibro(Long id, LibroRequestDto libroDto) {
        Libro libro = obtenerLibroPorId(id);
        libro.setCertificadoCreditos(libroDto.getCertificadoCreditos());
        libro.setCertificadoInstitucionAvala(libroDto.getCertificadoInstitucionAvala());

        libroRepository.save(libro);
    }

    @Override
    public void editLibro(Long id, LibroRequestDto libroDto) {
        libroRepository.updateLibro(id,
                libroDto.getIsbn(),
                libroDto.getTitulo(),
                libroDto.getLugarPublicacion(),
                libroDto.getEditorial(),
                libroDto.getDisciplina(),
                libroDto.getCertificadoCreditos(),
                libroDto.getCertificadoInstitucionAvala()
                );
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id).get();
    }
}
