package org.aguzman.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest{
    @Test
    void testReferenciaCuenta() {
        // Arrange: Crear dos cuentas con mismos valores
        Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        
        // Act/Assert: Verificar igualdad (fallará sin implementar equals)
        assertEquals(cuenta1, cuenta2);  // Falla aquí
    }
}
