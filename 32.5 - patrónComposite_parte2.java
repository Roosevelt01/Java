package org.aguzman.patrones.composite;

import java.util.Objects;

public abstract class Componente {
    protected  String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String mostrar();

    //Implementación de la búsqueda recursiva en la clase abstracta
    public abstract boolean buscar(String nombre);

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Componente that = (Componente) object;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}

//
package org.aguzman.patrones.composite;

public class Archivo extends Componente {
    public Archivo(String nombre) {
        super(nombre);
    }

    @Override
    public String mostrar() {
        return nombre;
    }

    @Override
    public boolean buscar(String nombre) {
        return this.nombre.equalsIgnoreCase(nombre);
    }
}


