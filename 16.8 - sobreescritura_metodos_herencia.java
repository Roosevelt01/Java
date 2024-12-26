//Clase Alumno
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

    //Méotodo de sobreescritura
    public String saludar(){
        return "Hola que tal!";
    }
}

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
  
    //Sobreescritura del método
    @Override
    public String saludar(){
        String saluda = super.saludar();
        return saluda + " soy un alumno y mi nombre es "+getNombre();
    }

    //Sobreescritura del método
    public double calcularPromedio(){
        return (notaHistoria + notaCastellano + notaMatematica)/3;
    }

}

//Clase Alumno Internacional
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

   //Sobreescritura del método
    @Override
    public String saludar() {
        return super.saludar() + ", soy un alumno extranjero del país " +getPais()
                + " mi nombre " + getNombre();
    }

    //Sobreescritura del método
    @Override
    public double calcularPromedio() {
        return ((super.calcularPromedio()*3) + notaIdiomas)/4;
    }
}

//Clase Profesor
package org.aguzman.pooherencia;

public class Profesor extends Persona{
    private String asignatura;

    public Profesor() {}

    public Profesor(String nombre, String apellido, String asignatura) {
        super(nombre, apellido);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    //Sobreescritura del método
    @Override
    public String saludar() {
        return "Buenos días soy el profesor de "
                + getAsignatura() + ", mi nombre es "
                + getNombre();
    }
}

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
            //Llamando el método de sobreescritura del método calcularPromedio
            System.out.println("=================== sobreescritura promedio ===================");
            System.out.println("Promedio: "+ ((Alumno) persona).calcularPromedio());
            System.out.println("==============================================================");

        }

        if(persona instanceof Profesor){
            System.out.println("Imprimiendo los datos del tipo Profesor");
            System.out.println("Asignatura: "+((Profesor) persona).getAsignatura());
        }

        //Llamando el método de sobreescritura del método saludar
        System.out.println("=================== sobreescritura saludar ===================");
        System.out.println(persona.saludar());
        System.out.println("==============================================================");
    }
}


//Main Principal
