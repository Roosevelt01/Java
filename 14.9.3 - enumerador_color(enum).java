public enum Genero {
    MASCULINO, FEMENINO, OTRO
}

//
public class Persona {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final Genero genero;

    public Persona(String nombre, String apellido, int edad, Genero genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAppellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }
}

//
public class EjemploPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Jeison", "Rodríguez", 15, Genero.MASCULINO);

        System.out.println(persona1.getNombre() + " es de género: " + persona1.getGenero());
    }
}
