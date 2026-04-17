package com.generador_ejercicio.ejercicios_fisica.model;

import java.util.Set;

import com.generador_ejercicio.ejercicios_fisica.model.enums.MagnitudFisica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosEjercicio {
    private Set<Variable> datos;
    private MagnitudFisica incognita;

    public void agregarDato(Variable variable){
        datos.add(variable);
    }
}
