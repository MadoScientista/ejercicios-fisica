package com.generador_ejercicio.ejercicios_fisica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContextoFisico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContextoFisico;

    @Column(unique = true, nullable = false)
    private String nombre;
    
    private int vMin;
    private int vMax;
    private int xMin;
    private int xMax;
    private double mMin;
    private double mMax;

}
