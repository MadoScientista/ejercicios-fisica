package com.generador_ejercicio.ejercicios_fisica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.repository.PlantillaEnunciadoRepository;

@Service
public class PlantillaEnunciadoService {

    @Autowired
    private PlantillaEnunciadoRepository repo;


    //-------------------------------------------------------------
    //-------------- SECCIÓN GET EJERCICIOS -----------------------
    //-------------------------------------------------------------

    public List<PlantillaEnunciado> getPlantillas(){
        return repo.findAllByOrderByIdPlantillaEnunciadoAsc();
    }


    public List<PlantillaEnunciado> getPlantillaEnunciado(String  nombreTema, String nombreContexto, String nombreIncognita, boolean resultadoPositivo){
        return repo.findByTema_nombreAndContexto_nombreAndIncognita_nombreAndResultadoPositivo(
            nombreTema, 
            nombreContexto, 
            nombreIncognita,
            resultadoPositivo);
    }

}
