package org.aguzman.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest{

    //Ejemplo 1
    @Test
    void testNombreCuenta() { // Nombre simple inicial
        // Arrange
        Cuenta cuenta = new Cuenta(); // Asumiendo constructor vacío existe
        //cuenta.setPersona("Andres"); 
        String esperado = "Andres"; // Valor que esperamos obtener

        // Act
        String real = cuenta.getPersona(); // Obtener el nombre establecido

        // Assert
        // Verifica si el valor real es igual al esperado. Falla si no lo son.
        assertEquals(esperado, real); 
    }

    //Ejemplo 2
    @Test
    void testNombreCuenta() {
        //Arrange: Preparamos los datos de prueba
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        String esperado = "Andres";  // Valor que esperamos obtener
        
        //Act: Ejecutamos la operación a probar
        String real = cuenta.getPersona();  // Obtenemos el valor real
        
        //Assert: Verificamos el resultado
        assertEquals(esperado, real);  // Comparamos esperado vs real
    }

    //Ejemplo 3
    @Test
        void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        String real = cuenta.getPersona();
        assertTrue(real.equals("Andre"));  // Esta prueba fallará
    }
        
}