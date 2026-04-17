package com.generador_ejercicio.ejercicios_fisica.model;

import com.generador_ejercicio.ejercicios_fisica.model.enums.MagnitudFisica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Variable {
    private MagnitudFisica magnitud;
    private double valor;
    private String unidad;
}
