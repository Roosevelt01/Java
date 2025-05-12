package org.aguzman.junit5app.ejemplos.models;

import org.aguzman.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMetodoTest(){
        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        System.out.println("Iniciando el método. ");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el método de prueba.");
    }

    // Paso 1: Método anotado con @BeforeAll para configuración a nivel de clase
    @BeforeAll // Anotación para ejecutar una sola vez antes de todos los @Test
    static void beforeAll(){ // Debe ser static
        System.out.println("Inicializando el test - @BeforeAll"); // Mensaje de visualización
    }

    // Paso 2: Método anotado con @AfterAll para limpieza a nivel de clase
    @AfterAll // Anotación para ejecutar una sola vez después de todos los @Test
    static void afterAll(){ // Debe ser static
        System.out.println("Finalizando el test - @AfterAll"); // Mensaje de visualización
    }

    @Test
    @DisplayName("probando el nombre de la cuenta corriente, que no sea null mayor que cero, valor esperado!")
    void testNombreCuenta() {
        String esperado = "Andres";
        String real = cuenta.getPersona();
        assertNotNull(real, () -> "La cuenta no puede ser nula");
        assertEquals(esperado, real,  () -> "El nombre de la cuenta no es que se esperaba: se esperaba"+ esperado
                +" sin embargo fue "+ real);
        assertTrue(real.equals("Andres"),  () -> "nombre cuenta esperada debe ser igual a la real");
    }

    @Test
    @DisplayName("probando el nombre de la cuenta corriente(Que no sea null, mayor que cero, valor esperado)")
    void testSaldoCuenta() {
        cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    @DisplayName("probando el nombre de la cuenta corriente!")
    void TestReferenciaCuenta() {
        cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        assertEquals(cuenta2, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteExceptionCeunta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito((new BigDecimal(1500)));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Nombre del estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    @Disabled
    @DisplayName("probando relaciones entre las cuentas y el banco  con assertAll")
    void testRelacionBancoCuentas() {
        fail();
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()),
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Andres", banco.getCuentas().stream()
                                .filter(c -> c.getPersona().equals("Andres"))
                                .findFirst()
                                .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                            .anyMatch(c -> c.getPersona().equals("Andres"))));
    }
}

//@TestInstance(Lifecycle.PER_CLASS)

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle; // Import estático para acortar

@TestInstance(Lifecycle.PER_CLASS) // Paso 1: Configura el ciclo de vida a Per-Class
class CuentaTest {
    // Paso 2: Método anotado con @BeforeAll (NO estático en modo PER_CLASS)
    @BeforeAll // Anotación para ejecutar una sola vez antes de todos los @Test
    void beforeAll(){ // No necesita ser static en modo PER_CLASS
        System.out.println("Inicializando el test - @BeforeAll"); // Mensaje de visualización
        // Aquí se podría configurar un recurso pesado que se usará UNA sola vez por clase
        // y que puede ser accedido a través de variables de instancia si fuera necesario.
    }

    // Paso 3: Método anotado con @AfterAll (NO estático en modo PER_CLASS)
    @AfterAll // Anotación para ejecutar una sola vez después de todos los @Test
    void afterAll(){ // No necesita ser static en modo PER_CLASS
        System.out.println("Finalizando el test - @AfterAll"); // Mensaje de visualización
        // Aquí se podría limpiar el recurso configurado en beforeAll.
    }
}