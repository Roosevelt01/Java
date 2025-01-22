package org.aguzman.generics;

public class EjemploGenericos {
    public static void main(String[] args) {
        System.out.println("Máximo de 1, 9 y 4 es: "+ maximo(1, 9, 4));
        System.out.println("Máximo de 3.9, 11.6, 7.78 es: "+ maximo(3.9, 11.6, 7.8));
        System.out.println("Máximo de Zanagoria, Arándanos, Manzana es: "+ maximo("zanahoria", "arándanos", "manzana"));

    }

    
    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;

        if(b.compareTo(max) > 0){
            max = b;
        }


        if(c.compareTo(max) > 0){
            max = c;
        }

        return max;
    }
}
