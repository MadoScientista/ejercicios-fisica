package com.generador_ejercicio.ejercicios_fisica.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.DatosEjercicio;
import com.generador_ejercicio.ejercicios_fisica.model.EjercicioFisica;
import com.generador_ejercicio.ejercicios_fisica.model.EnunciadoFisica;
import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.Dificultad;
import com.generador_ejercicio.ejercicios_fisica.model.TemaFisica;
import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;
import com.generador_ejercicio.ejercicios_fisica.service.generadores.GeneradorValoresMRU;

@Service
public class EjercicioFisicaService {

    @Autowired
    private PlantillaEnunciadoService peService;


    public EjercicioFisicaService(){

    }

    public EjercicioFisica getEjercicio(TemaFisica tema, ContextoFisico contexto, VariableFisica incognita, Dificultad dificultad){
        String nombreTema = tema.getNombre();

        PlantillaEnunciado plantillaEnunciado = peService.getPlantillaEnunciado(tema, contexto, incognita);

        DatosEjercicio datosEjercicio = switch (nombreTema) {

                case "MRU" ->{
                    GeneradorValoresMRU generadorValoresMRU = new GeneradorValoresMRU(incognita, dificultad, contexto);
                    yield generadorValoresMRU.generarValores();
                }
            
                default ->null;
            };

        
        EnunciadoFisica enunciado = new EnunciadoFisica(plantillaEnunciado, datosEjercicio);
        EjercicioFisica ejercicio = new EjercicioFisica(enunciado, contexto, datosEjercicio, tema, incognita);
        return ejercicio;
    }
}
