package org.aguzman.api.stream;

import org.aguzman.api.stream.models.Usuario;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {
      
         //Temario - Distinct
         System.out.println("Ejemplo 1 - Distinct de la clase Usuario");      
         Stream<Usuario> nombres = Stream
                 .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                         "Pepe Mena", "Pepe Garcia", "Pato Guzman","Pato Guzman")
                 .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                 .distinct();
         nombres.forEach(System.out::println);

        //Temario - mapToInt
        System.out.println("Ejemplo 2 - mapToInt de la clase Usuario");
        IntStream largoNombres = Stream
                .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman","Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length());

        largoNombres.forEach(System.out::println);

        //Temario - SummatyStatisics
        System.out.println("Ejemplo 3 - SummatyStatisics");
        IntStream largoNombres = Stream
                .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman","Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Total: "+ stats.getSum());
        System.out.println("Max: "+ stats.getMax());
        System.out.println("Min: "+ stats.getMin());
        System.out.println("Promedio: "+ stats.getAverage());
      
    }
}
