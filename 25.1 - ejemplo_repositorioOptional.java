//Clase Computador
package org.aguzman.optional.ejemplo.models;

public class Computador {
    private String nombre, modelo;

    public Computador(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return nombre + " | " + modelo;
    }
}

//Interface
package org.aguzman.optional.ejemplo.repositorio;

import org.aguzman.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T>{

    Optional<Computador> filtrar(String nombre);

}


//Clase ComputadorRepositorio
package org.aguzman.optional.ejemplo.repositorio;

import org.aguzman.optional.ejemplo.models.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computador("Asus ROG","Strix 6512"));
        dataSource.add(new Computador("MacBook Pro","MVVK2CI"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
       return dataSource.stream()
               .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
               .findFirst();

        /*for(Computador c: dataSource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }

        return Optional.empty();*/
    }
}

//Main Principal
package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorio {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("asus rog").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontró"));

    }
}
