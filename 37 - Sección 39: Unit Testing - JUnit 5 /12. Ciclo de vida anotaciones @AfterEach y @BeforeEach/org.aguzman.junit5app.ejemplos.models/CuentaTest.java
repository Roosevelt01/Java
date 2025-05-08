package org.aguzman.junit5app.ejemplos.models;
import org.aguzman.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    // Paso 1: Declarar una variable de instancia para el objeto Cuenta
    Cuenta cuenta;

    // Paso 2: Crear un método anotado con @BeforeEach para la configuración antes de CADA test
    @BeforeEach // Anotación para ejecutar antes de cada @Test
    void initMetodoTest(){
        // Inicializar la variable de instancia 'cuenta'
        // Esta línea se ejecutará antes de cada test, creando una nueva instancia para cada uno.
        this.cuenta = new Cuenta("Andres GF", new BigDecimal("1000.12345"));
        // Imprimir un mensaje para visualizar la ejecución del hook
        System.out.println("Iniciando el método de prueba. ");
    }

    // Paso 3: Crear un método anotado con @AfterEach para la limpieza después de CADA test
    @AfterEach // Anotación para ejecutar después de cada @Test
    void tearDown() {
        // Imprimir un mensaje para visualizar la ejecución del hook de limpieza
        System.out.println("Finalizando el método de prueba.");
        // En pruebas reales, aquí se liberan recursos (cerrar conexiones, borrar archivos, etc.)
    }

    @Test
    @DisplayName("probando el nombre de la cuenta corriente, que no sea null mayor que cero, valor esperado!")
    void testNombreCuenta() {
        // Ya no necesitamos crear 'cuenta' aquí, @BeforeEach lo hace por nosotros.
        String esperado = "Andres";
        String real = cuenta.getPersona();
        assertNotNull(real, () -> "La cuenta no puede ser nula");
        assertEquals(esperado, real,  () -> "El nombre de la cuenta no es que se esperaba: se esperaba"+ esperado
                +" sin embargo fue "+ real);
        assertTrue(real.equals("Andres"),  () -> "nombre cuenta esperada debe ser igual a la real");
    }

    @Test
    @DisplayName("probando el nombre de la cuenta corriente!")
    void testSaldoCuenta() {
        // Usamos la variable de instancia inicializada por @BeforeEach
        cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void TestReferenciaCuenta() {
        
        cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        assertEquals(cuenta2, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        // Usa la variable de instancia 'cuenta' inicializada por @BeforeEach
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        // Usa la variable de instancia 'cuenta' inicializada por @BeforeEach
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
        fail();// Esta línea no se ejecutará debido a @Disabled
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