package com.generador_ejercicio.ejercicios_fisica.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaPlantillaEnunciadoDTO {
    private long idPlantillaEnunciado;
    private String tema;
    private String contexto;
    private String incognita;
    private String signoResultado;
    private String enunciado;

}
