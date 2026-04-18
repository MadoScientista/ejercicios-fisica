package com.generador_ejercicio.ejercicios_fisica.service.generadores;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generador_ejercicio.ejercicios_fisica.model.DatosEjercicio;
import com.generador_ejercicio.ejercicios_fisica.model.Dato;
import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.Dificultad;
import com.generador_ejercicio.ejercicios_fisica.model.MagnitudFisica;
import com.generador_ejercicio.ejercicios_fisica.model.UnidadDeMedida;
import com.generador_ejercicio.ejercicios_fisica.model.VariableFisica;
import com.generador_ejercicio.ejercicios_fisica.service.UnidadDeMedidaService;
import com.generador_ejercicio.ejercicios_fisica.utilidades.UtilidadVariables;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Service
public class GeneradorValoresMRU {

    private VariableFisica incognita;
    private Dificultad dificultad;
    private String nombreDificultad;
    private ContextoFisico contexto;
    private DatosEjercicio variablesCalculadas;
    private Dato x = new Dato();
    private Dato x0 = new Dato();
    private Dato t = new Dato();
    private Dato v = new Dato();
    private boolean variablesValidas;

    // Prueba para conversión de unidades
    
    private UnidadDeMedida km;
    private UnidadDeMedida kmh;

    @Autowired
    UnidadDeMedidaService unidadDeMedidaService;
    
    private static final Random random = new Random();

    public GeneradorValoresMRU(VariableFisica incognita, Dificultad dificultad, ContextoFisico contexto){
        this.incognita = incognita;
        this.dificultad = dificultad;
        this.contexto = contexto; 

        km = unidadDeMedidaService.getBySimbolo("km");
        kmh = unidadDeMedidaService.getBySimbolo("km/h");
        nombreDificultad = dificultad.getNombre().toUpperCase();

        variablesCalculadas = new DatosEjercicio();
        variablesCalculadas.setIncognita(incognita);
    }

    public DatosEjercicio generarValores(){
        String nombreIncognita = incognita.getNombre().toUpperCase();

        return switch(nombreIncognita){
            case "POSICION_INICIAL" -> calcularX0();
            case "POSICION" -> calcularX();
            case "VELOCIDAD" -> calcularV();
            case "TIEMPO" -> calcularT();
            default -> build();
        };
    }

    public DatosEjercicio build(){
        variablesCalculadas.agregarDato(x);
        variablesCalculadas.agregarDato(x0);
        variablesCalculadas.agregarDato(v);
        variablesCalculadas.agregarDato(t);
        
        return variablesCalculadas;
    }

    //-----------------------------------------------------------------------------------------------------
    //--------------------------------| CALCULAR POSICIÓN INICIAL X0 |-------------------------------------
    //-----------------------------------------------------------------------------------------------------

    private DatosEjercicio calcularX0(){
        // x0 = x - v*t

        // ELEMENTAL
        t.setValor(2 + random.nextInt(10));

        switch (nombreDificultad){
            case "ELEMENTAL_POSITIVO" ->{
                do{
                    v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), true);
                    x = UtilidadVariables.randomInt(x, contexto.getXMin(), contexto.getXMax(),  true);
                    x0.setValor(x.getValor() - v.getValor()*t.getValor());
                }while(x0.getValor() <= 0 || x.getValor() == t.getValor());
            }

            case "ELEMENTAL_NEGATIVO" -> {    
                do{
                    v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), true);
                    x = UtilidadVariables.randomInt(x, contexto.getXMin(), contexto.getXMax(),  true);
                    x0.setValor(x.getValor() - t.getValor() * v.getValor());
                }while(x0.getValor() > 0 || x.getValor() == t.getValor());
            }

            default -> {v.setValor(0); x.setValor(0); x0.setValor(0);}
        }

        return build();

    }

    //-----------------------------------------------------------------------------------------------------
    //--------------------------------| CALCULAR POSICIÓN FINAL X |----------------------------------------
    //-----------------------------------------------------------------------------------------------------
  
    private DatosEjercicio calcularX(){
        // x = x0 + v*t

        t.setValor(2 + random.nextInt(60));

        switch (nombreDificultad){
            case "ELEMENTAL_POSITIVO", "ELEMENTAL_NEGATIVO" ->{
                do{

                    t.setValor(2 + random.nextInt(60));
                    boolean casoPositivo = nombreDificultad.equals("ELEMENTAL_POSITIVO");

                    v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), casoPositivo);
                    x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
                    x.setValor(x0.getValor() + v.getValor()*t.getValor());

                    if(casoPositivo){
                        variablesValidas = x.getValor() > 0 && x.getValor() != t.getValor();
                    }else{
                        variablesValidas = x.getValor() < 0 && x.getValor() != t.getValor();
                        System.out.println("No valido");
                    }

                }while(!variablesValidas);
            }


            case "INTERMEDIO_POSITIVO" -> {
                t.setValor(t.getValor()*5);

                do{
                    v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), true);
                    x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
                    x.setValor(x0.getValor() + v.getValor()*t.getValor());
                }while(x.getValor() == 0 || x.getValor() == t.getValor() || x0.getValor() == 0);

                if(random.nextBoolean()){
                    v = UtilidadVariables.convertirUnidad(v, kmh);
                }else{
                    x0 = UtilidadVariables.convertirUnidad(x0, km);  
                }
            }

            case "INTERMEDIO_NEGATIVO" -> {
                t.setValor(t.getValor()*5);

                do{
                    v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), false);
                    x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
                    x.setValor(x0.getValor() + v.getValor()*t.getValor());
                }while(x.getValor() == 0 || x.getValor() == t.getValor() || x0.getValor() == 0);

                if(random.nextBoolean()){
                    v = UtilidadVariables.convertirUnidad(v, kmh);
                }else{
                    x0 = UtilidadVariables.convertirUnidad(x0, km);  
                }
            }

            case "AVANZADO_POSITIVO" ->{

                boolean valido;
                boolean xValido = true;
                boolean x0valido = true;
                boolean vValido = true;
                
                do{
                    if(random.nextBoolean()){
                        v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), true);
                        x0 = UtilidadVariables.randomDouble(x0, contexto.getXMin(), contexto.getXMax(), true, 2);
                    }else{
                        x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
                        v = UtilidadVariables.randomDouble(v, contexto.getVMin(), contexto.getVMax(),  true, 2);
                    }
                   
                    x.setValor(x0.getValor() + v.getValor()*t.getValor());

                    xValido = UtilidadVariables.comprobarDecimales(x, 3);

                    if(random.nextBoolean()){
                        v = UtilidadVariables.convertirUnidad(v, kmh);
                    }else{
                        x0 = UtilidadVariables.convertirUnidad(x0, km);  
                    }

                    vValido = UtilidadVariables.comprobarDecimales(v, 2) && v.getValor() != 0;
                    x0valido = UtilidadVariables.comprobarDecimales(x0, 3);
                    valido = xValido && x0valido && vValido;

                }while(x.getValor() == 0 || x.getValor() == t.getValor() || x0.getValor() == 0 || !valido);
            }

            case "AVANZADO_NEGATIVO" ->{

                boolean valido;
                boolean xValido = true;
                boolean x0valido = true;
                boolean vValido = true;
                
                do{
                    if(random.nextBoolean()){
                        v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), true);
                        x0 = UtilidadVariables.randomDouble(x0, contexto.getXMin(), contexto.getXMax(), false, 2);
                    }else{
                        x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
                        v = UtilidadVariables.randomDouble(v, contexto.getVMin(), contexto.getVMax(),  false, 2);
                    }
                   
                    x.setValor(x0.getValor() + v.getValor()*t.getValor());

                    xValido = UtilidadVariables.comprobarDecimales(x, 3);

                    if(random.nextBoolean()){
                        v = UtilidadVariables.convertirUnidad(v, kmh);
                    }else{
                        x0 = UtilidadVariables.convertirUnidad(x0, km);  
                    }

                    vValido = UtilidadVariables.comprobarDecimales(v, 2) && v.getValor() != 0;
                    x0valido = UtilidadVariables.comprobarDecimales(x0, 3);
                    valido = xValido && x0valido && vValido && x.getValor()<0;

                }while(x.getValor() == 0 || x.getValor() == t.getValor() || x0.getValor() == 0 || !valido);
            }

            default -> {v.setValor(0); x.setValor(0); x0.setValor(0);}
        }

        return build();
    }

    //-----------------------------------------------------------------------------------------------------
    //-------------------------------------| CALCULAR VELOCIDAD V |----------------------------------------
    //-----------------------------------------------------------------------------------------------------

    private DatosEjercicio calcularV(){
        // v = (x-x0)/t

        switch(nombreDificultad){
            case "ELEMENTAL_POSITIVO", "ELEMENTAL_NEGATIVO" ->{
                boolean casoPositivo = nombreDificultad.equals("ELEMENTAL_POSITIVO");

                do{
                    t.setValor(random.nextInt(20));
                    x = UtilidadVariables.randomInt(x, contexto.getXMin(), contexto.getXMax(), casoPositivo);
                    x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(), true);
                    v.setValor((x.getValor() - x0.getValor())/t.getValor());

                    if(casoPositivo){
                        variablesValidas = v.getValor() > 0 && UtilidadVariables.comprobarDecimales(v, 0); 
                    }else{
                        variablesValidas = v.getValor() < 0;
                    }

                }while(!variablesValidas);
            }

            case "INTERMEDIO_POSITIVO" -> {

            }

            case "INTERMEDIO_NEGATIVO" -> {

            }
        }
        return build();
    }

    //-----------------------------------------------------------------------------------------------------
    //-------------------------------------| CALCULAR TIEMPO T |-------------------------------------------
    //-----------------------------------------------------------------------------------------------------

    private DatosEjercicio calcularT(){

        return build();
    }
}
