//Clase Usuario
package org.aguzman.api.stream.models;

import java.util.Objects;

public class Usuario {
    private String nombre, apellido;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', apellido='" + apellido + "'}";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}

//Main principal
package org.aguzman.api.stream;

import org.aguzman.api.stream.models.Usuario;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {
      
         //Temario - Distinct
         System.out.println("Ejemplo 1 - Distinct de la clase Usuario");      
         Stream<Usuario> nombres = Stream
                 .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                         "Pepe Mena", "Pepe Garcia", "Pato Guzman","Pato Guzman")
                 .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                 .distinct();
         nombres.forEach(System.out::println);

        //Temario - mapToInt
        System.out.println("Ejemplo 2 - mapToInt de la clase Usuario");
        IntStream largoNombres = Stream
                .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman","Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length());

        largoNombres.forEach(System.out::println);

        //Temario - SummatyStatisics
        System.out.println("Ejemplo 3 - SummatyStatisics");
        IntStream largoNombres = Stream
                .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                        "Pepe Mena", "Pepe Garcia", "Pato Guzman","Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Total: "+ stats.getSum());
        System.out.println("Max: "+ stats.getMax());
        System.out.println("Min: "+ stats.getMin());
        System.out.println("Promedio: "+ stats.getAverage());
      
    }
}
