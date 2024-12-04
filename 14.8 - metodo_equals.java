import java.util.Objects;

public class Automovil {
    private String fabricante;
    private String modelo;
    private String color;

    public Automovil() {
    }

    public Automovil(String fabricante, String modelo, String color) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public boolean equals(Object obj) {
        Automovil a = (Automovil) obj;
        return(this.fabricante.equals(a.getFabricante()) && this.modelo.equals(a.getModelo()) && this.color.equals(a.getColor()));
    }

}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil mazda = new Automovil("Mazda","BT-S8","Rojo");

        System.out.println("Mazda:");
        System.out.println("  Fabricante: " + mazda.getFabricante());
        System.out.println("  Modelo: " + mazda.getModelo());
        System.out.println("  Color: " + mazda.getColor());

        Automovil mazda2 = new Automovil("Mazda","BT-S8","Blanco");

        System.out.println("Son iguales con equals? "+ (mazda.equals(mazda2)));
    }
}
