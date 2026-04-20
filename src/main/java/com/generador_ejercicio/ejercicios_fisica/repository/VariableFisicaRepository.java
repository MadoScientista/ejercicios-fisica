package com.generador_ejercicio.ejercicios_fisica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;


public interface VariableFisicaRepository  extends JpaRepository<VariableFisica, Integer>{

    public VariableFisica findBySimbolo(String simbolo);
}
