package org.aguzman.api.stream;

import org.aguzman.api.stream.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {
        //Ejemplo #1         
        System.out.println("Ejemplo #1");
        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);

        //Ejemplo #2 
        System.out.println("Ejemplo #2");
        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println(usuario.get());

        //Ejemplo #3
        System.out.println("Ejemplo #3");
        Usuario usuario = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getId().equals(3))
                .findFirst().get();

        System.out.println(usuario);

        //Ejemplo #4: Filtrar números pares
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> numerosPares = numeros.stream()
            .filter(n -> n % 2 == 0) // Filtra los números pares
            .collect(Collectors.toList());
        
        System.out.println(numerosPares); // Salida: [2, 4, 6]
        /*
            Explicación:

                - filter(n -> n % 2 == 0) evalúa si cada número es par.

                - Solo los números pares (2, 4, 6) pasan al siguiente paso.

                - El resultado es una lista con los números pares.
        */

        //Ejemplo #5: Filtrar nombres que comienzan con "A"
        List<String> nombres = Arrays.asList("Ana", "Juan", "Andrés", "Luis", "Alejandra");
        
        List<String> nombresConA = nombres.stream()
            .filter(n -> n.startsWith("A")) // Filtra nombres que comienzan con "A"
            .collect(Collectors.toList());
        
        System.out.println(nombresConA); // Salida: [Ana, Andrés, Alejandra]
        /*
            Explicación:

                - filter(n -> n.startsWith("A")) evalúa si cada nombre comienza con la letra "A".

                - Solo los nombres que cumplen la condición ("Ana", "Andrés", "Alejandra") pasan al siguiente paso.
                
                - El resultado es una lista con los nombres que comienzan con "A".
        */

        //Ejemplo #6: Filtrar objetos personalizados
        //Supongamos que tienes una clase Usuario:
        class Usuario {
            private String nombre;
            private int edad;
        
            // Constructor, getters y setters
        }

         List<Usuario> usuarios = Arrays.asList(
            new Usuario("Ana", 25),
            new Usuario("Juan", 17),
            new Usuario("Luis", 30)
        );
        
        List<Usuario> usuariosMayores = usuarios.stream()
            .filter(u -> u.getEdad() > 18) // Filtra usuarios mayores de 18 años
            .collect(Collectors.toList());
        
        usuariosMayores.forEach(u -> System.out.println(u.getNombre())); // Salida: Ana, Luis
        /*
            Explicación:

                - filter(u -> u.getEdad() > 18) evalúa si la edad de cada usuario es mayor que 18.

                - Solo los usuarios que cumplen la condición ("Ana", "Luis") pasan al siguiente paso.
                
                - El resultado es una lista con los usuarios mayores de 18 años.
        */

        //Ejemplo #7: encadenamiento de filter
        List<String> nombres = Arrays.asList("Ana", "Juan", "Andrés", "Luis", "Alejandra");

        List<String> nombresFiltrados = nombres.stream()
            .filter(n -> n.startsWith("A")) // Filtra nombres que comienzan con "A"
            .filter(n -> n.length() > 3) // Filtra nombres con más de 3 caracteres
            .collect(Collectors.toList());
        
        System.out.println(nombresFiltrados); // Salida: [Andrés, Alejandra]

        //Ejemplo #8: Filtra nombres vacíos (no aplica en este caso)
        List<String> nombres = Arrays.asList("Ana", "Juan", "Andrés", "Luis", "Alejandra");

        List<String> nombresFiltrados = nombres.stream()
            .filter(String::isEmpty) // Filtra nombres vacíos (no aplica en este caso)
            .collect(Collectors.toList());
        
        System.out.println(nombresFiltrados); // Salida: []
    }
}
