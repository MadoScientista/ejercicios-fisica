package com.generador_ejercicio.ejercicios_fisica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudEjercicioDTO {
    private String tema;
    private String contexto;
    private String incognita;
    private String dificultad;
    private boolean resultadoPositivo;
}
