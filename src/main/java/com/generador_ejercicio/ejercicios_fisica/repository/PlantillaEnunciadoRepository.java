package com.generador_ejercicio.ejercicios_fisica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;
import com.generador_ejercicio.ejercicios_fisica.model.TemaFisica;
import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;

public interface PlantillaEnunciadoRepository extends JpaRepository<PlantillaEnunciado, Long> {
    PlantillaEnunciado getPlantillaEnunciado(TemaFisica tema, ContextoFisico contexto, VariableFisica incognita);
}
