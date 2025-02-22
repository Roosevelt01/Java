package org.aguzman.anotaciones.ejmplo.models;

import org.aguzman.anotaciones.ejmplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {
    @JsonAtributo
    private String nombre;
    @JsonAtributo
    private long precio;
    private LocalDate fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

package org.aguzman.anotaciones.ejmplo;

import org.aguzman.anotaciones.ejmplo.models.Producto;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {
        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa centro roble");
        p.setPrecio(1000L);
    }
}

package org.aguzman.anotaciones.ejmplo;


import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface JsonAtributo {
    String nombre() default "";
}

