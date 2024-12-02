public class Automovil {
    private String fabricante;
    private String modelo;

    public Automovil() {

    }

    public Automovil(String fabricante, String modelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }
}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil mazda = new Automovil("Mazda","BT-S8");

        System.out.println("Fabrica de Automovil: " + mazda.getFabricante());
        System.out.println("Fabrica de Modelo: " + mazda.getModelo());
    }
}
