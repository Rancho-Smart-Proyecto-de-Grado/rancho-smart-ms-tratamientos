package com.rancho_smart.ms_tratamientos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_tratamientos.entity.Tratamiento;
import com.rancho_smart.ms_tratamientos.service.TratamientoService;


@RestController
@RequestMapping("/tratamientos")
public class TratamientoRESTController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping
    public List<Tratamiento> getAllTratamientos() {
        return tratamientoService.getAllTratamientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> getTratamientoById(@PathVariable Long id) {
        return tratamientoService.getTratamientoById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tratamiento createTratamiento(@RequestBody Tratamiento tratamiento) {
        return tratamientoService.createTratamiento(tratamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> updateTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamientoDetails) {
        return tratamientoService.updateTratamiento(id, tratamientoDetails)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTratamiento(@PathVariable Long id) {
        if (tratamientoService.deleteTratamiento(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}