package org.aguzman.junit5app.ejemplos.models;

import org.aguzman.junit5app.ejemplos.exceptions.DineroInsuficienteException;
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
        assertNotNull(real);
        assertEquals(esperado, real);
        assertTrue(real.equals("Andres"));
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
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

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    // Paso 2 en la transcripción (se refiere a la creación del test): Prueba para manejar excepción de dinero insuficiente
    @Test
    void testDineroInsuficienteExceptionCeunta() { // Nombre del método de prueba

       // Paso 1: Configuración (Arrange) - Crear el objeto de prueba con saldo
       Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345")); // Saldo inicial

       // Paso 2: Acción & Aserción (Act & Assert) - Intentar la operación y afirmar la excepción
       // assertThrows espera 1) el tipo de excepción, 2) un lambda con el código que la lanza
       Exception exception = assertThrows(DineroInsuficienteException.class, ()->{
           // Código dentro del lambda: intenta debitar un monto mayor al saldo
           cuenta.debito((new BigDecimal(1500))); // Monto a debitar
       }); //assertThrows captura la excepción si se lanza y la retorna

       // Paso 3: Verificación Adicional (Assert) - Opcional, verificar el mensaje de la excepción
       String actualMensaje = exception.getMessage(); // Obtiene el mensaje de la excepción capturada
       String esperadoMensaje = "Dinero Insuficiente"; // Define el mensaje esperado
       // Nota en el código original: Se menciona la duda "Necesito saber que pasa si coloca 'Dinero Insuficiente en la cuenta'"
       // Esta línea verifica que el mensaje REAL sea igual al mensaje ESPERADO
       assertEquals(esperadoMensaje, actualMensaje); // Afirma que el mensaje real coincide con el esperado
    }
}