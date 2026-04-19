package com.generador_ejercicio.ejercicios_fisica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generador_ejercicio.ejercicios_fisica.dto.RespuestaEjercicioDTO;
import com.generador_ejercicio.ejercicios_fisica.dto.SolicitudEjercicioDTO;
import com.generador_ejercicio.ejercicios_fisica.model.EjercicioFisica;
import com.generador_ejercicio.ejercicios_fisica.service.EjercicioFisicaService;

@RestController
@RequestMapping("/api/v1/generar-ejercicio")
public class GeneradorEjercicioController {

    @Autowired
    EjercicioFisicaService service;


    // ------------------------------------------------------------
    // --------------- GENERAR EJERCICIO MRU ----------------------
    // ------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> getEjercicioMRU(@RequestBody SolicitudEjercicioDTO request){

        EjercicioFisica ejercicio = service.getEjercicio(
            request.getTema(),
            request.getContexto(),
            request.getIncognita(),
            request.getDificultad()
        );

        if(ejercicio == null){
            return ResponseEntity.status(500).body("Error al generar el ejercicio");   
        }

        RespuestaEjercicioDTO respuesta = new RespuestaEjercicioDTO(
            ejercicio.getTemaFisica().getNombre(),
            ejercicio.getContexto().getNombre(),
            ejercicio.getIncognita().getNombre(),
            request.getDificultad(),
            ejercicio.getEnunciado().getPlantilla().getEnunciado(),
            ejercicio.getDatosEjercicio().getDatos()
        );
        return ResponseEntity.ok(respuesta);
    }
}
