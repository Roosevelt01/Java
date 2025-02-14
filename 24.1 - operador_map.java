package org.aguzman.api.stream;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        System.out.println("\nEjemplo #1");
        Stream<String> nombres = Stream.of("Pato","Paco","Pepa","Pepe")
                        .map(String::toUpperCase);

        nombres.forEach(System.out::println);

        System.out.println("\nAlternativa");
        Stream.of("Pato","Paco","Pepa","Pepe")
                .map(String::toUpperCase).forEach(System.out::println);

        System.out.println("\nEjemplo #2 - peek()");
        Stream<String> nombres2 = Stream.of("Pato","Paco","Pepa","Pepe")
                .peek(System.out::println)
                .map(String::toUpperCase);
        nombres2.forEach(System.out::println);

        System.out.println("\nEjemplo #3 - Combinaciones");
        Stream<String> nombres3 = Stream.of("Pato","Paco","Pepa","Pepe")
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase);
        nombres3.forEach(System.out::println);

        System.out.println("\nEjemplo #4 - Conversión de Map a List");
        Stream<String> nombres4 = Stream.of("Pato","Paco","Pepa","Pepe")
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase);

        List<String> lista = nombres4.collect(Collectors.toList());
        lista.forEach(System.out::println);
    }
}
