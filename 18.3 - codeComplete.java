/*src/
  org/
    aguzman/
      poointerfaces/
        imprenta/
          modelo/
            Curriculo.java
            Genero.java
            Hoja.java
            Imprimible.java
            Informe.java
            Libro.java
            Pagina.java
            Persona.java
          EjemploImprenta.java */



//Main principal
package org.aguzman.poointerfaces.imprenta;

import org.aguzman.poointerfaces.imprenta.modelo.*;
import static org.aguzman.poointerfaces.imprenta.modelo.Genero.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo(new Persona("John","Doe"),
                "Ingeniero de sistemas", "Resumen Laboral...");
        cv.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Desarrolador Fullstack")
                .addExperiencia("Angula");

        Libro libro = new Libro(new Persona("Eric",  "Gamma"),
                "Patrones de diseños: Elem. Reusables por POO", PROGRAMACION);
        libro.addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Factory"))
                .addPagina(new Pagina("Patrón Composite"))
                .addPagina(new Pagina("Patrón Facade"));


        Informe informe = new Informe(new Persona("Martin"," Fewler"),new Persona("James", "Gosling"),
                "Estudio sobre microservicio");
        
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}

//Imprimible.java
package org.aguzman.poointerfaces.imprenta.modelo;

public interface Imprimible {
    String imprimir();
}

//Enum
package org.aguzman.poointerfaces.imprenta.modelo;

public enum Genero {
    DRAMA,
    ACCION,
    TERROR,
    CIENCIAS_FICCION,
    PROGRAMACION
}

//Clase Padre(Hoja)
package org.aguzman.poointerfaces.imprenta.modelo;

public abstract class Hoja {
    protected String contenido;

    public Hoja(String contenido) {
        this.contenido = contenido;
    }

    public abstract String imprimir();
}

//Clase hija(Informe)
package org.aguzman.poointerfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible{
    private final Persona autor;
    private final Persona revisor;


    public Informe(Persona autor, Persona revisor, String contenido) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {
        return "Informe escrito por: " + autor
                + "\nRevisado por: " + revisor
                + "\nContenido: " + this.contenido;
    }
}

//Clase hija(Curriculum)
package org.aguzman.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Imprimible{
    private final Persona persona;
    private final String carrera;
    private final List<String> experiencias;

    public Curriculo(Persona persona, String carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencia(String exp){
        experiencias.add(exp);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ");
        sb.append(persona).append("\n")
                .append("Resumen: ").append(this.contenido)
                .append("\n").append("Profesión: ")
                .append(this.carrera).append("\n")
                .append("Experiencia: \n");
        for(String exp: this.experiencias){
            sb.append("- ").append(exp).append("\n");
        }
        return sb.toString();
    }
}

//Clase hija(Pagina)
package org.aguzman.poointerfaces.imprenta.modelo;

public class Pagina extends Hoja implements Imprimible{

    public Pagina(String contenido) {
        super(contenido);
    }

    @Override
    public String imprimir() {
        return this.contenido;
    }
}

//Clase que implemente imprimible, no hereda de la clase padre
package org.aguzman.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Imprimible{
    private List<Imprimible> paginas;
    private Persona autor;
    private String titulo;
    private Genero genero;

    public Libro(Persona autor, String titulo, Genero genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = new ArrayList<>();
    }

    public Libro addPagina(Imprimible pagina){
        paginas.add(pagina);
        return this;
    }

    @Override
    public String imprimir(){
        StringBuilder sb = new StringBuilder("Título: ");
        sb.append(this.titulo).append("\n")
                .append("Autor: ").append(this.autor).append("\n")
                .append("Genero: ").append(this.genero).append("\n");
        for(Imprimible pag: this.paginas){
            sb.append(pag.imprimir()).append("\n");
        }
        return sb.toString();
    }
}

//Clase Persona, se usa para optimizar el código
package org.aguzman.poointerfaces.imprenta.modelo;

public class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}


