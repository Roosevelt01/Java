public class Automovil{ 
    String fabricante;
    String modelo;
    String color = "gris";
    double cilindrada;

    public String verDetalle(){
        return "auto.frabricante = " + this.fabricante +
               "\nauto.modelo = " + this.modelo +
               "\nauto.color = " + this.color +
               "\nauto.cilindrada = " + this.cilindrada;
    }

    public String acelerar(int rpm){
        return "el auto " + this.fabricante + " acelerando a " + rpm + "rpm";
    }

    public String frenar(int rpm){
        return this.fabricante + " " + this.modelo + " frenando!";
    }
    
    public String acelerarFrenar(int rpm){
        String acelerar = this.acelerar(rpm);        
        String frenar = this.frenar();        
        return acelerar + "\n" + frenar);        
    }
}

public class EjemploAutomovil{
    public static void main(String[] args){

        Automovil suburu = new Automovil();
        subaru.fabricante = "Subaru";
        subaru.modelo = "Impreza";
        subaru.cilindrada = 2.0;
        subaru.color = "Blanco";

        Automovil mazda = new Automovil();
        mazda.fabricante = "Mazda";
        mazda.modelo = "BT-50";
        mazda.cilindrada = 3.0;
        mazda.color = "Rojo";

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());

        System.out.println(mazda.acelerarFrenar(4000)):
    }
}
