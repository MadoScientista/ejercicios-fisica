package com.generador_ejercicio.ejercicios_fisica.model.enums;

public enum MagnitudFisica {
    POSICION_INICIAL("Posición inicial", "x0", UnidadDeMedida.LONGITUD, "m"),
    POSICION("Posición final", "x", UnidadDeMedida.LONGITUD, "m"),
    TIEMPO("Tiempo", "t", UnidadDeMedida.TIEMPO, "s"),
    RAPIDEZ("Rapidez", "v", UnidadDeMedida.VELOCIDAD, "m/s"),
    VELOCIDAD("Velocidad", "v", UnidadDeMedida.VELOCIDAD, "m/s"),
    ACELERACION("Aceleracion", "a", UnidadDeMedida.ACELERACION, "m/s2"),
    FUERZA("Fuerza", "F", UnidadDeMedida.FUERZA, "N"),
    TRABAJO("Trabajo", "W", UnidadDeMedida.TRABAJO, "J");

    private String nombre;
    private String simbolo;
    private String unidadSI;

    private MagnitudFisica(String nombre, String simbolo, UnidadDeMedida unidadDeMedida, String unidadSI){
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.unidadSI = unidadSI;
    }

    public String getNombre(){return nombre;}
    public String getSimbolo(){return simbolo;}
    public String getUnidad(){return unidadSI;}
    
}
