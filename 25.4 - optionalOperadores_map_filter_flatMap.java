//Clase Fabricate
package org.aguzman.optional.ejemplo.models;

public class Fabricante {
    private String nombre;

    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

//Clase computador
package org.aguzman.optional.ejemplo.models;

public class Computador {
    private String nombre, modelo;
    private Procesador procesador;

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

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return nombre + " | " + modelo;
    }
}

//Clase Procesador
package org.aguzman.optional.ejemplo.models;

public class Procesador {
    private String nombre;
    private  Fabricante fabricante;

    public Procesador(String nombre, Fabricante fabricante) {
        this.nombre = nombre;
        this.fabricante = fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}

//Inteface Repositorio
package org.aguzman.optional.ejemplo.repositorio;

import org.aguzman.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T>{

    Optional<Computador> filtrar(String nombre);

}

//ComputadorRepositorio
package org.aguzman.optional.ejemplo.repositorio;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.models.Fabricante;
import org.aguzman.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix 6512");
        asus.setProcesador(proc);
        dataSource.add(asus);
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

//Método main principal(EjemploRepositorioMapFilter)
package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.models.Fabricante;
import org.aguzman.optional.ejemplo.models.Procesador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1");
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        String f = repositorio.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .map(Fabricante::getNombre)
                .orElseThrow();

        System.out.println(f);

        System.out.println("\nEjemplo #2");

        Repositorio<Computador> repositorio2 = new ComputadorRepositorio();

        String f2 = repositorio.filtrar("macbook")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println(f2);

        System.out.println("\nEjemplo #3");

        Repositorio<Computador> repositorio3 = new ComputadorRepositorio();

        String f3 = repositorio.filtrar("macbook")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .filter(fab -> "Intel".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println(f3);


    }
}



