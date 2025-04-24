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

    @Test
    void testDineroInsuficienteExceptionCeunta() {

       Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345")); 

      Exception exception = assertThrows(DineroInsuficienteException.class, ()->{
           cuenta.debito((new BigDecimal(1500))); 
       });

       String actualMensaje = exception.getMessage(); 
       String esperadoMensaje = "Dinero Insuficiente";
       assertEquals(esperadoMensaje, actualMensaje); 
    }

    // Prueba para el método transferir
    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuentaOrigen = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuentaDestino = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco del Estado"); // Asignar nombre al banco

        // Act: Realizar la transferencia (500 desde cuentaOrigen a cuentaDestino)
        banco.transferir(cuentaOrigen, cuentaDestino, new BigDecimal("500"));

        // Assert: Verificar saldos finales
        // Saldo esperado origen: 2500 - 500 = 2000
        assertEquals("2000", cuentaOrigen.getSaldo().toPlainString());
        // Saldo esperado destino: 1500.8989 + 500 = 2000.8989
        assertEquals("2000.8989", cuentaDestino.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas() {
        // Arrange: Crear cuentas y banco de prueba
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
         // Usar nombres diferentes puede ser más claro
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));
        Banco banco = new Banco(); // Asume constructor que inicializa lista interna
        banco.setNombre("Banco del Estado");

        // Act: Establecer la relación añadiendo cuentas al banco
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        // Act: Realizar una transferencia (para verificar estado general)
        banco.transferir(cuenta2, cuenta1, new BigDecimal("500"));

        // Assert: Verificar saldos después de la transferencia
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()); // Saldo cuenta origen
        assertEquals("3000", cuenta1.getSaldo().toPlainString()); // Saldo cuenta destino

        // Assert: Verificar la relación (el banco debe tener 2 cuentas)
        assertEquals(2, banco.getCuentas().size());
    }

}