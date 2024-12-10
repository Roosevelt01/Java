//Package hogar

package org.guzman.app.jardin;

import org.guzman.app.hogar.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Andrés");
        System.out.println("Nombre: " + p.getNombre());

        Perro perro = new Perro();
        String jugando = perro.jugar(p);
        System.out.println("Jugando: " + jugando);

    }
}

package org.guzman.app.hogar;

class Gato {
}

package org.guzman.app.hogar;

public class Persona {
    public String nombre;
    public String apellido;

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

    public String lanzarPelotar(){
        return "lanza pelotas";
    }
}

// Package jardín
package org.guzman.app.jardin;

import org.guzman.app.hogar.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("Andrés");
        System.out.println("Nombre: " + p.getNombre());

    }
}

package org.guzman.app.jardin;

import org.guzman.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar(Persona persona) {
        return persona.lanzarPelotar();
    }
}
