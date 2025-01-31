//Clase Alumno
package Modelo;

import java.util.Comparator;

public class Alumno implements Comparable<Alumno> {
    private String nombre;
    private Integer nota;

    public Alumno() {
    }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "nombre = " + nombre +
                " nota = " + nota;
    }

    @Override
    public int compareTo(Alumno a) {
        if(this.nota == null){
            return 0;
        }
        return this.nota.compareTo(a.nota);
    }
}

//Clase EjemploTreeSetComparable(Main principal)
package Set;

import Modelo.Alumno;

import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        Set<Alumno> sa = new TreeSet<>((a, b) -> a.getNombre().compareTo(b.getNombre()));
        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Cata",6));
        sa.add(new Alumno("Luci",4));
        sa.add(new Alumno("Jano",7));
        sa.add(new Alumno("Andrés",3));
        sa.add(new Alumno("Zeus",2));

        System.out.println(sa);
    }
}

