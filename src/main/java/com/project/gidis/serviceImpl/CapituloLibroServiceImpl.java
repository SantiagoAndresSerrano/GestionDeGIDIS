package com.project.gidis.serviceImpl;

import com.project.gidis.dto.CapituloLibroRequestDto;
import com.project.gidis.entities.CapituloLibro;
import com.project.gidis.repositories.CapituloLibroRepository;
import com.project.gidis.services.CapituloLibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CapituloLibroServiceImpl implements CapituloLibroService {
    @Autowired
    private final CapituloLibroRepository capituloLibroRepository;

    @Override
    public List<CapituloLibro> obtenerCapitulosLibros() {
        return capituloLibroRepository.findAll();
    }

    @Override
    public void guardarCapituloLibro(CapituloLibro capituloLibro) {
        capituloLibroRepository.save(capituloLibro);
    }

    @Override
    public void borrarCapituloLibroPorId(Long id) {
        capituloLibroRepository.deleteById(id);
    }

    @Override
    public void editarCapituloLibro(Long id, CapituloLibroRequestDto capituloLibroDto) {
        CapituloLibro capituloLibro = obtenerCapituloLibroPorId(id);
        capituloLibro.setCoautores(capituloLibroDto.getCoautores());
        capituloLibro.setAreaDeConocimiento(capituloLibroDto.getAreaDeConocimiento());

        capituloLibroRepository.save(capituloLibro);
    }

    @Override
    public CapituloLibro obtenerCapituloLibroPorId(Long id) {
        return capituloLibroRepository.findById(id).get();
    }
}
