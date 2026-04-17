package com.generador_ejercicio.ejercicios_fisica.model.enums;

public enum TemaFisica {
    MRU("Movimiento Rectilíneo Uniforme"), 
    MRUA("Movimiento Rectilíneo Uniforme Acelerado"),
    FUERZA("Fuerza"), 
    TRABAJO("Trabajo");

    private String nombre;

    private TemaFisica(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){return nombre;}
}
