package com.project.gidis.serviceImpl;

import com.project.gidis.dto.ProyectoInvestigacionRequestDto;
import com.project.gidis.entities.ProyectoInvestigacion;
import com.project.gidis.repositories.ProyectoInvestigacionRepository;
import com.project.gidis.services.ProyectoInvestigacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProyectoInvestigacionServiceImpl implements ProyectoInvestigacionService {
    @Autowired
    private final ProyectoInvestigacionRepository proyectoInvestigacionRepository;

    @Override
    public List<ProyectoInvestigacion> obtenerProyectosInvestigacion() {
        return proyectoInvestigacionRepository.findAll();
    }

    @Override
    public void guardarProyectoInvestigacion(ProyectoInvestigacion proyectoInvestigacion) {
        proyectoInvestigacionRepository.save(proyectoInvestigacion);
    }

    @Override
    public void borrarProyectoInvestigacionPorId(Long id) {
        proyectoInvestigacionRepository.deleteById(id);
    }

    @Override
    public void editarProyectoInvestigacion(Long id, ProyectoInvestigacionRequestDto proyectoInvestigacionDto) {
        ProyectoInvestigacion proyectoInvestigacion = obtenerProyectoInvestigacionPorId(id);
        proyectoInvestigacion.setTitulo(proyectoInvestigacionDto.getTitulo());
        proyectoInvestigacion.setMesFin(proyectoInvestigacionDto.getMesFin());
        proyectoInvestigacion.setAnioFin(proyectoInvestigacionDto.getAnioFin());
        proyectoInvestigacion.setFuenteFinanciacion(proyectoInvestigacionDto.getFuenteFinanciacion());
        proyectoInvestigacion.setInstituciones(proyectoInvestigacionDto.getInstituciones());
        proyectoInvestigacionRepository.save(proyectoInvestigacion);
    }

    @Override
    public void editProyectoInvestigacion(Long id, ProyectoInvestigacionRequestDto proyectoInvestigacionDto) {
        proyectoInvestigacionRepository.updateProyectoInvestigacion(
                id,
                proyectoInvestigacionDto.getTitulo(),
                proyectoInvestigacionDto.getTipoProyecto(),
                proyectoInvestigacionDto.getMesInicio(),
                proyectoInvestigacionDto.getMesFin(),
                proyectoInvestigacionDto.getAnioInicio(),
                proyectoInvestigacionDto.getAnioFin(),
                proyectoInvestigacionDto.isFinanciado(),
                proyectoInvestigacionDto.getFuenteFinanciacion(),
                proyectoInvestigacionDto.getAmbito(),
                proyectoInvestigacionDto.getResumen(),
                proyectoInvestigacionDto.getInstituciones()
        );
    }

    @Override
    public ProyectoInvestigacion obtenerProyectoInvestigacionPorId(Long id) {
        return proyectoInvestigacionRepository.findById(id).get();
    }
}
