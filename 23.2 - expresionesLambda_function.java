import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {
        
        System.out.println("Ejemplo #2");
        Function<String, String> f1 = param -> "Hola que tal! " + param;
        String resultado = f1.apply("Andres");
        System.out.println(resultado);

        System.out.println("\nEjemplo #2 - toUpperCase");
        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("andres"));

        System.out.println("\nEjemplo #3 - toUppercase + concat");
        BiFunction<String, String, String> f3 = (a, b) ->  a.toUpperCase().concat(b.toUpperCase());
        String r2 = f3.apply("andres", "jose");
        System.out.println(r2);

        System.out.println("\nEjemplo #4 - comparteTo");
        BiFunction<String, String, Integer> f4 = String::compareTo;
        System.out.println(f4.apply("andres","jose"));

        System.out.println("\nEjemplo #5 - concat");
        BiFunction<String, String, String> f5 = String::concat;
        System.out.println(f5.apply("andres","jose"));
        
        //Ejercicios sacado desde la DeepSeek

        //Ejemplo 1: Función que convierte un número a su cuadrado
        Function<Integer, Integer> cuadrado = (num) -> num * num;
        System.out.println(cuadrado.apply(5)); // Salida: 25
        
        // Ejemplo 2: Función compuesta (combinación de funciones)
        Function<Integer, Integer> multiplicarPor2 = (num) -> num * 2;
        Function<Integer, Integer> sumar3 = (num) -> num + 3;

        // Combinar funciones: primero multiplicar por 2, luego sumar 3
        Function<Integer, Integer> multiplicarYSumar = multiplicarPor2.andThen(sumar3);
        System.out.println(multiplicarYSumar.apply(5)); // Salida: 13

        /*Explicación:

        multiplicarPor2.andThen(sumar3) crea una nueva función que primero aplica multiplicarPor2 y luego sumar3.

                apply(5) llama a la función compuesta:

                    5 * 2 = 10

                    10 + 3 = 13*/
    }
}
