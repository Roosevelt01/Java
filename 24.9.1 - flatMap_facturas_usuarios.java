//Clase Usuario
package org.aguzman.api.stream.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre, apellido;
    private List<Factura> facturas;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.facturas = new ArrayList<>();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
        factura.setUsuario(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}

//Clase Factura
package org.aguzman.api.stream.models;

public class Factura {
    private String descripcion;
    private  Usuario usuario;

    public Factura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

//Main principal(EjemploStreamFlatMapFactura)
package org.aguzman.api.stream;

import org.aguzman.api.stream.models.Factura;
import org.aguzman.api.stream.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("John", "Doe");
        u1.addFactura(new Factura("Compras Tecnólogica"));
        u1.addFactura(new Factura("Compras Muebles"));

        Usuario u2 = new Usuario("Pepe", "Pérez");
        u2.addFactura(new Factura("Bicicleta"));
        u2.addFactura(new Factura("Notebook Gamer"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);
        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" | cliente: ")
                .concat(f.getUsuario().toString())));

    }
}
