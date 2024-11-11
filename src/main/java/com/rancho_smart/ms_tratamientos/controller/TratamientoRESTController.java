package com.rancho_smart.ms_tratamientos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Tratamiento>> getAllTratamientos() {
        List<Tratamiento> tratamientos = tratamientoService.getAllTratamientos();
        return ResponseEntity.ok(tratamientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> getTratamientoById(@PathVariable Long id) {
        return tratamientoService.getTratamientoById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/historial/{idHistorialMedico}")
    public ResponseEntity<List<Tratamiento>> getTratamientosByIdHistorialMedico(@PathVariable Long idHistorialMedico) {
        List<Tratamiento> tratamientos = tratamientoService.getTratamientosByIdHistorialMedico(idHistorialMedico);
        if (tratamientos != null && !tratamientos.isEmpty()) {
            return ResponseEntity.ok(tratamientos);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Tratamiento> createTratamiento(@RequestBody Tratamiento tratamiento) {
        Tratamiento createdTratamiento = tratamientoService.createTratamiento(tratamiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTratamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> updateTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamientoDetails) {
        return tratamientoService.updateTratamiento(id, tratamientoDetails)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTratamiento(@PathVariable Long id) {
        if (tratamientoService.deleteTratamiento(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
