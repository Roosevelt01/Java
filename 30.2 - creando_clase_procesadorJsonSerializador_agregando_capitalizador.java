package org.aguzman.anotaciones.ejmplo;


import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface JsonAtributo {
    String nombre() default "";
    //
    boolean capitalizar() default false;

}


// JsonSerializador
package org.aguzman.anotaciones.ejmplo.procesador;

import org.aguzman.anotaciones.ejmplo.JsonAtributo;
import org.aguzman.anotaciones.ejmplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class JsonSerializador {

    public static String convertirJson(Object object){

        if(Objects.isNull(object)){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null!");
        }

        Field[] atributos = object.getClass().getDeclaredFields();

        return Arrays.stream(atributos)

                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true);

                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        //
                        Object valor = f.get(object);
                        if(f.getAnnotation(JsonAtributo.class).capitalizar() && valor instanceof String nuevoValor){
                            nuevoValor = nuevoValor.substring(0,1).toUpperCase() + nuevoValor.substring(1).toLowerCase();
                            f.set(object,nuevoValor);
                        }

                        return "\"" + nombre +"\":\"" + f.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializarse a json: "+e.getMessage());
                    }
                })
                .reduce("{", (a,b) -> {
                    if("{".equals(a)){
                        return a + b;
                    }
                    return  a + ", " + b;
                }).concat("}");
    }
}

//Clase Producto
package org.aguzman.anotaciones.ejmplo.models;

import org.aguzman.anotaciones.ejmplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {
    @JsonAtributo(capitalizar = true)//
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
