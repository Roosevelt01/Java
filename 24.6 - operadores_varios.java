package org.aguzman.api.stream;

import org.aguzman.api.stream.models.Usuario;
import org.w3c.dom.ls.LSOutput;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        //Temario - isEmpty
        System.out.println("Ejemplo #1 - isEmpty");
        long count = Stream
                .of("Pato Guzman", "Paco Gonzalez", "", "Pepe Mena", "")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();
        System.out.println("count = " + count);

        //Temario - distinct
        System.out.println("Ejemplo #2 - distinct");
        Stream.of("Pato Guzman","Paco Gonzalez","Pepa Gutierrez", "Pepe Mena",
                "Pepe Garcia", "Paco Gonzalez","Paco Gonzalez","Paco Gonzalez")
                .distinct()
                .forEach(System.out::println);

        //Temario - reduce
        System.out.println("Ejemplo #3 - Reduce()");
        Stream<String> nombres = Stream.of("Pato Guzman", "Paco Gonzalez", "Pepe Mena",
                "Pepe García", "Paco Gonzalez","Paco Gonzalez","Paco Gonzalez")
                .distinct();
        String resultado = nombres.reduce("", (a, b) -> a + ", "+ b);
        System.out.println("resultado  ="+resultado);
  
        System.out.println("Ejemplo #3.1 - Reduce con Integer");
        Stream<Integer> nombres = Stream.of(5, 10, 15, 20);
        
        int resultado = nombres.reduce(0, (a, b) -> a + b);
        System.out.println(resultado);

        //Temario - Range
        System.out.println("Ejemplo #5 - Range");
        IntStream sum  = IntStream.range(5, 20);
        
        int resultado = sum.reduce(0, Integer::sum);
        System.out.println(resultado);

        System.out.println("Ejemplo #5 - Range").;
        IntStream sum  = IntStream.range(5, 20);
        
        int resultado = sum.reduce(0, Integer::sum);
        System.out.println(resultado);
      
        //Temario - summaryStatistics      
        System.out.println("Ejemplo # 6 - summaryStatistics");                    
        IntStream num = IntStream.range(5, 20).peek(System.out::println);

        IntSummaryStatistics stats = num.summaryStatistics();
        System.out.println("max: "+stats.getMax());
        System.out.println("min: "+stats.getMin());
        System.out.println("sum: "+stats.getSum());
        System.out.println("promedio: "+stats.getAverage());
        System.out.println("total: "+stats.getCount());
        System.out.println("max: "+stats.getMax());

    }
}
