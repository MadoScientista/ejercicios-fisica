package com.generador_ejercicio.ejercicios_fisica.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.generador_ejercicio.ejercicios_fisica.dto.ejercicioDTO.ResponseEjercicioDTO;
import com.generador_ejercicio.ejercicios_fisica.model.Dato;
import com.generador_ejercicio.ejercicios_fisica.model.EjercicioFisica;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EjercicioMapper {


    public ResponseEjercicioDTO build(EjercicioFisica ejercicio){
        List<Map<String, Object>> datos = new ArrayList<>();

        String enunciado = ejercicio.getEnunciado().getPlantilla().getEnunciado();
        long idEnunciado = ejercicio.getEnunciado().getPlantilla().getIdPlantillaEnunciado();


        for(Dato dato : ejercicio.getDatosEjercicio().getDatos()){
            String placeHolder = "{" + dato.getVariable().getSimbolo() + "}";
            String datoConUnidad = String.format("%.2f %s", dato.getValor(), dato.getUnidadDeMedida().getSimbolo());
            
            enunciado = enunciado.replace(placeHolder, datoConUnidad);
            
            datos.add(
                Map.of(
                    "Variable", dato.getVariable().getNombre(),
                    "Símbolo", dato.getVariable().getSimbolo(),
                    "Valor", dato.getValor(),
                    "Unidad_de_medida", dato.getUnidadDeMedida().getSimbolo())
            );
        }

        ResponseEjercicioDTO respuesta = new ResponseEjercicioDTO(
            ejercicio.getTemaFisica().getNombre(),
            ejercicio.getContexto().getNombre(),
            ejercicio.getIncognita().getNombre(),
            ejercicio.getDificultad().getNombre(),
            idEnunciado,
            enunciado,
            datos
        );

        return respuesta;
    }
}
