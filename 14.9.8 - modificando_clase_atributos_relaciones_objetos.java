
public class EjemploAutomovil {
    public static void main(String[] args) {
        //Motor
        Motor motormazda = new Motor(3.0, TipoMotor.DIESEL);
        //Rueda       
        Rueda[] ruedasMazda = new Rueda[1];
        ruedasMazda[0] = new Rueda(205, 16, "Michelin");
        ruedasMazda[0] = new Rueda(205, 16, "Michelin");
        ruedasMazda[1] = new Rueda(205, 16, "Bridgestone"); 
        ruedasMazda[2] = new Rueda(205, 16, "Continental");  
        ruedasMazda[3] = new Rueda(205, 16, "Pirelli");
        //Persona
        Persona conductor = new Persona("Fernando Palomo", "Palomo");

        Automovil mazda = new Automovil(conductor, new Estanque(80), motormazda, ruedasMazda);

        System.out.println("Información del Mazda:");
        System.out.println("Conductor: " + mazda.getConductor());
        System.out.println("Motor:");
        System.out.println("  Cilindrada: " + mazda.getMotor().getCilindrada() + " litros");
        System.out.println("  Tipo: " + mazda.getMotor().getTipo());
        System.out.println("Estanque: " + mazda.getEstanque().getCapacidad() + " litros");
        System.out.println("Ruedas:");
        for(Rueda rueda : ruedasMazda) {
            System.out.println("  - Ancho: " + rueda.getAncho() + ", Aro: " + rueda.getAro() + ", Fabricante: " + rueda.getFabricante());
        }
    }
}

//Automovil
import java.util.Arrays;

public class Automovil {
   private Motor motor;
   private Estanque estanque;
   private Persona conductor;
   private Rueda[] rueda;

    public Automovil() {
    }

    public Automovil(Persona conductor) {
        this.conductor = conductor;
    }

    public Automovil(Persona conductor, Estanque estanque) {
        this(conductor);
        this.estanque = estanque;
    }

    public Automovil(Persona conductor, Estanque estanque, Motor motor, Rueda[] rueda) {
        this(conductor, estanque);
        this.motor = motor;
        this.rueda = rueda;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Estanque getEstanque() {
        return estanque;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Rueda[] getRueda() {
        return rueda;
    }

    public void setRueda(Rueda[] rueda) {
        this.rueda = rueda;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "conductor=" + conductor +
                ", motor=" + motor +
                ", estanque=" + estanque +
                ", rueda=" + Arrays.toString(rueda) +
                '}';
    }
}


//Clase Persona
public class Persona {
    private String nombre;
    private String apellido;

    public Persona(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

//Clase Motor
public class Motor {
    private double cilindrada;
    private TipoMotor tipo;

    public Motor() {
    }

    public Motor(double cilindrada, TipoMotor tipo) {
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }
}

//Estanque
public class Estanque {
    private int capacidad;

    public Estanque() {
        this.capacidad = 40;
    }

    public Estanque(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}

//Estanque
public class Rueda {
    private String fabricante;
    private int aro;
    private double ancho;

    public Rueda(double ancho, int aro, String fabricante) {
        this.ancho = ancho;
        this.aro = aro;
        this.fabricante = fabricante;
    }

    public double getAncho() {
        return ancho;
    }

    public int getAro() {
        return aro;
    }

    public String getFabricante() {
        return fabricante;
    }
}

//TipoMotor
public enum TipoMotor {
    DIESEL, BENCINA
}



