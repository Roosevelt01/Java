public class Automovil{
    String fabricante;  
    String modelo;  
    String color = "gris";  
    String cilindrada;  
}

public class EjemploAutomovil{
  public static void main(String[] args){
      Automovil auto = new Automovil();
      auto.fabricante = "Subaru";
      auto.modelo = "Impresa";
      auto.cilindrada = 2.0;
      auto.color = "Blanco";

      System.out.println("auto.fabricante = " + auto.fabricante);
      System.out.println("auto.modelo = " + auto.modelo);
      System.out.println("auto.color = " + auto.color);
      System.out.println("auto.cilindrada = " + auto.cilindrada);
    
      Automovil mazda  = new Automovil();
      mazda.fabricante = "Mazda";
      mazda.modelo = "BT-50";
      mazda.cilindrada = 3.0;
      mazda.color = "Rojo";

      System.out.println("mazda.fabricante = " + mazda.fabricante);
      System.out.println("mazda.modelo = " + mazda.modelo);
      System.out.println("mazda.color = " + mazda.color);
      System.out.println("mazda.cilindrada = " + mazda.cilindrada);

  }
}
