package com.generador_ejercicio.ejercicios_fisica.model.enums;

public enum VariableFisica {
    POSICION_INICIAL("Posición inicial", "x0", "m"),
    POSICION("Posición final", "x", "m"),
    TIEMPO("Tiempo", "t", "s"),
    VELOCIDAD("Velocidad", "v", "m/s"),
    ACELERACION("Aceleracion", "a", "m/s2"),
    FUERZA("Fuerza", "F","N"),
    TRABAJO("Trabajo", "W", "J");

    private String nombre;
    private String simbolo;
    private String unidad;

    private VariableFisica(String nombre, String simbolo, String unidad){
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.unidad = unidad;
    }

    public String getNombre(){return nombre;}
    public String getSimbolo(){return simbolo;}
    public String getUnidad(){return unidad;}
    
}
