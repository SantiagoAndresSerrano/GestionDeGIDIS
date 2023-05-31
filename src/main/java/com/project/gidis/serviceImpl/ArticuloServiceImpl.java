package com.project.gidis.serviceImpl;

import com.project.gidis.dto.ArticuloRequestDto;
import com.project.gidis.entities.Articulo;
import com.project.gidis.repositories.ArticuloRepository;
import com.project.gidis.services.ArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> obtenerArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public void guardarArticulo(Articulo articulo) throws Exception{
        try {
            articuloRepository.save(articulo);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void borrarArticuloPorId(Long id) {
        articuloRepository.deleteById(id);
    }

    @Override
    public void editarArticulo(Long id, ArticuloRequestDto articuloDto) {
        Articulo articulo = obtenerArticuloPorId(id);
        articulo.setCoautores(articuloDto.getCoautores());

        articuloRepository.save(articulo);
    }

    @Override
    public Articulo obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id).get();
    }
}
