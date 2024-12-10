package org.guzman.app;

import org.guzman.app.hogar.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.nombre = "Jose";
        System.out.println(p.nombre);
        Gato g = new Gato();
    }
}

//Clase Persona
package org.guzman.app.hogar;

public class Persona {
    public String nombre;
}

//Clase Gato
package org.guzman.app.hogar;

public class Gato {
}


