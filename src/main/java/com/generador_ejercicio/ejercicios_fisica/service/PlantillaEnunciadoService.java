package com.generador_ejercicio.ejercicios_fisica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.TemaFisica;
import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;
import com.generador_ejercicio.ejercicios_fisica.repository.PlantillaEnunciadoRepository;

@Service
public class PlantillaEnunciadoService {

    @Autowired
    private PlantillaEnunciadoRepository repo;

    public PlantillaEnunciado getPlantillaEnunciado(TemaFisica tema, ContextoFisico contexto, VariableFisica incognita){
        return repo.getPlantillaEnunciado(tema, contexto, incognita);
    }
}
