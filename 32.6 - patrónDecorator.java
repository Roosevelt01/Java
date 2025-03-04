//
package org.aguzman.patrones.observer;

public interface Observer {
    void update(Observable observable);
}

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

//
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
}

//
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
}

