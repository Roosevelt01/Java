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

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente{
    private List<Componente> hijos;

    public Directorio(String nombre) {
        super(nombre);
        this.hijos=new ArrayList<>();
    }

    public Directorio addComponente(Componente c){
        hijos.add(c);
        return this;
    }

    public void  removeComponente(Componente c){
        hijos.remove(c);
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre)
                .append("/")
                .append("\n");

        for(Componente hijo: this.hijos){
            sb.append(hijo.mostrar())
                    .append("\n");
        }

        return sb.toString();
    }


}
