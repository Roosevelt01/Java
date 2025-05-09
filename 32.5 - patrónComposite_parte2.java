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
            sb.append(hijo.mostrar());
            if(hijo instanceof  Archivo){
                sb.append("\n");
            }

        }

        return sb.toString();
    }

    @Override
    public boolean buscar(String nombre) {
        if(this.nombre.equalsIgnoreCase(nombre)){
            return  true;
        }

        return hijos.stream().anyMatch(h -> h.buscar(nombre));
    }
}

//Main principal
package org.aguzman.patrones.ejeemplo;

import org.aguzman.patrones.composite.Archivo;
import org.aguzman.patrones.composite.Directorio;

public class ejemploComposite {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx"));
        doc.addComponente(new Archivo("logo.jpeg"));

        boolean encontrado = doc.buscar("patron-composite.docx");
        System.out.println("Encontrado \"patron-composite.docx\": "+encontrado);

        encontrado = doc.buscar("Api Stream");
        System.out.println("Encontrado Api Stream: " + encontrado);

        encontrado = doc.buscar("cv.docx");
        System.out.println("Encontrado cv.docx: " + encontrado);
    }
}

