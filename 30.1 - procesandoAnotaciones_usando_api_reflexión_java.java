//Anotación
package org.aguzman.anotaciones.ejmplo;


import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface JsonAtributo {
    String nombre() default "";
}

//Clase Producto
package org.aguzman.anotaciones.ejmplo.models;

import org.aguzman.anotaciones.ejmplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {
    @JsonAtributo(nombre = "descripción")
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

//Main principal
package org.aguzman.anotaciones.ejmplo;

import org.aguzman.anotaciones.ejmplo.models.Producto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {
    public static void main(String[] args) {
        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa centro roble");
        p.setPrecio(1000L);

        Field[] atributos = p.getClass().getDeclaredFields();

        String json = Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true);

                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        return "\"" + nombre +"\":\"" + f.get(p) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error al serializarse a json: "+e.getMessage());
                    }
                })
                .reduce("{", (a,b) -> {
                    if("{".equals(a)){
                        return a + b;
                    }
                    return  a + ", " + b;
                }).concat("}");
        System.out.println("json = "+ json);


    }
}

