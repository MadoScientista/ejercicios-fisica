package com.generador_ejercicio.ejercicios_fisica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dato {
    private VariableFisica variable;
    private double valor;
    private UnidadDeMedida unidadDeMedida;
}
