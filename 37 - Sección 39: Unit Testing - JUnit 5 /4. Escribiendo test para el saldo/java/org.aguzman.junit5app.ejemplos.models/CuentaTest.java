package org.aguzman.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest{

    @Test // Indica que este método es una prueba JUnit
    void testReferenciaCuenta() { // Define el método de prueba para la comparación por referencia
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997")); // Crea una instancia de Cuenta
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997")); // Crea otra instancia de Cuenta con los mismos datos

        assertNotEquals(cuenta2, cuenta); // Asegura que las dos instancias NO son iguales (por referencia)
    }        

    @Test // Indica que este método es una prueba JUnit
        void testReferenciaCuenta() { // Define el método de prueba (mismo nombre, pero diferente intención)
            // Crea una instancia de Cuenta
            Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997")); 

            // Crea otra instancia de Cuenta con datos similares
            Cuenta cuenta2 = new Cuenta("John Roe", new BigDecimal("8900.9997")); 

            // Asegura que las dos instancias SON iguales (se espera que falle inicialmente)
            assertEquals(cuenta2, cuenta); 
    }

}