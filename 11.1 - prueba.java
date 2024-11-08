import java.util.Random;

public class Main {
    public static void main(String[] args) {
            if(args.length!=3){
                System.out.println("Por favor ingrese una operación" +
                        "(suma, resta, div o multi) y dos enteros");
                System.exit(-1);
            }
            String operacion = args[0];
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);
            double resultado = 0.00;
            if(operacion.equalsIgnoreCase("suma")){
                resultado = a+b;
            }else if(operacion.equalsIgnoreCase("resta")){
                resultado = a-b;
            }else if(operacion.equalsIgnoreCase("multi")){
                resultado = a*b;
            }else if(operacion.equalsIgnoreCase("div")){
                if(b==0){
                    System.out.println("No se puede dividir por zero!");
                }
                resultado = (double)a/b;
            }else{
                System.out.println("No has seleccionado la operación");
            }

        System.out.println("Resultado de la operación " +operacion+ " es: "+resultado);
    }
}

