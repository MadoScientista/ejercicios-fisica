package com.generador_ejercicio.ejercicios_fisica.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "magnitud_fisica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagnitudFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMagnitudFisica;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String simbolo;

    // Agrega columna para unidad SI base
    @ManyToOne
    @JoinColumn(name = "idUnidadSI", nullable = false)
    private UnidadDeMedida unidadSI;

    // Relaciones con VariableFisica y UnidadDeMedida
    @OneToMany(mappedBy = "magnitudFisica")
    private List<VariableFisica> variablesFisicas;

    @OneToMany(mappedBy = "magnitudFisica")
    private List<UnidadDeMedida> unidadesDeMedida;

    @OneToMany(mappedBy = "magnitudFisica")
    private List<PlantillaEnunciado> plantillaEnunciado;

    
}
