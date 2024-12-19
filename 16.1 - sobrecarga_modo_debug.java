
//Clase Calculadora
package org.aguzman.poosobrecarga;

public class Calculadora {

    public int sumar(int a, int b){
        return a+b;
    }

    public float sumar(float a, float b){
        return a+b;
    }

    public float sumar(int i, float j){
        return i+j;
    }

    public float sumar(float i, int j){
        return i + j;
    }

    public double sumar(double a, double b){
        return a+b;
    }

    public int sumar(String a, String b){
        int resultado;
        
        try{
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
        }catch(NumberFormatException e){
            resultado = 0;
        }
        return resultado;
    }

    public int sumar(int a, int b, int c){
        return a+b+c;
    }
}

//Método Main
package org.aguzman.poosobrecarga;

public class EjemploSobrecarga {
    public static void main(String[] args) {
        Calculadora cal = new Calculadora();

        System.out.println("Sumar int: "+cal.sumar(10, 5));
        System.out.println("Sumar float: "+cal.sumar(10.0F, 5));
        System.out.println("Sumat float-int: "+cal.sumar(10F,5));
        System.out.println("Sumar int-flot: "+cal.sumar(10,5.0F));
        System.out.println("Suma double: "+cal.sumar(10.0,5.0));
        System.out.println("Sumar String: "+cal.sumar("10","5"));
        System.out.println("Sumar tres int: "+cal.sumar(10,5,3));

        System.out.println("Sumar long: "+cal.sumar(10L,5L));
        
    }
}
