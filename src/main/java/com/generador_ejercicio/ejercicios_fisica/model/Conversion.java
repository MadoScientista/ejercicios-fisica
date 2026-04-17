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
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConversion;

    @Column(nullable = false)
    private String unidadEntrada;

    @Column(nullable = false)
    private String unidadSalida;
    
    @Column(nullable = false)
    private double factorConversion;
}
