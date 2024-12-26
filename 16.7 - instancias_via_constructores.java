//Creando instancias vía constructores con argumentos y control de tipos
package org.aguzman.ejemplo;

import org.aguzman.pooherencia.*;

public class EjemploHerenciaConstructores {
    public static void main(String[] args) {
        System.out.println("======== Creando la instancia de la clase Alumno ======== ");
        Alumno alumno = new Alumno("Andrés","Guzman", 41);
        alumno.setNotaCastellano(6.5);
        alumno.setNotaHistoria(6.3);
        alumno.setNotaMatematica(4.9);
        alumno.setEmail("rodri297@gmail.com");

        System.out.println("======== Creando la instancia de la clase AlumnoInternacional ======== ");
        AlumnoIternacional alumnoInt = new AlumnoIternacional("Peter","Gosling","Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacioncal");
        alumnoInt.setNotaIdiomas(6.8);
        alumnoInt.setNotaCastellano(6.2);
        alumnoInt.setNotaHistoria(5.8);
        alumnoInt.setNotaMatematica(6.5);
        alumnoInt.setEmail("rodri297@gmail.com");

        System.out.println("======== Creando la instancia de la clase Profesor ======== ");
        Profesor profesor = new Profesor("Luci","Pérez","Matemáticas");
        profesor.setEdad(37);

        System.out.println("========= - =========");
        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);
    }

    public static void imprimir(Persona persona){
        System.out.println("Imprimiendo datos en común del tipo Persona");
        System.out.println("Nombre: " + persona.getNombre()
                + ", apellido: " + persona.getApellido()
                + ", edad: " + persona.getEdad()
                + ", email: " + persona.getEmail());

        if(persona instanceof Alumno){
            System.out.println("Imprimiendo los datos del tipo Profesor");
            System.out.println("Institución: "+((Alumno) persona).getInstitucion());
            System.out.println("Nota matemática: "+((Alumno) persona).getNotaMatematica());
            System.out.println("Nota Historia: "+((Alumno) persona).getNotaHistoria());
            System.out.println("Nota Castellano: "+((Alumno) persona).getNotaCastellano());

            if(persona instanceof AlumnoIternacional){
                System.out.println("Imprimiendo los datos del tipo AlumnoInternacional");
                System.out.println("Nota idiomas: "+((AlumnoIternacional) persona).getNotaIdiomas());
                System.out.println("País: "+((AlumnoIternacional) persona).getPais());
            }
        }

        if(persona instanceof Profesor){
            System.out.println("Imprimiendo los datos del tipo Profesor");
            System.out.println("Asignatura: "+((Profesor) persona).getAsignatura());
        }
    }
}
