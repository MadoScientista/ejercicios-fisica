package com.generador_ejercicio.ejercicios_fisica.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generador_ejercicio.ejercicios_fisica.dto.RespuestaEjercicioDTO;
import com.generador_ejercicio.ejercicios_fisica.model.Dato;
import com.generador_ejercicio.ejercicios_fisica.model.EjercicioFisica;

public class EjercicioMapper {

    public EjercicioMapper(){

    }


    public RespuestaEjercicioDTO build(EjercicioFisica ejercicio, String dificultad){
        List<Map<String, Object>> datos = new ArrayList<>();

        String textoFinal = ejercicio.getEnunciado().getPlantilla().getEnunciado();


        for(Dato dato : ejercicio.getDatosEjercicio().getDatos()){
            String placeHolder = "{" + dato.getVariable().getSimbolo() + "}";
            String datoConUnidad = String.format("%.2f %s", dato.getValor(), dato.getUnidadDeMedida().getSimbolo());
            
            textoFinal = textoFinal.replace(placeHolder, datoConUnidad);
            
            datos.add(
                Map.of(
                    "Variable", dato.getVariable().getNombre(),
                    "Símbolo", dato.getVariable().getSimbolo(),
                    "Valor", dato.getValor(),
                    "Unidad_de_medida", dato.getUnidadDeMedida().getSimbolo())
            );
        }

        RespuestaEjercicioDTO respuesta = new RespuestaEjercicioDTO(
            textoFinal,
            ejercicio.getTemaFisica().getNombre(),
            ejercicio.getContexto().getNombre(),
            ejercicio.getIncognita().getNombre(),
            dificultad,
            ejercicio.getEnunciado().getPlantilla().getEnunciado(),
            datos
        );

        return respuesta;
    }
}
