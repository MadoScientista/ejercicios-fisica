package com.generador_ejercicio.ejercicios_fisica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generador_ejercicio.ejercicios_fisica.dto.RespuestaPlantillaEnunciadoDTO;
import com.generador_ejercicio.ejercicios_fisica.mapper.PlantillaEnunciadoMapper;
import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.service.PlantillaEnunciadoService;

@RestController
@RequestMapping("api/v1/plantillas")
public class PlantillaEnunciadoController {

    @Autowired
    PlantillaEnunciadoService service;

    @Autowired
    PlantillaEnunciadoMapper mapper;

    //-------------------------------------------------------------
    //-------------- SECCIÓN GET EJERCICIOS -----------------------
    //-------------------------------------------------------------

    @GetMapping
    public ResponseEntity<?> getPlantillas(){
        List<PlantillaEnunciado> plantillas = service.getPlantillas();
        List<RespuestaPlantillaEnunciadoDTO> respuesta = new ArrayList<>();
        
        if(plantillas != null){
            for(PlantillaEnunciado p : plantillas){
                respuesta.add(mapper.build(p));
            }
            return ResponseEntity.ok(respuesta);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron plantillas");
    }
}
