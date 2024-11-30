public class Automovil{

  public float calcularConsumo(int km, float porcentajeBencina){
     return km/(capacidadEstanque*porcentajeBencina); 
  }

  public float calcularConsumo(int km, int porcentajeBencina){
     return km/(capacidadEstanque*(porcentajeBencina/100f); 
  }
}

public class EjemploAutomovil{
    public static void main(String[] args){
        Automovil subaru = new Automovil();

        System.out.println("Kilómetros por litro: "+ subaru.calcularConsuma(300, 0.75f));
      
        System.out.println("Kilómetros por litro: "+ subaru.calcularConsuma(300, 60));
    }  
}
