package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("Lista completa");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\nLista por por id");
            System.out.println(repositorio.porId(1L));

            // Paso 1: Creación del objeto Producto
            System.out.println("\nInsertar nuevo producto");
            Producto producto = new Producto();
            producto.setNombre("Teclado mecánico");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            // Paso 2: Guardar el producto
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            // Paso 3: Verificar la inserción
            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
