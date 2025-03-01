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



