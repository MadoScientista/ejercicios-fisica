package com.generador_ejercicio.ejercicios_fisica.model.enums;

import java.util.Set;

public enum UnidadDeMedida {
    LONGITUD("Longitud", Set.of("m", "km", "cm", "mm")),
    TIEMPO("Tiempo", Set.of("s", "min", "h")),
    VELOCIDAD("Velocidad", Set.of("m/s", "km/h", "cm/s")),
    ACELERACION("Aceleracion", Set.of("m/s2", "km/h2", "cm/s2")),
    FUERZA("Fuerza", Set.of("N", "kN", "lbf")),
    TRABAJO("Trabajo", Set.of("J", "kJ", "cal"));  

    private String nombre;
    private Set<String> unidadesValidas;

    private UnidadDeMedida(String nombre, Set<String> unidadesValidas){
        this.nombre = nombre;
        this.unidadesValidas = unidadesValidas;
    }

    public String getNombre(){return nombre;}

    public boolean validarUnidad(String unidad){
        if(unidadesValidas.contains(unidad)){
            return true;
        }
        return false;
    }
}
