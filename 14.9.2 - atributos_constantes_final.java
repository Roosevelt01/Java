public class Persona {
    private final String nombre;
    private final String apellido;
    private final int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }
}

public class EjemploPersona {
    public static void main(String[] args) {
        Persona p1 = new Automovil("Jeison","Rodríguez",15);

        System.out.println(p1.getNombre());
    }
}
