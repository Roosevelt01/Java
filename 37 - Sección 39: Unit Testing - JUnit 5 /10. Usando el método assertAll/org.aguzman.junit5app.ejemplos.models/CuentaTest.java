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

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500")); 
        Cuenta cuenta2 = new Cuenta("Jhon Doe", new BigDecimal("1500.8989")); 
        
        Banco banco = new Banco();
        banco.setNombre("Nombre del estado");
        
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()); 
        assertEquals("3000", cuenta1.getSaldo().toPlainString()); 
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Jhon Doe", new BigDecimal("1500.8989"));
        
        Banco banco = new Banco();
        banco.addCuenta(cuenta1); 
        banco.addCuenta(cuenta2);
        banco.setNombre("Nombre del estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        
        // Agrupar todas las aserciones con assertAll
        assertAll(
            // Cada aserción se envuelve en una expresión lambda () -> ...
            () -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(),
                        "Saldo cuenta 2 (origen) incorrecto tras transferir."), // Mensaje opcional añadido
            () -> assertEquals("3000", cuenta1.getSaldo().toPlainString(),
                        "Saldo cuenta 1 (destino) incorrecto tras transferir."),
            () -> assertEquals(2, banco.getCuentas().size(),
                        "El banco no tiene el número esperado de cuentas."),
            () -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre(),
                        "El nombre del banco asociado a cuenta1 es incorrecto."),
            () -> assertEquals("Andres", banco.getCuentas().stream()
                            .filter(c -> c.getPersona().equals("Andres"))
                            .findFirst()
                            .get().getPersona(), "No se encontró la persona 'Andres' vía stream/filter."),
            () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Andres")), "No se encontró 'Andres' vía stream/anyMatch.")
        ); gfg
    }
}