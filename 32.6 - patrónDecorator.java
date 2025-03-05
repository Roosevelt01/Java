//Clase Observer (Observador)
package org.aguzman.patrones.observer;

public interface Observer {
    void update(Observable observable);
}

//Clase Observable (Sujeto):
package org.aguzman.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(){
        for(Observer obs: this.observers){
            obs.update(this);
        }
    }
}

//Clase Coporacion (Sujeto Concreto):
package org.aguzman.patrones.observer;

public class Coporacion extends Observable{
    private String nombre;
    private int precio;

    public Coporacion(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void modificarPrecio(int precio){
        this.precio = precio;
        notifyObserver();
    }

    @Override
    public String toString() {
        return getNombre() +
                " nuevo precio $" +
                getPrecio();
    }
}

//Clase EjemploObserver (Observadores Anónimos)
package org.aguzman.patrones.observer.Ejemplo;

import org.aguzman.patrones.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver(observable -> {
            System.out.println("John: "+observable);
        });

        google.addObserver(observable -> {
            System.out.println("Andrés: "+ observable);
        });

        google.addObserver(observable -> {
            System.out.println("María: " + observable);
        });

        google.modificarPrecio(2000);
    }
}

//Segundo ejemplo

package org.aguzman.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio  extends Observable {
    private List<String> repositorio = new ArrayList<>();

    public void crearUsuario(String usuario){
        repositorio.add(usuario);
        notifyObserver();
    }
}

//
package org.aguzman.patrones.observer.Ejemplo;

import org.aguzman.patrones.observer.Corporacion;
import org.aguzman.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();

        repo.addObserver(o -> System.out.println("Enviando un email al usuario"));
        repo.addObserver(o -> System.out.println("Enviando un email al administrador"));
        repo.addObserver(o -> System.out.println("Guardando info del usuario en el logs"));

        repo.crearUsuario("Andrés");
    }
}

