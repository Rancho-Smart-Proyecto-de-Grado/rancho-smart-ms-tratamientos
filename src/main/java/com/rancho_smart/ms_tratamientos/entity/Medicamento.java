package com.rancho_smart.ms_tratamientos.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    @Column(name = "NOMBRE")
    private String nombre; 

    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "FABRICANTE")
    private String fabricante;

    @Column(name = "FECHA_FABRICACION")
    private LocalDate fechaFabricacion;

    @Column(name = "FECHA_EXPIRACION")
    private LocalDate fechaExpiracion;
    
    @Column(name = "DOSIS_RECOMENDADA")
    private double dosisRecomendada;

    @Column(name = "FRECUENCIA")
    private String frecuencia;

    @Column(name = "VIA_ADMINISTRACION")
    private String viaAdministracion;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    public Medicamento() {
    }

    public Medicamento(String nombre, String descripcion, String fabricante, LocalDate fechaFabricacion,
            LocalDate fechaExpiracion, double dosisRecomendada, String frecuencia, String viaAdministracion,
            String observaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaExpiracion = fechaExpiracion;
        this.dosisRecomendada = dosisRecomendada;
        this.frecuencia = frecuencia;
        this.viaAdministracion = viaAdministracion;
        this.observaciones = observaciones;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public double getDosisRecomendada() {
        return dosisRecomendada;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
