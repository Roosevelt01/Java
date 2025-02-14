package org.aguzman.api.stream.models;

public class Usuario {
    private String nombre, apellido;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', apellido='" + apellido + "'}";
    }
}

//main principal
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
