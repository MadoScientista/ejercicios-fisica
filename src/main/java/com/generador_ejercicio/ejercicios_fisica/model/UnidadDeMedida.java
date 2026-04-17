package com.generador_ejercicio.ejercicios_fisica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadDeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadDeMedida;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String unidad;

    private boolean esSI;
    
    @ManyToOne
    @JoinColumn(name="idMagnitudFisica")
    private MagnitudFisica magnitudFisica;

}
