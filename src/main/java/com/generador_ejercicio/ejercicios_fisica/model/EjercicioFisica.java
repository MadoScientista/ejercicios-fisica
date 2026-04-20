package com.generador_ejercicio.ejercicios_fisica.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjercicioFisica {
    private EnunciadoFisica enunciado;
    private Dificultad dificultad;
    private ContextoFisico contexto;
    private DatosEjercicio datosEjercicio;
    private TemaFisica temaFisica;
    private VariableFisica incognita;
}
