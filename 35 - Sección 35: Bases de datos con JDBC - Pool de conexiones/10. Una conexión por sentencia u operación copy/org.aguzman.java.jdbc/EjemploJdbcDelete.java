
package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;

/**
 * Ejemplo de eliminación con nuevo esquema de conexiones
 * (Cambio: Sin gestión explícita de conexión)
 */
public class EjemploJdbcDelete {
    public static void main(String[] args) {
        // Repositorio autónomo en manejo de conexiones
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        
        System.out.println("========== LISTADO INICIAL ==========");
        repositorio.listar().forEach(System.out::println);  // Conexión interna

        System.out.println("\n========== ELIMINAR PRODUCTO ==========");
        Long idEliminar = 3L;  // ID a eliminar
        repositorio.eliminar(idEliminar);  // El repositorio maneja su conexión
        System.out.println("Producto eliminado exitosamente!");
        
        System.out.println("\n========== LISTADO FINAL ==========");
        repositorio.listar().forEach(System.out::println);
    }
}