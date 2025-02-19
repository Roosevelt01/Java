package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1");
        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        Computador pc = repositorio.filtrar("rog").orElseThrow(IllegalAccessError::new);
        System.out.println(pc);

        System.out.println("\nEjemplo #2");
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".")+1))
                .orElseThrow();
        System.out.println(extension);
    }
}
