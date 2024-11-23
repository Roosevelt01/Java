public class Automovil{
  String fabricante;
  String modelo;
  String color="gris";
  double cilindrada;

  public void detalle(){
    System.out.println("auto.fabricante = "+ this.fabricante);
    System.out.println("auto.modelo = "+ this.modelo);
    System.out.println("auto.color = "+ this.color);
    System.out.println("auto.cilidranda = "+ this.cilidranda);
  }
 
}

public class EjemploAutomovil{
    public static void main(String[] args){
        Automovil subaru = new Automovil();
        suburu.fabricante = "Subaru";
        suburu.fabricante = "Impreza";
        suburu.fabricante = "2.0";
        suburu.fabricante = "Blanco";

        Automovil mazda = new Automovil();
        suburu.fabricante = "Mazda";
        suburu.fabricante = "BT-50";
        suburu.fabricante = "3.0";
        suburu.fabricante = "Rojo";

        subaru.detalle();
        mazda.detalle();
    }  
}
