public class Automovil {
    private String fabricante;
    private String modelo;
    private String color;
    private double cilindrada;
    private int capacidadStanque;

    public Automovil() {
    }

    public Automovil(String fabricante, String modelo, String color) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, String color, double cilindrada) {
        this(fabricante, modelo, color);
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, String color, double cilindrada, int capacidadStanque) {
        this(fabricante, modelo, color, cilindrada);
        this.capacidadStanque = capacidadStanque;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public int getCapacidadStanque() {
        return capacidadStanque;
    }
}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil mazda = new Automovil("Mazda","BT-S8","Rojo");

        System.out.println("Mazda:");
        System.out.println("  Fabricante: " + mazda.getFabricante());
        System.out.println("  Modelo: " + mazda.getModelo());
        System.out.println("  Color: " + mazda.getColor());

        Automovil Toyota = new Automovil("Toyota","BR-F8","Azul", 4);

        Automovil Ferrari = new Automovil("Toyota","BR-F8","Azul", 4.4,2);
    }
}
