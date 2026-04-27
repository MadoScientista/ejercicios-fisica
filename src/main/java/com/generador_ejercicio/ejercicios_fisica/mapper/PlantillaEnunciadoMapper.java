package com.generador_ejercicio.ejercicios_fisica.mapper;

import org.springframework.stereotype.Component;

import com.generador_ejercicio.ejercicios_fisica.dto.RespuestaPlantillaEnunciadoDTO;
import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class PlantillaEnunciadoMapper {

    public RespuestaPlantillaEnunciadoDTO build(PlantillaEnunciado p){
        return(
            new RespuestaPlantillaEnunciadoDTO(
                p.getIdPlantillaEnunciado(),
                p.getTema().getNombre(),
                p.getContexto().getNombre(),
                p.getIncognita().getNombre(),
                p.isResultadoPositivo()?"Positivo":"Negativo",
                p.getEnunciado())
        );
    }
}
