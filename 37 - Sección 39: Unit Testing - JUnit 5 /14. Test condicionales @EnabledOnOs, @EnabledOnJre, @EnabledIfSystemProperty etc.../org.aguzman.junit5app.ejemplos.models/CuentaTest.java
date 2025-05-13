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

    @BeforeAll 
    static void beforeAll(){
        System.out.println("Inicializando el test - @BeforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Finalizando el test - @AfterAll");
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

    
    //Paso 1: Ejecuta esta prueba solo en Windows
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows(){

    }

    //Paso 2: Ejecuta esta prueba solo en Linux y Mac
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac(){

    }

    //Paso 3: Deshabilita esta prueba en Windows
    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNoWindows(){

    }

    //Paso 4: Ejecuta esta prueba solo en JDK 8
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void soloJdk8(){

    }

    //Paso 5: Deshabilita esta prueba en JDK 18
    @Test
    @DisabledOnJre(JRE.JAVA_18)
    void testNoJDK18(){

    }


    // Paso 6: Imprime todas las propiedades del sistema para referencia
    @Test
    void imprimirSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((k,v) -> System.out.println(k + ":" +v));
    }

    // Paso 7: Ejecuta esta prueba solo si la versión de Java es exactamente "23.0.1+11-39"
    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "23.0.1+11-39")
    void testJavaVersion(){}

    // Paso 8: Ejecuta esta prueba si la versión de Java contiene "23"
    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = ".*23*.")
    void testJavaVersion2(){}

    // Paso 9: Deshabilita esta prueba si la arquitectura del sistema contiene "32"
    @Test
    @DisabledIfSystemProperty(named = "OS.arch", matches = ".*32.*")
    void testsolo64(){}

    // Paso 10: Ejecuta esta prueba solo si la arquitectura del sistema contiene "32"
    @Test
    @EnabledIfSystemProperty(named = "OS.arch", matches = ".*32.*")
    void testNo64(){}

    //  Paso 11: Ejecuta esta prueba solo si el nombre de usuario es "Alejandro"
    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "Alejandro")
    void testUsername(){}

}

