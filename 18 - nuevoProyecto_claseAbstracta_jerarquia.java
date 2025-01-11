//Main principal
package org.aguzman.poointerfaces.imprenta;

public class EjemploImprenta {
    public static void main(String[] args) {

    }
}

//Clase padre(Hoja)
package org.aguzman.poointerfaces.imprenta.modelo;

public abstract class Hoja {
    protected String contenido;

    public Hoja(String contenido) {
        this.contenido = contenido;
    }

    public abstract String imprimir();
}

//Clase Hija(Informe) que heredera de la clase Padre(Hoja)
package org.aguzman.poointerfaces.imprenta.modelo;

public class Informe extends Hoja{
    private String autor, revisor;


    public Informe(String autor, String revisor, String contenido) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {
        return "Informe escrito por: " + autor
                + "Revisado por: " + revisor
                + "\n" + this.contenido;
    }
}
