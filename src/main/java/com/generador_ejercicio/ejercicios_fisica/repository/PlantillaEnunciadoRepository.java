package com.generador_ejercicio.ejercicios_fisica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;

public interface PlantillaEnunciadoRepository extends JpaRepository<PlantillaEnunciado, Long> {

    List<PlantillaEnunciado> findByTema_nombreAndContexto_nombreAndIncognita_nombreAndResultadoPositivo(
        String nombreTema,
        String nombreContexto,
        String nombreIncognita,
        boolean resultadoPositivo
    );

    List<PlantillaEnunciado> findAllByOrderByIdPlantillaEnunciadoAsc();
}
