package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Ejemplo de actualización de productos con categorías.
 */
public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            
            System.out.println("========== LISTADO INICIAL ==========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\n========== ACTUALIZAR PRODUCTO ==========");
            Producto producto = new Producto();
            producto.setId(3L);  // ID del producto a actualizar
            producto.setNombre("Teclado Corsair k95 mecánico");
            producto.setPrecio(700);
            
            // Cambiar categoría (ID debe existir en BD)
            Categoria categoria = new Categoria();
            categoria.setId(2L);  // Nuevo ID de categoría
            producto.setCategoria(categoria);
            
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con éxito");
            
            System.out.println("\n========== LISTADO FINAL ==========");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}