package org.aguzman.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest{

    @Test
    void testSaldoCuenta() {
        // Arrange: Configuración inicial del objeto de prueba
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        
        // Assert: Validaciones del saldo
        // 1. Verificación del valor exacto del saldo
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        
        // 2. Validación de que el saldo no es negativo
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        
        // 3. Validación de que el saldo no es positivo (esto fallará intencionalmente)
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }        
}