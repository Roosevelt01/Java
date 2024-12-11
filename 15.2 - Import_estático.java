//Paquete hogar(ColorPelo, EjemploHogar, Gato y Persona)

//Ejemplohogar
package org.guzman.app.hogar;

import org.guzman.app.jardin.Perro;
import static org.guzman.app.hogar.Persona.saludar;

public class EjemploHogar {
    public static void main(String[] args) {
        Persona p = new Persona();

        Perro perro = new Perro();
        String saludo = saludar();
    }
}

//Persona
package org.guzman.app.hogar;

public class Persona {
    private String nombre;
    private String apellido;
    private ColorPelo colorPelo;

    public static final String GENERO_MASCULINO = "Masculino";
    public static final String GENERO_FEMININO = "Feminino";

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ColorPelo getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(ColorPelo colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String lanzarPelotar(){
        return "lanza pelotas";
    }

    public static String saludar(){
        return "Hola que tal!";
    }
}


//Gato
package org.guzman.app.hogar;

class Gato {
}


//ColorPelo
package org.guzman.app.hogar;

public enum ColorPelo {
    NEGRO, CAFE, CASTANIO, RUBIO, COLORIN
}

//Paquete jardin(EjemploPaquetes y Perro)

//Ejemplohogar
package org.guzman.app.jardin;

import org.guzman.app.hogar.*;

import static org.guzman.app.hogar.Persona.*;


public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Andrés");
        System.out.println("Nombre: " + p.getNombre());
        p.setColorPelo(ColorPelo.CASTANIO);

        Perro perro = new Perro();
        String jugando = perro.jugar(p);
        System.out.println("Jugando: " + jugando);
        String saludo = saludar();
        System.out.println("Saludo: " + saludo);
        String generoMujer = GENERO_FEMININO;
        String generoHombre = GENERO_MASCULINO;
    }
}


//Ejemplohogar
package org.guzman.app.jardin;

import org.guzman.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar(Persona persona) {
        return persona.lanzarPelotar();
    }
}


