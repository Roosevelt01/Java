//Paquete modelo
package org.aguzman.poointerfaces.modelo;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId;

    public Cliente() {
        this.id = ++ultimoId;
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
    }
}

//Paquete repositorio

//Interface CrudRespotorio
package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> lista();
    Cliente porId(Integer id);
    void crear(Cliente cliente);
    void edtitar(Cliente cliente);
    void eliminar(Integer id);
}

//Enum
package org.aguzman.poointerfaces.repositorio;

public enum Direccion {
    ASC, DESC
}


//Interface OrdenableRepositorio
package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}

//Interface PaginableRepositorio
package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}



