package org.aguzman.pooherencia;

public class AlumnoIternacional extends Alumno{
    private String pais;
    private double notaIdiomas;

    public double getNotaIdiomas() {
        return notaIdiomas;
    }

    public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

package org.aguzman.ejemplo;

import org.aguzman.pooherencia.Alumno;
import org.aguzman.pooherencia.AlumnoIternacional;
import org.aguzman.pooherencia.Profesor;

public class EjemploHerencia {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setNombre("Andrés");
        alumno.setApellido("Guzmán");

        Profesor profesor = new Profesor();
        profesor.setNombre("Luci");
        profesor.setApellido("Pérez");
        profesor.setAsignatura("Matemática");
        
        /*Code new*/
        AlumnoIternacional alumnoInt = new AlumnoIternacional();
        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Gosling");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);

        /*Code new*/
        Class clase = alumnoInt.getClass();
        while (clase != null) {
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();
        }

        System.out.println(alumno.getNombre()
                +" "+ alumno.getApellido()
                +" "+ alumno.getInstitucion());

        /*Code new*/
        System.out.println(alumnoInt.getNombre()
            +" "+ alumnoInt.getApellido()
            +" "+ alumnoInt.getInstitucion()
            +" "+ alumnoInt.getPais());               ;

        System.out.println("Profesor: " + profesor.getAsignatura()
                        +": " + profesor.getNombre()
                        + ": " + profesor.getApellido());

    }
}
