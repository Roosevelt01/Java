package org.aguzman.patrones.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaFactory {
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public PizzaFactory() {
        this
                .ingredientes = new ArrayList<>();
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
