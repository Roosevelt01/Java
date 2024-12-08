//Persona
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

//Motor
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

//Rueda
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

