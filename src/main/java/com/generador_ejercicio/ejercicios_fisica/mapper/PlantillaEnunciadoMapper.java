package com.generador_ejercicio.ejercicios_fisica.mapper;

import org.springframework.stereotype.Component;

import com.generador_ejercicio.ejercicios_fisica.dto.plantillaEnunciadoDTO.ResponsePlantillaEnunciadoDTO;
import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PlantillaEnunciadoMapper {

    public ResponsePlantillaEnunciadoDTO build(PlantillaEnunciado p){
        return(
            new ResponsePlantillaEnunciadoDTO(
                p.getIdPlantillaEnunciado(),
                p.getTema().getNombre(),
                p.getContexto().getNombre(),
                p.getIncognita().getNombre(),
                p.isResultadoPositivo()?"Positivo":"Negativo",
                p.getEnunciado())
        );
    }
}
