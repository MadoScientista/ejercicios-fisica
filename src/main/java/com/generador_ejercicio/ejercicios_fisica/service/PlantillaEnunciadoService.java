package com.generador_ejercicio.ejercicios_fisica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.model.enums.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.enums.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.enums.TemaFisica;
import com.generador_ejercicio.ejercicios_fisica.repository.PlantillaEnunciadoRepository;

@Service
public class PlantillaEnunciadoService {

    @Autowired
    private PlantillaEnunciadoRepository repo;

    public PlantillaEnunciado getPlantillaEnunciado(TemaFisica tema, ContextoFisico contexto, MagnitudFisica incognita){
        return repo.getPlantillaEnunciado(tema, contexto, incognita);
    }
}
