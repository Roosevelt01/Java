//Interface 
package decorator;

public interface Configurable {
    float getPrecioBase();
    String getIngredientes();
}

//Clase Cafe
package decorator;

public class Cafe implements Configurable{
    private float precio;
    private String nombre;

    public Cafe(float precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    @Override
    public float getPrecioBase() {
        return this.precio;
    }

    @Override
    public String getIngredientes() {
        return this.nombre;
    }
}

//
package decorator.decorador;

import decorator.Configurable;

public abstract class CafeDecorador implements Configurable {
    protected Configurable cafe;

    public CafeDecorador(Configurable cafe) {
        this.cafe = cafe;
    }
}

//
package decorator.decorador;

import decorator.Cafe;
import decorator.Configurable;

public class ConChocolateDecorador extends CafeDecorador {

    public ConChocolateDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 5f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Chocolate";
    }
}

//
package decorator.decorador;

import decorator.Configurable;

public class ConCremaDecorador extends CafeDecorador{
    public ConCremaDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 2.5f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Crema";
    }
}

//
package decorator.decorador;

import decorator.Configurable;

public class LecheConDecorador extends CafeDecorador {
    public LecheConDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 3.7f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Leche";
    }
}

//Main Principal
package decorator.decorador;

import decorator.Cafe;
import decorator.Configurable;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(7, "Cafe Mocha");
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        LecheConDecorador conLeche = new LecheConDecorador(conCrema);
        ConChocolateDecorador conChoco = new ConChocolateDecorador(conLeche);

        System.out.println("El precio del café mosca es: " + conChoco.getPrecioBase());
        System.out.println("Los ingredientes del café mosca es: " + conChoco.getIngredientes());

        Configurable capuchino = new Cafe(4, "Cafe Capuchino");
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new LecheConDecorador(conCrema);
        System.out.println("\nEl precio del capuchino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes del capuchino es: " + conLeche.getIngredientes());

        Configurable espresso = new Cafe(3, "Cafe Espresso");
        System.out.println("\nEl precio del café Espresso es: " + espresso.getPrecioBase());
        System.out.println("Los ingredientes del café Espresso es: " + conLeche.getIngredientes());

    }
}





