package org.aguzman.junit5app.ejemplos.models;

import org.aguzman.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*; // Importa todas las anotaciones de JUnit Jupiter
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    // Declara una variable de instancia para el objeto que se configurará antes de cada test.
    Cuenta cuenta;

    // Paso 1: Método anotado con @BeforeEach para la configuración antes de CADA método @Test
    @BeforeEach // Anotación para ejecutar antes de cada @Test
    void initMetodoTest(){ // Este es un método de instancia (no static)
        // Inicializa la variable de instancia 'cuenta'.
        // Una *nueva* instancia de CuentaTest se crea para cada @Test,
        // por lo que esta línea se ejecuta para inicializar 'cuenta' en esa instancia nueva.
        this.cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        // Mensaje para visualizar la ejecución del hook
        System.out.println("Iniciando el método. ");
    }

    // Paso 2: Método anotado con @AfterEach para la limpieza después de CADA método @Test
    @AfterEach // Anotación para ejecutar después de cada @Test
    void tearDown() { // Este es un método de instancia (no static)
        // Mensaje para visualizar la ejecución del hook de limpieza.
        System.out.println("Finalizando el método de prueba.");
        // Aquí iría código para limpiar recursos utilizados por el test recién finalizado.
    }

    // --- Métodos de prueba (@Test) que utilizan el setup de @BeforeEach ---

    @Test
    @DisplayName("probando el nombre de la cuenta corriente, que no sea null mayor que cero, valor esperado!")
    void testNombreCuenta() {
        // Ahora utilizamos la variable de instancia 'cuenta' que fue inicializada
        // por el método @BeforeEach antes de que este test se ejecutara.
        String esperado = "Andres"; // El nombre esperado según la inicialización en @BeforeEach
        String real = cuenta.getPersona();
        assertNotNull(real, () -> "La cuenta no puede ser nula"); // Pasará
        assertEquals(esperado, real,  () -> "El nombre de la cuenta no es que se esperaba: se esperaba"+ esperado
                +" sin embargo fue "+ real); // Pasará
        assertTrue(real.equals("Andres"),  () -> "nombre cuenta esperada debe ser igual a la real"); // Pasará
    }

    @Test
    @DisplayName("probando el debito de la cuenta")
    void testDebitoCuenta() {
         // Usa la variable de instancia 'cuenta' inicializada por @BeforeEach
        cuenta.debito(new BigDecimal(100)); // Aplica el débito a la cuenta configurada
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

     @Test
    @DisplayName("probando el credito a la cuenta")
    void testCreditoCuenta() {
        // Usa la variable de instancia 'cuenta' inicializada por @BeforeEach
        cuenta.credito(new BigDecimal(100)); // Aplica el crédito a la cuenta configurada
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }


    // --- Métodos de prueba (@Test) que crean sus propias instancias locales (No usan el setup de @BeforeEach) ---

    @Test
    @DisplayName("probando el saldo de la cuenta corriente (Que no sea null, mayor que cero, valor esperado)")
    void testSaldoCuenta() {
        // NOTA: Este test crea una *nueva instancia LOCAL* de Cuenta,
        // ignorando intencionalmente (para este test) la instancia creada y configurada por @BeforeEach.
        Cuenta cuentaLocal = new Cuenta("Andres", new BigDecimal("1000.12345"));
        assertNotNull(cuentaLocal.getSaldo());
        assertEquals(1000.12345, cuentaLocal.getSaldo().doubleValue());
        assertFalse(cuentaLocal.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuentaLocal.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    @Test
    @DisplayName("probando referencias de cuenta (misma instancia)!")
    void TestReferenciaCuenta() {
        // NOTA: Este test crea una *nueva instancia LOCAL* de Cuenta,
        // ignorando intencionalmente la instancia de @BeforeEach.
        Cuenta cuentaLocal = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997")); // Esta instancia no se usa en el aserto

        // El aserto verifica que la instancia LOCAL 'cuentaLocal' es igual a sí misma (siempre true).
        assertEquals(cuentaLocal, cuentaLocal, () -> "La misma referencia de cuenta debe ser igual a sí misma");
    }

    @Test
    @DisplayName("probando excepcion de dinero insuficiente")
    void testDineroInsuficienteExceptionCeunta() {
        // Este test crea su propia instancia local, lo cual es adecuado para probar un estado inicial específico (saldo bajo).
        Cuenta cuentaLocal = new Cuenta("Andres", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuentaLocal.debito((new BigDecimal(1500))); // Intenta debitar más del saldo
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente"; // El mensaje esperado de la excepción
        assertEquals(esperado, actual, () -> "El mensaje de la excepción no coincide con el esperado.");
    }

    @Test
    @DisplayName("probando la transferencia de dinero entre cuentas")
    void testTransferirDineroCuentas() {
        // Este test requiere la configuración de dos cuentas y un banco, no usa la variable de instancia 'cuenta'.
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco(); // Asumimos la existencia de la clase Banco
        banco.setNombre("Nombre del estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500)); // Asumimos el método transferir
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    @Disabled
    @DisplayName("probando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas() {
        fail(); // No se ejecutará debido a @Disabled
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1); // Asumimos el método addCuenta
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500)); // Asumimos el método transferir

        assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()),
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Andres", banco.getCuentas().stream()
                                .filter(c -> c.getPersona().equals("Andres"))
                                .findFirst() // Puede lanzar NoSuchElementException si no encuentra
                                .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                            .anyMatch(c -> c.getPersona().equals("Andres"))));
    }
}