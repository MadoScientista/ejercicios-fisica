package com.generador_ejercicio.ejercicios_fisica.model.enums;

public enum Conversion {

    // Unidades de distancia
    M_A_KM("m", "km", 0.001),
    M_A_CM("m", "cm", 100),
    M_A_MM("m", "mm", 1000),

    // Unidades de tiempo
    S_A_MIN("s", "min", 1/60),
    S_A_H("s", "h", (1/3600)),

    // Unidades de velocidad
    MS_A_KMH("m/s", "km/h", 3.6);

    String unidadEntrada;
    String unidadSalida;
    double factorConversion;

    private Conversion(String unidadEntrada, String unidadSalida, double factorConversion){
        this.unidadEntrada = unidadEntrada;
        this.unidadSalida = unidadSalida;
        this.factorConversion = factorConversion;
    }

    public String getUnidadEntrada(){return unidadEntrada;}
    public String getUnidadSalida(){return unidadSalida;}
    public double getFactorConversion(){return factorConversion;}
}
