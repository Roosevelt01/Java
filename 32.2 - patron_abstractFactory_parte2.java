//class PizzaProducto
package org.aguzman.patrones.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaProducto {
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public PizzaProducto() {
        this.ingredientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void cocinar();
    public abstract void cortar();

    public void preparar(){
        System.out.println("Preparando "+ nombre);
        System.out.println("Seleccionando la masa "+ masa);
        System.out.println("Agregando salsa "+ salsa);
        System.out.println("Agregando ingredientes: ");
        this.ingredientes.forEach(System.out::println);
    }

    public void empaquetar(){
        System.out.println("Poniendo la pizza en una caja de empaque...");
    }

    @Override
    public String toString() {
        return "PizzaFactory{" +
                "nombre='" + nombre + '\'' +
                ", masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}

//class PizzeriaNewYorkFactory
package org.aguzman.patrones.factory;

import org.aguzman.patrones.factory.producto.PizzaNewYorkItaliana;
import org.aguzman.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.aguzman.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{

    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo) {
            case "vegetariana":
                producto = new PizzaNewYorkVegetariana();
                break;

            case "pepperoni":
                producto = new PizzaNewYorkPepperoni();
                break;

            case "italiana":
                producto = new PizzaNewYorkItaliana();
                break;
        }
        return producto;
    }
}

//class PizzeriaZonaAbstractFactory
package org.aguzman.patrones.factory;

public abstract class PizzeriaZonaAbstractFactory {

    public PizzaProducto ordenarPizza(String tipo) {
        PizzaProducto pizza = crearPizza(tipo);
        System.out.println("----Fabricando la pizza " + pizza.getNombre() + "----");
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return pizza;
    }

    abstract PizzaProducto crearPizza(String tipo);

}

//Produdo
//|___class PizzaNewYorkItaliana
//|___class PizzaNewYorkItaliana
//|___class PizzaNewYorkItaliana

//Clase - PizzaNewYorkItaliana
package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {
    public PizzaNewYorkItaliana() {
        super();
        nombre = "Pizza Pepperoni New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate italiano carne";
        ingredientes.add("Queso Mozzarela");
        ingredientes.add("Aceitunas");
        ingredientes.add("Jamón");
        ingredientes.add("Choricillo");
        ingredientes.add("Champiñones");
    }

    @Override
    public void cocinar() {

        System.out.println("Cocinando por 30 min. 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triángulos grandes");

    }
}

//Clase - PizzaNewYorkPepperoni 
package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {
    public PizzaNewYorkPepperoni() {
        super();
        nombre = "Pizza Pepperoni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarela");
        ingredientes.add("Extra pepperoni");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40 min. 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triángulos");
    }
}

//Clase - PizzaNewYorkVegetariana
package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {

    public PizzaNewYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana New York";
        masa = "Masa integreal vegana";
        salsa = "Salsa de tomare";
        ingredientes.add("Queso vebano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Berenjenas");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min. a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}

