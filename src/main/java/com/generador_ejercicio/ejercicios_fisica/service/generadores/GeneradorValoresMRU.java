package com.generador_ejercicio.ejercicios_fisica.service.generadores;

import java.util.Random;

import com.generador_ejercicio.ejercicios_fisica.model.DatosEjercicio;
import com.generador_ejercicio.ejercicios_fisica.model.Dato;
import com.generador_ejercicio.ejercicios_fisica.model.ContextoFisico;
import com.generador_ejercicio.ejercicios_fisica.model.UnidadDeMedida;
import com.generador_ejercicio.ejercicios_fisica.service.UnidadDeMedidaService;
import com.generador_ejercicio.ejercicios_fisica.service.VariableFisicaService;
import com.generador_ejercicio.ejercicios_fisica.utilidades.UtilidadVariables;


public class GeneradorValoresMRU {

    private boolean variablesValidas;

    // Prueba para conversión de unidades
    
    private UnidadDeMedida km;
    private UnidadDeMedida kmh;
    private UnidadDeMedida m;
    private UnidadDeMedida ms;
    private UnidadDeMedida s;
    
    private UnidadDeMedidaService umService;
    private VariableFisicaService vfService;
    
    private static final Random random = new Random();

    public GeneradorValoresMRU(UnidadDeMedidaService umService, VariableFisicaService vfService){
        
        this.vfService = vfService;
        this.umService = umService;

        km = umService.getBySimbolo("km");
        kmh = umService.getBySimbolo("km/h");
        m = umService.getBySimbolo("m");
        ms = umService.getBySimbolo("m/s");
        s = umService.getBySimbolo("s");
        
    }


    // Genera un objeto DatosEjercicio con variables x, x0, v y t
    // con valores seguún contexto y dificultad
    public DatosEjercicio generarValores(String nombreIncognita, String nombreDificultad, ContextoFisico contexto, boolean resultadoPositivo){


        // Crea datos con unidad de medida y asignación de tipo de variable
        // Por ahora se asigna manualmente la unidad base del SI
        Dato x = new Dato();
        x.setUnidadDeMedida(m);
        x.setVariable(vfService.getBySimbolo("x"));
        
        Dato x0 = new Dato();
        x0.setUnidadDeMedida(m);
        x0.setVariable(vfService.getBySimbolo("x0"));

        Dato v = new Dato();
        v.setUnidadDeMedida(ms);
        v.setVariable(vfService.getBySimbolo("v"));

        Dato t = new Dato();
        t.setUnidadDeMedida(s);
        t.setVariable(vfService.getBySimbolo("t"));


        // Declara el objeto a retornar
        DatosEjercicio datosCalculados;

        // Modifica las variables dependiendo de la incógnita a calcular
        datosCalculados = switch(nombreIncognita){
            case "POSICION_INICIAL" -> calcularX0(x, x0, v, t, contexto, nombreDificultad, resultadoPositivo);
            case "POSICION" -> calcularX(x, x0, v, t, contexto, nombreDificultad, resultadoPositivo);
            case "VELOCIDAD" -> calcularV(x, x0, v, t, contexto, nombreDificultad, resultadoPositivo);
            case "TIEMPO" -> calcularT(x, x0, v, t, contexto, nombreDificultad, resultadoPositivo);
            default -> new DatosEjercicio();
        };

        // Agrega los datos calculados el tipo de variable física incógnita
        datosCalculados.setIncognita(vfService.getBySimbolo(nombreIncognita));
        return datosCalculados;
    }


    // Genera un objeto Datos ejercicios y agrega los datos x, x0, v y t
    private DatosEjercicio build(Dato x, Dato x0, Dato v, Dato t){
        DatosEjercicio datos = new DatosEjercicio();
        datos.agregarDato(x);
        datos.agregarDato(x0);
        datos.agregarDato(v);
        datos.agregarDato(t);
        
        return datos;
    }

    //-----------------------------------------------------------------------------------------------------
    //--------------------------------| CALCULAR POSICIÓN INICIAL X0 |-------------------------------------
    //
    // Realiza cálculos con x0 como incógnita
    //
    //-----------------------------------------------------------------------------------------------------

    private DatosEjercicio calcularX0(Dato x, Dato x0, Dato v, Dato t, ContextoFisico contexto, String nombreDificultad, boolean resultadoPositivo){
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

        return build(x, x0, v, t);

    }

    //-----------------------------------------------------------------------------------------------------
    //--------------------------------| CALCULAR POSICIÓN FINAL X |----------------------------------------
    //-----------------------------------------------------------------------------------------------------
  
    private DatosEjercicio calcularX(Dato x, Dato x0, Dato v, Dato t, ContextoFisico contexto, String nombreDificultad, boolean resultadoPositivo){
        // x = x0 + v*t

        t.setValor(2 + random.nextInt(240));

        boolean variablesValidas = true;
        boolean xValido = true;
        boolean x0Valido = true;
        boolean vValido = true;

        do{

            if(nombreDificultad.equals("ELEMENTAL") || nombreDificultad.equals("INTERMEDIO")){
                v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), resultadoPositivo);
                x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
            }

            if(nombreDificultad.equals("AVANZADO") ){
                if(random.nextBoolean()){
                    v = UtilidadVariables.randomInt(v, contexto.getVMin(), contexto.getVMax(), resultadoPositivo);
                    x0 = UtilidadVariables.randomDouble(x0, contexto.getXMin(), contexto.getXMax(), true, 2);
                }else{
                    x0 = UtilidadVariables.randomInt(x0, contexto.getXMin(), contexto.getXMax(),  true);
                    v = UtilidadVariables.randomDouble(v, contexto.getVMin(), contexto.getVMax(),  resultadoPositivo, 2);
                }
            }

            x.setValor(x0.getValor() + v.getValor()*t.getValor());

            if(nombreDificultad.equals("INTERMEDIO") || nombreDificultad.equals("AVANZADO")){
                if(random.nextBoolean()){
                    v = UtilidadVariables.convertirUnidad(v, kmh);
                }else{
                    x0 = UtilidadVariables.convertirUnidad(x0, km);  
                }
            }

            vValido = UtilidadVariables.comprobarDecimales(v, 2) && v.getValor() != 0;
            x0Valido = UtilidadVariables.comprobarDecimales(x0, 3);

            xValido = x.getValor() != 0 && x.getValor() != t.getValor();

            if(resultadoPositivo){
                xValido = xValido && x.getValor() > 0;
            }else{
                xValido = xValido && x.getValor() < 0;
            }
            
            
            x0Valido = x0Valido && x0.getValor() != 0;

            variablesValidas = xValido && x0Valido && vValido;

        }while(!variablesValidas);


        return build(x, x0, v, t);
    }

    //-----------------------------------------------------------------------------------------------------
    //-------------------------------------| CALCULAR VELOCIDAD V |----------------------------------------
    //-----------------------------------------------------------------------------------------------------

    private DatosEjercicio calcularV(Dato x, Dato x0, Dato v, Dato t, ContextoFisico contexto, String nombreDificultad, boolean resultadoPositivo){
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
        return build(x, x0, v, t);
    }

    //-----------------------------------------------------------------------------------------------------
    //-------------------------------------| CALCULAR TIEMPO T |-------------------------------------------
    //-----------------------------------------------------------------------------------------------------

    private DatosEjercicio calcularT(Dato x, Dato x0, Dato v, Dato t, ContextoFisico contexto, String nombreDificultad, boolean resultadoPositivo){

        return build(x, x0, v, t);
    }
}
