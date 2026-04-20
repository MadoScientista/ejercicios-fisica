package com.generador_ejercicio.ejercicios_fisica.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RespuestaEjercicioDTO {
    private String textoCompleto;
    private String tema;
    private String contexto;
    private String incognita;
    private String dificultad;
    private String enunciado;
    private List<Map<String, Object>> datos;

    public RespuestaEjercicioDTO(){
        datos = new ArrayList<>();
    }
}
