package org.aguzman.generics;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres","Guzmán"));

        Cliente andres = clientes.iterator().next();

        Cliente[] clientesArreglo = {new Cliente("Luci", "Martínez"),
                new Cliente("Andrés", "Guzmán")};

        Integer[] enterosArreglos = {1,2,3};

        List<Cliente> clientelista = fromArrayToList(clientesArreglo);
        List<Integer> enteroslista = fromArrayToList(enterosArreglos);

        clientelista.forEach(System.out::println);
        enteroslista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andrés", "Pepe", "Luci", "Bea", "John"},
                enterosArreglos);
        nombres.forEach(System.out::println);


    }
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }
}
