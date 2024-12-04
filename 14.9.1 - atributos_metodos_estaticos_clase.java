import java.util.Objects;

public class Automovil {
    private static int contadorAutos = 0; // Contador de autos creados
    private static double precioPromedio = 0; // Precio promedio de los autos

    private String fabricante;
    private String modelo;
    private String color;
    private double precio;

    // Constructor y getters

    public Automovil(String fabricante, String modelo, String color, double precio) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        contadorAutos++;
        actualizarPrecioPromedio(precio);
    }

    private static void actualizarPrecioPromedio(double nuevoPrecio) {
        precioPromedio = ((precioPromedio * (contadorAutos - 1)) + nuevoPrecio) / contadorAutos;
    }

    public static double getPrecioPromedio() {
        return precioPromedio;
    }

    public static int getContadorAutos() {
        return contadorAutos;
    }
}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil auto1 = new Automovil("Toyota", "Corolla", "Blanco", 20000);
        Automovil auto2 = new Automovil("Honda", "Civic", "Rojo", 25000);
        Automovil auto3 = new Automovil("Ford", "Mustang", "Negro", 30000);

        System.out.println("Se han creado " + Automovil.getContadorAutos() + " autos.");
        System.out.println("El precio promedio de los autos es: $" + Automovil.getPrecioPromedio());

    }
}


