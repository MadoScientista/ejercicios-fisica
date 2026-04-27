package com.generador_ejercicio.ejercicios_fisica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;

public interface ContextoFisicoRepository extends JpaRepository<ContextoFisico, Integer> {

    List<ContextoFisico> findByNombre(String nombre);
    List<ContextoFisico> findAllByOrderByIdContextoFisicoAsc();

    ContextoFisico findByIdContextoFisico(int id);
}
