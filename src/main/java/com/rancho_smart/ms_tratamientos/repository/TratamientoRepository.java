package com.rancho_smart.ms_tratamientos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_tratamientos.entity.Tratamiento;
import java.util.List;


public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    public List<Tratamiento> findByIdHistorialMedico(Long idHistorialMedico);
}
