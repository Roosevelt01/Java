package org.aguzman.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest{
    
    @Test // Indica que este método es una prueba JUnit
    void testReferenciaCuenta() { // Nombre descriptivo del método de prueba

        // Paso 1: Crear dos instancias de Cuenta con DATOS IDÉNTICOS
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        // Paso 2: Afirmar que las dos instancias NO son iguales
        // En este punto, la comparación por defecto es por referencia.
        // Como 'cuenta' y 'cuenta2' son dos objetos distintos en memoria,
        // se espera que no sean iguales por referencia.
        assertNotEquals(cuenta2, cuenta);
    }
   
}