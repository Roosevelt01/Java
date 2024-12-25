//Clase Alumno
package org.aguzman.pooherencia;

public class Alumno extends Persona{
    private String institucion;
    private double notaMatematica;
    private double notaCastellano;
    private double notaHistoria;

    public Alumno() {

    }

    public Alumno(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre, String apellido, int edad, String institucion) {
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion, double notaMatematica, double notaCastellano, double notaHistoria) {
        this(nombre, apellido, edad, institucion);
        this.notaMatematica = notaMatematica;
        this.notaCastellano = notaCastellano;
        this.notaHistoria = notaHistoria;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaCastellano() {
        return notaCastellano;
    }

    public void setNotaCastellano(double notaCastellano) {
        this.notaCastellano = notaCastellano;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }
}

//Clase Persona
package org.aguzman.pooherencia;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String email;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

// Clase Profesor
package org.aguzman.pooherencia;

public class Profesor extends Persona{
    private String asignatura;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}

//Clase AlumnoInternacional
package org.aguzman.pooherencia;

public class AlumnoIternacional extends Alumno{
    private String pais;
    private double notaIdiomas;

    public AlumnoIternacional(){
        
    }

    public AlumnoIternacional(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public AlumnoIternacional(String nombre, String apellido, String pais) {
        super(nombre, apellido);
        this.pais = pais;
    }

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

//Main Principal
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

        System.out.println(alumnoInt.getNombre()
            +" "+ alumnoInt.getApellido()
            +" "+ alumnoInt.getInstitucion()
            +" "+ alumnoInt.getPais());               ;

        System.out.println("Profesor: " + profesor.getAsignatura()
                        +": " + profesor.getNombre()
                        + ": " + profesor.getApellido());

    }
}
