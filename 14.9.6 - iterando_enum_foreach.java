public enum Color {
    ROJO("#FF0000"),
    VERDE("#00FF00"),
    AZUL("#0000FF");

    private final String codigoHexadecimal;

    Color(String codigoHexadecimal) {
        this.codigoHexadecimal = codigoHexadecimal;
    }

    public String getCodigoHexadecimal() {
        return codigoHexadecimal;
    }

    // Método para verificar si un color es primario
    public boolean esPrimario() {
        return this == ROJO || this == VERDE || this == AZUL;
    }
}

public class Automovil {
    private String marca;
    private Color color;
    private int modelo;

    public Automovil(String marca, Color color, int modelo) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Color getColor() {
        return color;
    }

    public int getModelo() {
        return modelo;
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Color: " + color);
        System.out.println("Modelo: " + modelo);
    }
}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil am1 = new Automovil("Ferrari", Color.AZUL, 195);

        Automovil am2 = new Automovil("Ferrari", Color.VERDE, 10);

        Color [] cl = Color.values();

        for(Color c : cl){
            System.out.println(c.getCodigoHexadecimal()+ " - " + c.esPrimario());
        }

    }
}

