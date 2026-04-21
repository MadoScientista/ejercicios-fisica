package com.generador_ejercicio.ejercicios_fisica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.UnidadDeMedida;
import com.generador_ejercicio.ejercicios_fisica.repository.UnidadDeMedidaRepository;

@Service
public class UnidadDeMedidaService {

    @Autowired
    private UnidadDeMedidaRepository repo;
    
    public UnidadDeMedida getBySimbolo(String simbolo){
        return repo.findBySimbolo(simbolo);
    }

    public UnidadDeMedida getUnidadBaseSI(MagnitudFisica magnitudFisica){
        return repo.findByMagnitudFisicaAndEsBaseSITrue(magnitudFisica);
    }

    public UnidadDeMedida getUnidadBaseSI(String nombreMagnitudFisica){
        return repo.findByMagnitudFisicaNombreAndEsBaseSITrue(nombreMagnitudFisica);
    }
}
