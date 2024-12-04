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
    public String toString() {
        return "Fabricante: " + fabricante +
                "\n Modelo: " + modelo +
                "\nColor: " + color;
    }
}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil mazda = new Automovil("Mazda","BT-S8","Rojo");

        Automovil mazda2 = new Automovil("Mazda","BT-S8","Blanco");

        System.out.println("Automóvil 1: " + mazda.toString());
        System.out.println("\nAutomóvil 2: " + mazda2.toString());

    }
}
