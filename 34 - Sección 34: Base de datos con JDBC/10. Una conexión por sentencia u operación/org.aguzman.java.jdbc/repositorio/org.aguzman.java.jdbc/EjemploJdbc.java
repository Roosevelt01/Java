package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

/**
 * Ejemplo de creación de productos con categorías.
 */
public class EjemploJdbc {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            
            System.out.println("========== LISTADO INICIAL ==========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\n========== INSERTAR NUEVO PRODUCTO ==========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Red Dragón mecánico");
            producto.setPrecio(450);
            producto.setFechaRegistro(new Date());
            
            // Configurar categoría (ID debe existir en BD)
            Categoria categoria = new Categoria();
            categoria.setId(3L);  // ID de categoría existente
            producto.setCategoria(categoria);
            
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            
            System.out.println("\n========== LISTADO FINAL ==========");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}