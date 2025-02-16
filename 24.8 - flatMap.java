//Clase Usuario
package org.aguzman.api.stream.models;

import java.util.Objects;

public class Usuario {
    private String nombre, apellido;
    private Integer id;
    private static int ultimoId;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

                Stream<Usuario> nombres = Stream
                    .of("Pato Guzman","Paco Gonzales","Pepa Gutierrez",
                            "Pepe Mena", "Pepe Garcia")
                    .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                    .flatMap(u ->{
                      if(u.getNombre().equalsIgnoreCase("Pepe")){
                          return Stream.of(u);
                      } 
                      return Stream.empty();
                    })
                        .peek(System.out::println);

                System.out.println(nombres.count());
        }
}
