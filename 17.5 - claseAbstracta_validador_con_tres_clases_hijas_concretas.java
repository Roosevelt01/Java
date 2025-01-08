//Paquete Validador

//Clase Padre(Validador)
package org.aguzman.pooclasesabstractas.form.validador;

public abstract class Validador {
    protected String mensaje;
    abstract public void setMensaje(String mensaje);
    abstract public String getMensaje();
    abstract public boolean esValido(String valor);
}

//Clase hija(NoNuloValidador) heredado de la clase Padre(Validador)
package org.aguzman.pooclasesabstractas.form.validador;

public class NoNuloValidador extends Validador{
    protected  String mensaje = "el campo no puede ser nulo";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor !=null);
    }
}

//Clase hija(RequeridoValidador) heredado de la clase Padre(Validador)
package org.aguzman.pooclasesabstractas.form.validador;

public class RequeridoValidador extends Validador{
    protected String mensaje = "el campo es requirido";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor != null && valor.length() > 0);
    }
}

//Clase hija(NumeroValidador) heredado de la clase Padre(Validador)
package org.aguzman.pooclasesabstractas.form.validador;

public class NumeroValidador extends Validador{
    protected String mensaje = "El campo debe ser número";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje=mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


/*
Estructura de la carpeta

src/
  org/
    aguzman/
      pooclasesabstractas/
        form/
          elementos/
            select/
              ElementoForm.java
              InputForm.java
              SelectForm.java
              TextareaForm.java
          validador/
            NoNuloValidador.java
            NumeroValidador.java
            RequeridoValidador.java
            Validador.java
          EjemploForm.java
*/

