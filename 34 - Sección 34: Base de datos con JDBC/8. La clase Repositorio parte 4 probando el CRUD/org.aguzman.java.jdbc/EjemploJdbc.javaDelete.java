package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("Lista completa");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\nLista por por id");
            System.out.println(repositorio.porId(1L));

            // Paso 4: Actualización de producto
            System.out.println("\nEditar producto");
            Producto producto = new Producto();
            producto.setId(3L);// ID del producto a modificar
            producto.setNombre("Teclado Razer mecánico");
            producto.setPrecio(700);
            producto.setFechaRegistro(new Date());
            repositorio.guardar(producto);
            System.out.println("Producto editado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
