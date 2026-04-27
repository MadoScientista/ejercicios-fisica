package com.generador_ejercicio.ejercicios_fisica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.UnidadDeMedida;

public interface UnidadDeMedidaRepository extends JpaRepository<UnidadDeMedida, Integer>{

    UnidadDeMedida findBySimbolo(String simbolo);

    UnidadDeMedida findByMagnitudFisicaAndEsBaseSITrue(MagnitudFisica magnitudFisica);

    UnidadDeMedida findByMagnitudFisicaNombreAndEsBaseSITrue(String nombreMagnitudFisica);
}
