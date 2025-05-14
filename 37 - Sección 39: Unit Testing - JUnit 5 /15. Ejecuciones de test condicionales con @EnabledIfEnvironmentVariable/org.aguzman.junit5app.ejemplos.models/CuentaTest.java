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
    
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows(){

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac(){

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNoWindows(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void soloJdk8(){

    }

    @Test
    @DisabledOnJre(JRE.JAVA_18)
    void testNoJDK18(){

    }

    @Test
    void imprimirSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((k,v) -> System.out.println(k + ":" +v));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "23.0.1+11-39")
    void testJavaVersion(){}

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = ".*23*.")
    void testJavaVersion2(){}

    @Test
    @DisabledIfSystemProperty(named = "OS.arch", matches = ".*32.*")
    void testsolo64(){}

    @Test
    @EnabledIfSystemProperty(named = "OS.arch", matches = ".*32.*")
    void testNo64(){}

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "Alejandro")
    void testUsername(){}

     //Paso 1: Método para imprimir todas las variables de ambiente
    @Test
    @DisplayName("Imprimir todas las variables de ambiente") // Añade DisplayName para claridad
    void imprimirVariablesAmbiente(){
        // Obtiene un mapa (Map) que contiene todas las variables de entorno del sistema.
        Map<String, String> getenv = System.getenv();
        // Itera sobre el mapa usando un forEach con lambda
        getenv.forEach((k, v) ->
            // Imprime el nombre de la variable (clave) y su valor.
            System.out.println(k + " = " + v )
        );

        /*
        * Ejemplo de Salida (la salida exacta varía según el sistema operativo y su configuración):
        * Iniciando el método.
        * USERDOMAIN_ROAMINGPROFILE = DESKTOP-1K9GPI0
        * LOCALAPPDATA = C:\Users\Alejandro\AppData\Local
        * JAVA_HOME = C:\Program Files\Java\jdk-23
        * Path = C:\Program Files\Common Files\Oracle\Java\javapath;...
        * OS = Windows_NT
        * USERNAME = Alejandro
        * NUMBER_OF_PROCESSORS = 12
        * ... otras variables ...
        * Finalizando el metodo de prueba.
        */
    }

 //Paso 2:
    @Test
    // Habilita si la variable de entorno 'JAVA_HOME' coincide con la regex ".*jdk-23.*"
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-23.*")
    @DisplayName("Test si JAVA_HOME apunta a un JDK 23") // Añade DisplayName
    void testJavaHome(){
        System.out.println("-> Ejecutando testJavaHome (JAVA_HOME contiene 'jdk-23')");
        /*
         * Resultado ejemplo si JAVA_HOME fuera "C:\Program Files\Java\jdk-23":
         * Iniciando el metodo.
         * -> Ejecutando testJavaHome (JAVA_HOME contiene 'jdk-23')
         * Finalizando el metodo de prueba.
         * Process finished with exit code 0
         */
    }

    //Paso 3:
    @Test
    // Habilita si la variable de entorno 'NUMBER_OF_PROCESSORS' coincide exactamente con "12"
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "12")
    @DisplayName("Test si el sistema tiene 12 procesadores lógicos") // Añade DisplayName
    void testProcesadores(){
        System.out.println("-> Ejecutando testProcesadores (NUMBER_OF_PROCESSORS es 12)");
        /*
         * Ejemplo de Resultado con matches="12" (y 12 procesadores):
         * Iniciando el metodo.
         * -> Ejecutando testProcesadores (NUMBER_OF_PROCESSORS es 12)
         * Finalizando el metodo de prueba.
         * Process finished with exit code 0
         *
         * Ejemplo de Resultado con matches="8" (y 12 procesadores):
         * Environment variable [NUMBER_OF_PROCESSORS] with value [12] does not match regular expression [8].
         * (La prueba se deshabilita y se reporta la razón)
         * Process finished with exit code 0 (si todas las demás pasaron o fueron deshabilitadas)
         */
    }

    //Paso 3 (Otro ejemplo de variable de entorno, quizás configurada manualmente)
    @Test
    // Habilita si la variable de entorno 'ENVIRONMENT' coincide exactamente con "DEV"
    @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "DEV")
    @DisplayName("Test solo si ENVIRONMENT es DEV") // Añade DisplayName
    void testEnvDev(){ // Nombre de método ajustado
        System.out.println("-> Ejecutando testEnvDev (ENVIRONMENT=DEV)");
        /*
         * Ejemplo de Resultado con ENVIRONMENT="DEV" y matches="DEV":
         * Iniciando el metodo.
         * -> Ejecutando testEnvDev (ENVIRONMENT=DEV)
         * Finalizando el metodo de prueba.
         *
         * Ejemplo de Resultado con ENVIRONMENT="dev" y matches="DEV":
         * Environment variable [ENVIRONMENT] with value [dev] does not match regular expression [DEV].
         * (La prueba se deshabilita. ¡Las regex son sensibles a mayúsculas/minúsculas por defecto!)
         */
    }

    //Paso 4:
    @Test
    // Deshabilita si la variable de entorno 'ENVIRONMENT' coincide con la regex "pro" (ignora mayúsculas/minúsculas)
    @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "(?i)pro") // (?i) hace la regex case-insensitive
    @DisplayName("Test deshabilitado si ENVIRONMENT es 'pro' (produccion)") // Añade DisplayName
    void testEnvProdDisabled(){
        System.out.println("-> Ejecutando testEnvProdDisabled (ENVIRONMENT no es 'pro')");
        /*
         * Ejemplo de Resultado si ENVIRONMENT="production" y matches="(?i)pro":
         * Environment variable [ENVIRONMENT] with value [production] matches regular expression [(?i)pro].
         * (La prueba se deshabilita)
         *
         * Ejemplo de Resultado si ENVIRONMENT="qa" y matches="(?i)pro":
         * -> Ejecutando testEnvProdDisabled (ENVIRONMENT no es 'pro')
         * (La prueba se habilita)
         */
    }
}

