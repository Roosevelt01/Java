//Clase calculadora
package org.aguzman.poosobrecarga;

public class Calculadora {
        public int sumar(int... argumentos){
            int total = 0;
            for(int i: argumentos){
                total+=i;
            }
            return total;
        }

        public float sumar(float a, int... argumentos){
            float total = a;
            for(int i: argumentos){
                total+=i;
            }
            return total;
        }

    public double sumar(double... varargs){
        double total = 0.0;
        for(double d: varargs){
            total+=d;
        }
        return total;
    }
}

//Main Principal
package org.aguzman.poosobrecarga;

public class EjemploSobrecarga {
    public static void main(String[] args) {
        Calculadora cal = new Calculadora();

        System.out.println("Sumar 4 int: "+ cal.sumar(10, 5, 3,4));
        System.out.println("Sumas 6 int: "+cal.sumar(10, 5, 3, 4, 5, 6));
        System.out.println("Sumar float + n int: "+ cal.sumar(10.5F, 5, 9, 15));
        System.out.println("Sumar 4 double: "+ cal.sumar(10.0, 5.0, 3.5, 4.5));
    }
}


