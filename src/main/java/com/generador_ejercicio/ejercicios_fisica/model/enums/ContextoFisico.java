package com.generador_ejercicio.ejercicios_fisica.model.enums;

public enum ContextoFisico {
    PERSONA("Persona", 2, 10, 10, 50, 50, 100),
    AUTOMOVIL("Automovil", 10, 30, 100, 1000, 1000, 5000),
    TREN("Tren", 20, 50, 1000, 4000, 4000, 10000),
    AVION("Avión", 40, 230, 5000, 10000, 10000, 25000),
    BALA("Bala", 85, 110, 400, 2000, 0.1, 0.12);

    private String nombre;
    private int vMin;
    private int vMax;
    private int xMin;
    private int xMax;
    private double mMin;
    private double mMax;

    private ContextoFisico(String nombre, int vMin, int vMax, int xMin, int xMax, double mMin, double mMax){
        this.nombre = nombre;
        this.vMin = vMin;
        this.vMax = vMax;
        this.xMin = xMin;
        this.xMax = xMax;
        this.mMin = mMin;
        this.mMax = mMax;
    }

    public String getNombre(){return nombre;}
    public int getVMin(){return vMin;}
    public int getVMax(){return vMax;}
    public int getXMin(){return xMin;}
    public int getXMax(){return xMax;}
    public double getmMin(){return mMin;}
    public double getmMax(){return mMax;}
    
}
