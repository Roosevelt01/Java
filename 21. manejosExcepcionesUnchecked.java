import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        String valor = JOptionPane.showInputDialog("Ingrese un entero: ");
        int divisor;

        try{
            divisor = Integer.parseInt(valor);
            int division = 10/divisor;
            System.out.println(division);
        }catch (NumberFormatException nfe){
            System.out.println("Se detectó una excepción (Ingrese un valor numérico) " + nfe.getMessage());
            main(args);
        }catch (ArithmeticException ae){
            System.out.println("Capturamos la excepción en tiempo de ejecución: " + ae.getMessage());
            main(args);
        }
        System.out.println("Continuamos con el flujo de nuestra aplicación!");
    }
}
