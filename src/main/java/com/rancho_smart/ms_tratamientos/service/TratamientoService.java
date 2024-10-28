package com.rancho_smart.ms_tratamientos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_tratamientos.entity.Tratamiento;
import com.rancho_smart.ms_tratamientos.repository.TratamientoRepository;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<Tratamiento> getAllTratamientos() {
        return tratamientoRepository.findAll();
    }

    public Optional<Tratamiento> getTratamientoById(Long id) {
        return tratamientoRepository.findById(id);
    }

    public Tratamiento createTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Optional<Tratamiento> updateTratamiento(Long id, Tratamiento tratamientoDetails) {
        return tratamientoRepository.findById(id)
            .map(tratamiento -> {
                tratamiento.setTitulo(tratamientoDetails.getTitulo());
                tratamiento.setDescripcion(tratamientoDetails.getDescripcion());
                tratamiento.setFechaInicio(tratamientoDetails.getFechaInicio());
                tratamiento.setFechaFin(tratamientoDetails.getFechaFin());
                return tratamientoRepository.save(tratamiento);
            });
    }

    public boolean deleteTratamiento(Long id) {
        return tratamientoRepository.findById(id)
            .map(tratamiento -> {
                tratamientoRepository.delete(tratamiento);
                return true;
            }).orElse(false);
    }
}