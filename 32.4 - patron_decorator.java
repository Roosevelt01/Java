//Interface Formatable
package decorator;

public interface Formateable {
    String darFormato();
}

//Clase texto
package decorator;

public class Texto implements Formateable{
    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String darFormato() {
        return getTexto();
    }
}

//Clase TextoDecorador
package decorator.decorador;

import decorator.Formateable;

public abstract class TextoDecorador implements Formateable {
    protected Formateable texto;

        public TextoDecorador(Formateable texto) {
            this.texto = texto;
        }
}

//MayusculaDecorador
package decorator.decorador;

import decorator.Formateable;

public class MayusculaDecorador extends TextoDecorador {
    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}

//MayusculaDecorator
package decorator.decorador;

import decorator.Formateable;

public class MayusculaDecorador extends TextoDecorador {
    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase();
    }
}

//Clase ReversaDecorador
package decorator.decorador;

import decorator.Formateable;

public class ReversaDecorador extends TextoDecorador{
    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        StringBuilder sb = new StringBuilder(texto.darFormato());
        return sb.reverse().toString();
    }
}

//Clase RemplazarEspaciosDecorador
package decorator.decorador;

import decorator.Formateable;

public class RemplazarEspaciosDecorador extends TextoDecorador{
    public RemplazarEspaciosDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ","_");
    }
}

//Clase RemplazarEspaciosDecorador
package decorator.decorador;

import decorator.Formateable;

public class SubrayadoDecorador extends TextoDecorador{
    public SubrayadoDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        int largo = texto.darFormato().length();
        StringBuilder sb = new StringBuilder(texto.darFormato());
        sb.append("\n");
        for (int i = 0; i < largo;i++){
            sb.append("_");
        }
        return sb.toString();
    }
}

//Clase SubrayadoDecorador
package decorator.decorador;

import decorator.Formateable;

public class SubrayadoDecorador extends TextoDecorador{
    public SubrayadoDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        int largo = texto.darFormato().length();
        StringBuilder sb = new StringBuilder(texto.darFormato());
        sb.append("\n");
        for (int i = 0; i < largo;i++){
            sb.append("_");
        }
        return sb.toString();
    }
}

//Main principal
package decorator.decorador;

import decorator.Formateable;
import decorator.Texto;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Andrés!");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayar = new SubrayadoDecorador(reversa);
        RemplazarEspaciosDecorador remplazar = new RemplazarEspaciosDecorador(subrayar);

        System.out.println(subrayar.darFormato());
    }
}
