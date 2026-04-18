package com.generador_ejercicio.ejercicios_fisica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plantilla_enunciado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantillaEnunciado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlantillaEnunciado;

    @Column(nullable = false)
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "id_tema", nullable = false)
    private TemaFisica tema;

    @ManyToOne
    @JoinColumn(name = "id_contexto", nullable = false)
    private ContextoFisico contexto;

    @ManyToOne
    @JoinColumn(name = "id_incognita", nullable = false)
    private VariableFisica incognita;

    @ManyToOne
    @JoinColumn(name = "id_magnitud_fisica", nullable = false)
    private MagnitudFisica magnitudFisica;

}
