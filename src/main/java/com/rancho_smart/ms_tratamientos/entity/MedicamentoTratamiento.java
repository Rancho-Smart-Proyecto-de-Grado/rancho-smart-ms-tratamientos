package com.rancho_smart.ms_tratamientos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICAMENTO")
public class MedicamentoTratamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamentoTratamiento;

    @Column(name = "ID_MEDICAMENTO")
    private Long idMedicamento;

    @Column(name = "DOSIS_RECOMENDADA")
    private double dosisRecomendada;

    @Column(name = "FRECUENCIA")
    private String frecuencia;

    @Column(name = "OBSERVACIONES")
    private String observaciones;
   
    public MedicamentoTratamiento() {
    }

    public MedicamentoTratamiento(Long idMedicamento, double dosisRecomendada, String frecuencia,
            String observaciones) {
        this.idMedicamento = idMedicamento;
        this.dosisRecomendada = dosisRecomendada;
        this.frecuencia = frecuencia;
        this.observaciones = observaciones;
    }

    public Long getIdMedicamentoTratamiento() {
        return idMedicamentoTratamiento;
    }

    public void setIdMedicamentoTratamiento(Long idMedicamentoTratamiento) {
        this.idMedicamentoTratamiento = idMedicamentoTratamiento;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public double getDosisRecomendada() {
        return dosisRecomendada;
    }

    public void setDosisRecomendada(double dosisRecomendada) {
        this.dosisRecomendada = dosisRecomendada;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
