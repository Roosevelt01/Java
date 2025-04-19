package org.aguzman.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest{
    
    
    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        String esperado = "Andres";
        String real = cuenta.getPersona();
        assertNotNull(real);//Paso 5
        assertEquals(esperado, real);
        assertTrue(real.equals("Andres"));
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());//Paso 4
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    void TestReferenciaCuenta(){
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        assertEquals(cuenta2, cuenta2);
    }

    @Test // Indica que este método es una prueba JUnit
    void testDebitoCuenta() { // Prueba para verificar la operación de débito
        // Paso 1: Configuración (Arrange) - Crear el objeto de prueba con un saldo inicial
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));

        // Paso 2: Acción (Act) - Realizar la operación que queremos probar
        cuenta.debito(new BigDecimal(100)); // Debitamos 100

        // Paso 3: Aserción (Assert) - Verificar el resultado

        // Asegura que el saldo no es nulo después del débito
        assertNotNull(cuenta.getSaldo()); 
        // Verifica que la parte entera del saldo sea 900
        assertEquals(900, cuenta.getSaldo().intValue());
        // Verifica el valor exacto del saldo como String
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test // Indica que este método es una prueba JUnit
    void testCreditoCuenta() { // Prueba para verificar la operación de crédito
        // Paso 1: Configuración (Arrange) - Crear el objeto de prueba con un saldo inicial
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));

        // Paso 2: Acción (Act) - Realizar la operación que queremos probar
        cuenta.credito(new BigDecimal(100)); // Acreditamos 100

        // Paso 3: Aserción (Assert) - Verificar el resultado

        // Asegura que el saldo no es nulo después del crédito
        assertNotNull(cuenta.getSaldo()); 
        // Verifica que la parte entera del saldo sea 1100
        assertEquals(1100, cuenta.getSaldo().intValue()); 
        // Verifica el valor exacto del saldo como String
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString()); 
    }
    
}