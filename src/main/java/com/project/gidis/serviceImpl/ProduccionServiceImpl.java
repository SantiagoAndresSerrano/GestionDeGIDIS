package com.project.gidis.serviceImpl;

import com.project.gidis.dto.ProduccionRequestDto;
import com.project.gidis.entities.Produccion;
import com.project.gidis.repositories.ProduccionRepository;
import com.project.gidis.services.ProduccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProduccionServiceImpl implements ProduccionService {

    private final ProduccionRepository produccionRepository;

    @Override
    public List<Produccion> obtenerProducciones() {
        return produccionRepository.findAll();
    }

    @Override
    public void guardarProduccion(Produccion produccion) {
        produccionRepository.save(produccion);
    }

    @Override
    public void borrarProduccionPorId(Long id) {
        produccionRepository.deleteById(id);
    }

    @Override
    public void editarProduccion(Long id, ProduccionRequestDto produccionDto) {
        Produccion produccion = obtenerProduccionPorId(id);
        produccion.setTitulo(produccionDto.getTitulo());
        produccion.setAnio(produccionDto.getAnio());
        produccion.setMes(produccionDto.getMes());
        produccion.setMedioDivulgacion(produccionDto.getMedioDivulgacion());
        produccion.setDocumentoEvidencia(produccionDto.getDocumentoEvidencia());


        produccionRepository.save(produccion);
    }

    @Override
    public Produccion obtenerProduccionPorId(Long id) {
        return produccionRepository.findById(id).get();
    }
}
