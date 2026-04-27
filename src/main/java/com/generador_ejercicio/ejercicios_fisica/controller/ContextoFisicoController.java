package com.generador_ejercicio.ejercicios_fisica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generador_ejercicio.ejercicios_fisica.dto.contextoFisicoDTO.ResponseContextoFisicoDTO;
import com.generador_ejercicio.ejercicios_fisica.mapper.ContextoFisicoMapper;
import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.service.ContextoFisicoService;

@RestController
@RequestMapping("api/v1/contextos-fisicos")
public class ContextoFisicoController {

    @Autowired
    private ContextoFisicoService service;

    @Autowired
    private ContextoFisicoMapper mapper;
    
    //-------------------------------------------------------------
    //------------------------- SECCIÓN GET -----------------------
    //-------------------------------------------------------------

    @GetMapping
    public ResponseEntity<?> getContextos(){
        List<ContextoFisico> contextos = service.getContextos();

        if(contextos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay contextos disponibles");
        }

        List<ResponseContextoFisicoDTO> response = contextos.stream().map(c -> mapper.build(c)).toList();

        return ResponseEntity.ok(response);
        
    }
}
