package com.generador_ejercicio.ejercicios_fisica.dto.contextoFisicoDTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseContextoFisicoDTO {

    private int id;
    private String nombre;
    private int vMin;
    private int vMax;
    private int xMin;
    private int xMax;
    private double mMin;
    private double mMax;

}
