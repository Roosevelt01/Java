package org.aguzman.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {
        System.out.println("Ejemplo 1 - Optional con of");
        String nombre ="Andrés";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);

        System.out.println("\nEjemplo 2 - isPresent");
        String nombre2 ="Andrés";
        Optional<String> opt2 = Optional.of(nombre2);
        System.out.println(opt2.isPresent());
        if(opt2.isPresent()){
            System.out.println("Hola "+ opt2.get());
        }

        System.out.println(opt2.isEmpty());

        System.out.println("\nEjemplo 3 - ifPresent");
        String nombre3 ="Andrés";
        Optional<String> opt3 = Optional.of(nombre3);

        opt3.ifPresent(valor -> {
            System.out.println("Hola "+ valor);
        });

        System.out.println("\nEjemplo #4 - Con Null");
        String nombre4 = null;
        Optional<String> opt4 = Optional.ofNullable(nombre4);
        System.out.println("opt = "+opt4);
        System.out.println(opt4.isPresent());
        System.out.println(opt4.isEmpty());

        opt4.ifPresentOrElse(valor -> System.out.println("Hola "+ valor),
                () ->System.out.println("No está presente"));
    }
}
