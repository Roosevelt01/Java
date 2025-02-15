package org.aguzman.api.stream;

import org.aguzman.api.stream.models.Usuario;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamApiOptional {
    public static void main(String[] args) {

        System.out.println("Ejemplo #1 - OrElse");
        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println(usuario.orElse((new Usuario("John", "Doe"))));

         System.out.println("Ejemplo #2 - OrElseGet");
        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println(usuario.orElseGet(() -> new Usuario("John", "Doe")).getNombre());

        System.out.println("Ejemplo #3 - isPresent");
        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();

        if(usuario.isPresent()){
            System.out.println(usuario.get().getNombre());
        }else{
            System.out.println("No se encontró el objeto!");
        }

        System.out.println("Ejemplo #4 - orElseGet");
        Usuario usuario = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(u -> u.getId().equals(6))
                .findFirst().orElseGet(() -> new Usuario("John", "Doe"));

        System.out.println(usuario);
    }
}
