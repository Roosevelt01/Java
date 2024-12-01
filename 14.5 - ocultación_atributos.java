public class Automovil {
    private String fabricante;

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}

public class EjemploAutomovil {
    public static void main(String[] args) {
        Automovil mazda = new Automovil();
        mazda.setFabricante("Mazda");

        System.out.println("Fabricante: " + mazda.getFabricante());

    }
}
