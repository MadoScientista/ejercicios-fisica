package com.generador_ejercicio.ejercicios_fisica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.PlantillaEnunciado;

public interface PlantillaEnunciadoRepository extends JpaRepository<PlantillaEnunciado, Long> {

    PlantillaEnunciado findByTema_nombreAndContexto_nombreAndIncognita_nombre(
        String nombreTema,
        String nombreContexto,
        String nombreIncognita
    );
}
