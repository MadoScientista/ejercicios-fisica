package com.generador_ejercicio.ejercicios_fisica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantillaEnunciado {
    private String enunciado;
    private TemaFisica tema;
    private ContextoFisico contexto;
    private VariableFisica incognita;

    public PlantillaEnunciado(TemaFisica tema, ContextoFisico contexto, VariableFisica incognita){
        this.tema = tema;
        this.contexto = contexto;
        this.incognita = incognita;
    }

}
