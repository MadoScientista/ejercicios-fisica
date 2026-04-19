package com.generador_ejercicio.ejercicios_fisica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.repository.PlantillaEnunciadoRepository;

@Service
public class PlantillaEnunciadoService {

    @Autowired
    private PlantillaEnunciadoRepository repo;

    public PlantillaEnunciado getPlantillaEnunciado(String  nombreTema, String nombreContexto, String nombreIncognita){
        return repo.findByTema_nombreAndContexto_nombreAndIncognita_nombre(
            nombreTema, 
            nombreContexto, 
            nombreIncognita);
    }
}
