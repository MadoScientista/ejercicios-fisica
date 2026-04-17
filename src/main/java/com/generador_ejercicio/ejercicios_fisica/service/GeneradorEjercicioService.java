package com.generador_ejercicio.ejercicios_fisica.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.DatosEjercicio;
import com.generador_ejercicio.ejercicios_fisica.model.EjercicioFisica;
import com.generador_ejercicio.ejercicios_fisica.model.EnunciadoFisica;
import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.model.enums.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.enums.Dificultad;
import com.generador_ejercicio.ejercicios_fisica.model.enums.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.enums.TemaFisica;
import com.generador_ejercicio.ejercicios_fisica.service.generadores.GeneradorValoresMRU;

@Service
public class GeneradorEjercicioService {

    @Autowired
    private PlantillaEnunciadoService peService;

    private EjercicioFisica ejercicio;
    private EnunciadoFisica enunciado;
    private PlantillaEnunciado plantillaEnunciado;
    private ContextoFisico  contexto;
    private TemaFisica      tema;
    private DatosEjercicio  datosEjercicio;
    private MagnitudFisica  incognita;
    private Dificultad      dificultad;


    public GeneradorEjercicioService(TemaFisica tema, ContextoFisico contexto, MagnitudFisica incognita, Dificultad dificultad){
        this.tema = tema;
        this.contexto = contexto;
        this.incognita = incognita;

        datosEjercicio = new DatosEjercicio(); 
        ejercicio = getEjercicio();

    }

    public EjercicioFisica getEjercicio(){
        
        plantillaEnunciado = peService.getPlantillaEnunciado(tema, contexto, incognita);

        datosEjercicio = switch (tema) {

                case MRU ->{
                    GeneradorValoresMRU generadorValoresMRU = new GeneradorValoresMRU(incognita, dificultad, contexto);
                    yield generadorValoresMRU.generarValores();
                }
            
                default ->null;
            };

        
        enunciado = new EnunciadoFisica(plantillaEnunciado, datosEjercicio);
        ejercicio = new EjercicioFisica(enunciado, contexto, datosEjercicio, tema, incognita);
        return ejercicio;
    }
}
