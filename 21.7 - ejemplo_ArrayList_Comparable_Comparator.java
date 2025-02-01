//1. Ejemplo con Comparable (Orden natural)
import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
    private String nombre;
    private Integer nota;

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }

    @Override
    public int compareTo(Alumno otro) {
        // Orden natural por nota (ascendente)
        return this.nota.compareTo(otro.nota);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}

//main principal del ejemplo #1
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjemploComparable {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pato", 5));
        alumnos.add(new Alumno("Cata", 6));
        alumnos.add(new Alumno("Luci", 4));
        alumnos.add(new Alumno("Jano", 7));
        alumnos.add(new Alumno("Andrés", 3));

        // Ordenar usando Comparable (por nota)
        System.out.println("Orden natural (por nota):");
        Collections.sort(alumnos); // Usa compareTo de Alumno
        alumnos.forEach(System.out::println);

        //Imprime
        //Orden natural (por nota):
        //Alumno{nombre='Andrés', nota=3}
        //Alumno{nombre='Luci', nota=4}
        //Alumno{nombre='Pato', nota=5}
        //Alumno{nombre='Cata', nota=6}
        //Alumno{nombre='Jano', nota=7}
    }
}

//2. Ejemplo con Comparator (Orden personalizado)
import java.util.Comparator;

public class ComparadorNombre implements Comparator<Alumno> {
    @Override
    public int compare(Alumno a1, Alumno a2) {
        // Orden alfabético por nombre
        return a1.getNombre().compareTo(a2.getNombre());
    }
}

//main prinpricipal del ejemplo #2
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjemploComparator {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pato", 5));
        alumnos.add(new Alumno("Cata", 6));
        alumnos.add(new Alumno("Luci", 4));
        alumnos.add(new Alumno("Jano", 7));
        alumnos.add(new Alumno("Andrés", 3));

        // Ordenar usando Comparator (por nombre)
        System.out.println("Orden personalizado (por nombre):");
        Collections.sort(alumnos, new ComparadorNombre()); // Usa ComparadorNombre
        alumnos.forEach(System.out::println);

        //Imprime
        //Orden personalizado (por nombre):
        //Alumno{nombre='Andrés', nota=3}
        //Alumno{nombre='Cata', nota=6}
        //Alumno{nombre='Jano', nota=7}
        //Alumno{nombre='Luci', nota=4}
        //Alumno{nombre='Pato', nota=5}
    }
}

//3. Ejemplo con Comparator y lambdas (Java 8+)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjemploLambda {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pato", 5));
        alumnos.add(new Alumno("Cata", 6));
        alumnos.add(new Alumno("Luci", 4));
        alumnos.add(new Alumno("Jano", 7));
        alumnos.add(new Alumno("Andrés", 3));

        // Ordenar usando lambda (por nombre)
        System.out.println("Orden usando lambda (por nombre):");
        Collections.sort(alumnos, (a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
        alumnos.forEach(System.out::println);

      //Imprime
      //Orden usando lambda (por nombre):
      //Alumno{nombre='Andrés', nota=3}
      //Alumno{nombre='Cata', nota=6}
      //Alumno{nombre='Jano', nota=7}
      //Alumno{nombre='Luci', nota=4}
      //Alumno{nombre='Pato', nota=5}
    }
}

//Ejemplo con Comparator.comparing (Java 8+)
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EjemploComparing {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pato", 5));
        alumnos.add(new Alumno("Cata", 6));
        alumnos.add(new Alumno("Luci", 4));
        alumnos.add(new Alumno("Jano", 7));
        alumnos.add(new Alumno("Andrés", 3));

        // Ordenar usando Comparator.comparing (por nombre)
        System.out.println("Orden usando Comparator.comparing (por nombre):");
        alumnos.sort(Comparator.comparing(Alumno::getNombre));
        alumnos.forEach(System.out::println);

      //Imprime
      //Orden usando Comparator.comparing (por nombre):
      //Alumno{nombre='Andrés', nota=3}
      //Alumno{nombre='Cata', nota=6}
      //Alumno{nombre='Jano', nota=7}
      //Alumno{nombre='Luci', nota=4}
      //Alumno{nombre='Pato', nota=5}
    }
}
