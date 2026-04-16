package com.generador_ejercicio.ejercicios_fisica.model.enums;

public enum Dificultad {
    ELEMENTAL_POSITIVO("Elemental resultado positivo", "operaciones con números enteros"),
    ELEMENTAL_NEGATIVO("Elemental resultado negativo", "Operaciones con números enteros y resultado negativo"),
    INTERMEDIO_POSITIVO("Intermedio resultado positivo", "operaciones con conversión de unidades"),
    INTERMEDIO_NEGATIVO("Intermedio resultado negativo", "Peraciones con conversión de unidades y resultado negativo"),
    AVANZADO_POSITIVO("Avanzado resultado positivo", "Conversión de unidades y operación con decimales"),
    AVANZADO_NEGATIVO("Avanzado resultado negativo", "Conversión de unidades, operaciones con decimales y resultado negativo");

    private String nombre;
    private String descripcion;

    private Dificultad(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre(){return nombre;}
    public String getDescripcion(){return descripcion;}
}
