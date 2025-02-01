//Clase Alumno
package Modelo;

import java.util.Comparator;
import java.util.Objects;

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
        if(this.nombre == null){
            return 0;
        }
        return this.nombre.compareTo(a.nombre);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Alumno alumno = (Alumno) object;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}

//Clase Alumno
package Set;


import Modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1 - GetFirst() y GetLast()");
        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada+", size = "+ enlazada.size());
        System.out.println("Está vacía = "+ enlazada.isEmpty());
        enlazada.add(new Alumno("Pato",5));
        enlazada.add(new Alumno("Cata",6));
        enlazada.add(new Alumno("Luci",4));
        enlazada.add(new Alumno("Jano",7));
        enlazada.add(new Alumno("Andrés",3));

        System.out.println(enlazada+ ", size = "+enlazada.size());

        enlazada.addFirst(new Alumno("Zeus",5));
        enlazada.addFirst(new Alumno("Atenia",6));
        System.out.println(enlazada+ ", size = "+enlazada.size());

        System.out.println("\nPrimero: "+enlazada.getFirst());
        System.out.println("Último: "+enlazada.getLast());
        System.out.println("Índice 2: "+enlazada.get(2));

        System.out.println("Ejemplo #2 - peekFirst() y peekLast()");
        LinkedList<Alumno> enlazada2 = new LinkedList<>();
        System.out.println(enlazada2 +", size = "+ enlazada2.size());
        System.out.println("Está vacía = "+ enlazada2.isEmpty());
        enlazada2.add(new Alumno("Pato",5));
        enlazada2.add(new Alumno("Cata",6));
        enlazada2.add(new Alumno("Luci",4));
        enlazada2.add(new Alumno("Jano",7));
        enlazada2.add(new Alumno("Andrés",3));

        System.out.println(enlazada2 + ", size = "+ enlazada2.size());

        enlazada2.addFirst(new Alumno("Zeus",5));
        enlazada2.addFirst(new Alumno("Atenia",6));
        System.out.println(enlazada2 + ", size = "+ enlazada2.size());

        System.out.println("\nPrimero: "+ enlazada2.peekFirst());
        System.out.println("Último: "+ enlazada2.peekLast());
        System.out.println("Índice 2: "+ enlazada2.get(2));

        System.out.println("\nEjemplo #3 - removeFirst() y removeLast()");
        LinkedList<Alumno> enlazada3 = new LinkedList<>();
        System.out.println(enlazada3 +", size = "+ enlazada3.size());
        System.out.println("Está vacía = "+ enlazada3.isEmpty());
        enlazada3.add(new Alumno("Pato",5));
        enlazada3.add(new Alumno("Cata",6));
        enlazada3.add(new Alumno("Luci",4));
        enlazada3.add(new Alumno("Jano",7));
        enlazada3.add(new Alumno("Andrés",3));

        System.out.println(enlazada3 + ", size = "+ enlazada3.size());

        enlazada3.removeFirst();
        enlazada3.removeLast();
        System.out.println(enlazada3 + ", size = "+ enlazada3.size());

        System.out.println("\nEjemplo #4");
        LinkedList<Alumno> enlazada4 = new LinkedList<>();
        System.out.println(enlazada4 +", size = "+ enlazada4.size());
        System.out.println("Está vacía = "+ enlazada4.isEmpty());
        enlazada4.add(new Alumno("Pato",5));
        enlazada4.add(new Alumno("Cata",6));
        enlazada4.add(new Alumno("Luci",4));
        enlazada4.add(new Alumno("Jano",7));
        enlazada4.add(new Alumno("Andrés",3));

        System.out.println(enlazada4 + ", size = "+ enlazada4.size());

        enlazada4.pollFirst();
        enlazada4.pollLast();
        System.out.println(enlazada4 + ", size = "+ enlazada4.size());

        System.out.println("\nEjemplo #5 - pop");
        LinkedList<Alumno> enlazada5 = new LinkedList<>();
        System.out.println(enlazada5 +", size = "+ enlazada5.size());
        System.out.println("Está vacía = "+ enlazada5.isEmpty());
        enlazada5.add(new Alumno("Pato",5));
        enlazada5.add(new Alumno("Cata",6));
        enlazada5.add(new Alumno("Luci",4));
        enlazada5.add(new Alumno("Jano",7));
        enlazada5.add(new Alumno("Andrés",3));

        System.out.println(enlazada5 + ", size = "+ enlazada5.size());

        enlazada5.pop();
        System.out.println(enlazada5 + ", size = "+ enlazada5.size());

        System.out.println("\nEjemplo #6 - addLast");
        LinkedList<Alumno> enlazada6 = new LinkedList<>();
        System.out.println(enlazada6 +", size = "+ enlazada6.size());
        System.out.println("Está vacía = "+ enlazada6.isEmpty());
        enlazada6.add(new Alumno("Pato",5));
        enlazada6.add(new Alumno("Cata",6));
        enlazada6.add(new Alumno("Luci",4));
        enlazada6.add(new Alumno("Jano",7));
        enlazada6.add(new Alumno("Andrés",3));

        System.out.println(enlazada6 + ", size = "+ enlazada6.size());

        Alumno a = new Alumno("Lucas", 5);
        enlazada6.addLast(a);
        System.out.println(enlazada6 + ", size = "+ enlazada6.size());

        
    }
}
