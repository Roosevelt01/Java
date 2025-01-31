package Set;

import Modelo.Alumno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();
        sa.add(new Alumno("Pato",5));
        sa.add(new Alumno("Cata",6));
        sa.add(new Alumno("Luci",4));
        sa.add(new Alumno("Jano",7));
        sa.add(new Alumno("Andrés",3));
        sa.add(new Alumno("Zeus",2));
        sa.add(new Alumno("Zeus",2));

        System.out.println("Iterando usando el foreach");
        for(Alumno a: sa){
            System.out.println(a);
        }

        System.out.println("Iterando usando while y iterator");
        Iterator<Alumno> it = sa.iterator();
        while(it.hasNext()){
            Alumno a = it.next();
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando usando Stream foreach");
        sa.forEach(System.out::println);
    }
}
