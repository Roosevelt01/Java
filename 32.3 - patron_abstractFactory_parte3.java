//Factory
package org.aguzman.patrones.factory;

import org.aguzman.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.aguzman.patrones.factory.producto.PizzaCaliforniaQueso;
import org.aguzman.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{

    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "queso" -> new PizzaCaliforniaQueso();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "vegetarian" -> new PizzaCaliforniaVegetariana();
            default -> null;
        };
    }
}

//Creación de las pizzas(California)
package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza California Vegetariana";
        masa = "Masa delgada Light";
        salsa = "Salsa BBQ Light";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Cebolla");
        ingredientes.add("Berenjenas");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min. a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas rectángulares");
    }
}

//
public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "Masa a la piedra delgada";
        salsa = "Salsa de tomate rucula";
        ingredientes.add("Extra queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso azul");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 35 min. a 100°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños tríángulos");
    }
}

//
package org.aguzman.patrones.factory.producto;

import org.aguzman.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {
    public PizzaCaliforniaPepperoni() {
        super();
        nombre = "Pizza Pepperoni Pepperono";
        masa = "Masa a la piedra gruesa";
        ingredientes.add("Pepperoni");
        ingredientes.add("Extra queso mozzarella");
        ingredientes.add("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 50 min. 55°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza pequeños rectángulos");
    }
}

//Main principal
package org.aguzman.patrones.factory.ejemplo;

import org.aguzman.patrones.factory.PizzaProducto;
import org.aguzman.patrones.factory.PizzeriaCaliforniaFactory;
import org.aguzman.patrones.factory.PizzeriaNewYorkFactory;
import org.aguzman.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza: "+ pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andrés ordena una: "+ pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena: "+ pizza.getNombre());

        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("Linus ordena la pizza: "+ pizza.getNombre());

        pizza = california.ordenarPizza("pepperoni");
        System.out.println("John ordena la pizza: "+ pizza.getNombre());

        System.out.println("pizza = "+pizza);
    }
}


