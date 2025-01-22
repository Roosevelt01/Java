package org.aguzman.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion implements Iterable{
    private List objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void add(Object object){
        if(this.objetos.size() <= max){
            this.objetos.add(objetos);
        }else{
            throw new RuntimeException("No hay más espacion.");
        }
    }

    @Override
    public Iterator iterator() {
        return this.objetos.iterator();
    }
}

//
package org.aguzman.genericsclass;

public class Animal {
    private String nombre;
    private String tipo;

    public Animal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}

//
package org.aguzman.genericsclass;

public class Maquinaria {
    private String tipo;

    public Maquinaria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

//
package org.aguzman.genericsclass;

public class Automovil {
    private String marca;

    public Automovil(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
}

