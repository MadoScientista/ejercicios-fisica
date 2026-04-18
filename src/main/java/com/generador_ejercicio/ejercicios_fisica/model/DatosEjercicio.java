package com.generador_ejercicio.ejercicios_fisica.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosEjercicio {
    private Set<Dato> datos;
    private VariableFisica incognita;

    public void agregarDato(Dato dato){
        datos.add(dato);
    }
}
