package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.servicio.CatalogoServicio;
import org.aguzman.java.jdbc.servicio.Servicio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        // 1. Instanciar el Servicio (usando la interfaz como tipo)
        Servicio servicio = new CatalogoServicio();

        // 2. Usar el servicio para listar (lógica de conexión/repositorio oculta)
        System.out.println("Lista completa");
        servicio.listar().forEach(System.out::println);

        // 3. Preparar datos para una nueva operación combinada
        System.out.println("\nInsertar nueva categoría");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación"); // Usar un nombre diferente si "Iluminación" ya existe por pruebas previas

        System.out.println("\nInsertar nuevo producto");
        Producto producto = new Producto();
        producto.setNombre("Lámpara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date()); // Fecha actual del sistema
        producto.setSku("abcdef1234");// Usar un SKU único si existe constraint UNIQUE, o uno nuevo

        //4. Llamar al método de servicio para la operación combinada
        servicio.guardarProductoConCategoria(producto, categoria);
        // 5. Mostrar confirmación (el servicio actualiza el ID en el objeto producto)
        System.out.println("Producto guardado con éxito: " + producto.getId());
        // 6. Listar de nuevo para ver el resultado final
        servicio.listar().forEach(System.out::println);
    }
}