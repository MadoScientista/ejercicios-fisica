package com.generador_ejercicio.ejercicios_fisica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.repository.ContextoFisicoRepository;

@Service
public class ContextoFisicoService {

    @Autowired
    private ContextoFisicoRepository repo;



    //-------------------------------------------------------------
    //------------------------- SECCIÓN GET -----------------------
    //-------------------------------------------------------------
    
    public List<ContextoFisico> getContextos(){
        return repo.findAllByOrderByIdContextoFisicoAsc();
    }

    public ContextoFisico getContextoFisicoById(int id){
        return repo.findByIdContextoFisico(id);
    }
}
