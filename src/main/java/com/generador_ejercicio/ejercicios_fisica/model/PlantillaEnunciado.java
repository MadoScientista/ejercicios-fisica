package com.generador_ejercicio.ejercicios_fisica.model;

import com.generador_ejercicio.ejercicios_fisica.model.enums.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.enums.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.enums.TemaFisica;

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
    private MagnitudFisica incognita;

    public PlantillaEnunciado(TemaFisica tema, ContextoFisico contexto, MagnitudFisica incognita){
        this.tema = tema;
        this.contexto = contexto;
        this.incognita = incognita;
    }

}
