package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;

import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
            //Paso 5: Eliminamos el try/catch
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("Lista completa");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\nLista por por id");
            System.out.println(repositorio.porId(1L));

            System.out.println("\nInsertar nuevo producto");
            Producto producto = new Producto();
            producto.setNombre("Notebook Omen HP");
            producto.setPrecio(2900);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println);
    }
}
