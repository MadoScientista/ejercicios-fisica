package com.generador_ejercicio.ejercicios_fisica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;


public interface VariableFisicaRepository  extends JpaRepository<VariableFisica, Integer>{

    VariableFisica findBySimbolo(String simbolo);

    List<VariableFisica> findAllByOrderByIdVariableFisicaAsc();
}
