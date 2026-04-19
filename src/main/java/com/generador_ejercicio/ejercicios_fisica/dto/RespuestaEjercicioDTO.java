package com.generador_ejercicio.ejercicios_fisica.dto;

import java.util.Set;

import com.generador_ejercicio.ejercicios_fisica.model.Dato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaEjercicioDTO {
    private String tema;
    private String contexto;
    private String incognita;
    private String dificultad;
    private String enunciado;
    private Set<Dato> datos;
}
