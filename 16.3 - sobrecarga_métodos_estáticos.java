//Calculadora 
package org.aguzman.poosobrecarga;

public class Calculadora {

    private Calculadora() {
    }

    public static int sumar(int... argumentos){
                int total = 0;
                for(int i: argumentos){
                    total+=i;
                }
                return total;
        }

        public static float sumar(float a, int... argumentos){
                float total = a;
                for(int i: argumentos){
                total+=i;
            }
            return total;
        }

        public static double sumar(double... varargs){
            double total = 0.0;
            for(double d: varargs){
                total+=d;
            }
            return total;
        }
}

//EjemploSobrecarga
package org.aguzman.poosobrecarga;

import static org.aguzman.poosobrecarga.Calculadora.*;

public class EjemploSobrecarga {
    public static void main(String[] args) {

        System.out.println("Sumar 4 int: "+ sumar(10, 5, 3,4));
        System.out.println("Sumas 6 int: "+ sumar(10, 5, 3, 4, 5, 6));
        System.out.println("Sumar float + n int: "+ sumar(10.5F, 5, 9, 15));
        System.out.println("Sumar 4 double: "+ sumar(10.0, 5.0, 3.5, 4.5));
    }
}

