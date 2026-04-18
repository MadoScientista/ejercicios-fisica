package com.generador_ejercicio.ejercicios_fisica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generador_ejercicio.ejercicios_fisica.service.EjercicioFisicaService;

@RestController
@RequestMapping("/api/generar-ejercicio")
public class GeneradorEjercicioController {

    @Autowired
    EjercicioFisicaService service;


    // ------------------------------------------------------------
    // --------------- GENERAR EJERCICIO MRU ----------------------
    // ------------------------------------------------------------

    // @GetMapping("mru")
    // public ResponseEntity<?> getEjercicioMRU(){
    //     if(service.getEjercicio() == null){
    //         return ResponseEntity.status(500).body("Error al generar el ejercicio");   
    //     }
    //     return ResponseEntity.ok(service.getEjercicio());
    // }
}
