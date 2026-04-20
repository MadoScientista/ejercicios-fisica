package com.generador_ejercicio.ejercicios_fisica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;
import com.generador_ejercicio.ejercicios_fisica.repository.VariableFisicaRepository;

@Service
public class VariableFisicaService {

    @Autowired
    private VariableFisicaRepository repo;

    public VariableFisica getBySimbolo(String simbolo){
        return repo.findBySimbolo(simbolo);
    }
}
