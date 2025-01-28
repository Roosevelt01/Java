//Main
import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        String numerador = JOptionPane.showInputDialog("Ingrese un numerador: ");
        String denominador = JOptionPane.showInputDialog("Ingrese un denominador: ");

        try{
            //Llamada del primer método dividir
            //divisor = Integer.parseInt(valor);
            //division = cal.dividir(10, divisor);
            //System.out.println(division);

            double division2 = cal.dividir(numerador,denominador);
            System.out.println("División 2: "+division2);
        }catch (NumberFormatException nfe){
            System.out.println("Se detectó una excepción (Ingrese un valor numérico) " + nfe.getMessage());
            main(args);
        }catch (FormatoNumeroException e) {
            System.out.println("Se detectó una excepción (Ingrese un valor numérico) " + e.getMessage());
            main(args);
            e.printStackTrace(System.out);
        }catch (DivisionPorZeroException ae){
            System.out.println("Capturamos la excepción en tiempo de ejecución: " + ae.getMessage());
            main(args);
        }
        System.out.println("Continuamos con el flujo de nuestra aplicación!");
    }
}

//Class FormatoNumeroException
public class FormatoNumeroException  extends Exception{
    public FormatoNumeroException(String message) {
        super(message);
    }
}

//Class DivisionPorZeroException
public class DivisionPorZeroException extends Exception{
    public DivisionPorZeroException(String mensaje){
        super(mensaje);
    }
}

//Class Calculadora
public class Calculadora {

    public double dividir(int numerador, int divisor) throws DivisionPorZeroException{
        if(divisor == 0){
            throw new DivisionPorZeroException("No se puede dividir por cero!");
        }
        return numerador/(double)divisor;
    }

    public double dividir(String numerador, String divisor) throws DivisionPorZeroException, FormatoNumeroException  {
        try{
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        }catch (NumberFormatException e){
            throw new FormatoNumeroException("Debe ingresar un número en el numerador y divisor");
        }
    }
}
