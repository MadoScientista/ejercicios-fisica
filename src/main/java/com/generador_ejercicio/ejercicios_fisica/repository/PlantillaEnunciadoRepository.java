package com.generador_ejercicio.ejercicios_fisica.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.model.enums.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.enums.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.enums.TemaFisica;

@Repository
public class PlantillaEnunciadoRepository {

    @Autowired
    private PlantillaEnunciado plantillaEnunciado;

    public PlantillaEnunciado getPlantillaEnunciado(TemaFisica tema, ContextoFisico contexto, MagnitudFisica incognita){
        plantillaEnunciado = new PlantillaEnunciado(tema, contexto, incognita);
        return plantillaEnunciado;
    }
}
