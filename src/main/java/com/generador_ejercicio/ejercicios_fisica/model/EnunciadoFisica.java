package com.generador_ejercicio.ejercicios_fisica.model;

import java.util.List;
import java.util.Map;

import com.generador_ejercicio.ejercicios_fisica.model.enums.TemaFisica;
import com.generador_ejercicio.ejercicios_fisica.model.enums.VariableFisica;

public class EnunciadoFisica {
    private TemaFisica temaFisica;
    private String plantilla;
    private List<VariableFisica> variablesNecesarias;
    private Map<VariableFisica, Long> variables;
}
