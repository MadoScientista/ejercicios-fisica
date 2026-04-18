package com.generador_ejercicio.ejercicios_fisica.utilidades;

import java.util.Random;

import com.generador_ejercicio.ejercicios_fisica.model.Dato;
import com.generador_ejercicio.ejercicios_fisica.model.UnidadDeMedida;

public class UtilidadVariables {

    private static Random random = new Random();

    public UtilidadVariables(){

    }

    public static Dato convertirUnidad(Dato dato, UnidadDeMedida uSalida){        
        
        return new Dato(
            dato.getVariable(),
            dato.getValor() * dato.getUnidadDeMedida().getFactorConversionSI() / uSalida.getFactorConversionSI(),
            uSalida
        );
    }

    public static Dato randomInt(Dato dato, int min, int max, boolean positivo){
        Dato nuevaDato = new Dato();

        int numeroRandom = random.nextInt((max - min + 1)) + min;
        nuevaDato.setValor(numeroRandom);

        nuevaDato.setValor((positivo) ? nuevaDato.getValor(): nuevaDato.getValor()*-1);
        nuevaDato.setUnidadDeMedida(dato.getUnidadDeMedida());
        

        return nuevaDato;   
    }

    public static Dato randomDouble(Dato variable, int min, int max, boolean positivo, int nDecimales){
        Dato nuevaVariable = new Dato();

        double numeroRandom = random.nextDouble(((max - min) + min+1));
        double decimalRandom = Math.round(numeroRandom*Math.pow(10, nDecimales))/Math.pow(10, nDecimales);

        nuevaVariable.setValor(decimalRandom);
        
        nuevaVariable.setUnidadDeMedida(variable.getUnidadDeMedida());
        nuevaVariable.setValor((positivo) ? nuevaVariable.getValor(): nuevaVariable.getValor()*-1);

        return nuevaVariable;   
    }

    public static boolean comprobarDecimales(Dato variable, int nDecimales){

        double n = variable.getValor()*Math.pow(10, nDecimales);
        double n_ceil = Math.ceil(variable.getValor()*Math.pow(10, nDecimales));
        boolean correcto = (n_ceil - n) == 0;

        return correcto;
    }
}
