package com.generador_ejercicio.ejercicios_fisica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.MagnitudFisica;

public interface MagnitudFisicaRepository extends JpaRepository<MagnitudFisica, Integer> {

    MagnitudFisica findByIdMagnitudFisica(int id);

    List<MagnitudFisica> findAllByOrderByIdMagnitudFisicaAsc();
}
