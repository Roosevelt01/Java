package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1");
        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        //Computador defecto = new Computador("HP Omen","LA0001");
        Computador pc = repositorio.filtrar("rog").orElse(valorDefecto());
        System.out.println(pc);

        System.out.println("\nEjemplo #2");
        Repositorio<Computador> repositorio2 = new ComputadorRepositorio();
        Computador pc2 = repositorio.filtrar("macbook pro")
                .orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);

        System.out.println(pc2);
    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP", "LA0001");
    }
}
