package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;

/**
 * Ejemplo de actualización con nuevo manejo de conexiones
 * (Cambio: Eliminada gestión manual de conexión)
 */
public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        // El repositorio maneja sus propias conexiones
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        
        System.out.println("========== LISTADO ACTUAL ==========");
        repositorio.listar().forEach(System.out::println);  // Conexión interna

        System.out.println("\n========== ACTUALIZAR PRODUCTO ==========");
        Producto actualizar = new Producto();
        actualizar.setId(3L);  // ID existente
        actualizar.setNombre("Teclado Mecánico Pro");
        actualizar.setPrecio(950);
        
        Categoria cat = new Categoria();
        cat.setId(1L);  // Nueva categoría
        actualizar.setCategoria(cat);
        
        repositorio.guardar(actualizar);  // Conexión manejada internamente
        System.out.println("Producto actualizado exitosamente!");
        
        System.out.println("\n========== LISTADO ACTUALIZADO ==========");
        repositorio.listar().forEach(System.out::println);
    }
}
