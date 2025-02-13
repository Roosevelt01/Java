//Aritmetica: Una interfaz funcional que define una operación aritmética.
package org.aguzman.java8.lambda.aritmatica;

public interface Aritmetica {
    double operacion(double a, double b);
}

//Calculadora: Una clase que utiliza la interfaz Aritmetica y BiFunction para realizar cálculos.
package org.aguzman.java8.lambda.aritmatica;

import java.util.function.BiFunction;

public class Calculadora {
    public double computar(double a, double b, Aritmetica lambda){
        return lambda.operacion(a, b);
    }
    
    public double computarConBiFunction(double a, double b, BiFunction<Double, Double, Double> lambda){
        return lambda.apply(a, b);
    }
}

//EjemploInterfaceFunctional: La clase principal que demuestra el uso de las interfaces funcionales y lambdas.
package org.aguzman.java8.lambda.aritmatica;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {
        Aritmetica suma = Double::sum;
        Aritmetica resta = (a, b) -> a - b;
        
        Calculadora cal = new Calculadora();

        System.out.println(cal.computar(10, 5, suma));
        System.out.println(cal.computar(10, 5, resta));
        System.out.println(cal.computar(10, 5, (a, b) -> a * b));

        System.out.println(cal.computarConBiFunction(10, 5, Double::sum));
    }
}

