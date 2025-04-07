package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import java.util.Date;

/**
 * Ejemplo de uso del repositorio con conexiones autogestionadas
 * (Cambio clave: Eliminado el manejo explícito de conexión)
 */
public class EjemploJdbc {
    public static void main(String[] args) {
        // El repositorio ahora maneja sus propias conexiones internamente
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl(); 
        
        System.out.println("========== LISTADO INICIAL ==========");
        repositorio.listar().forEach(System.out::println);  // Conexión manejada internamente

        System.out.println("\n========== BUSCAR POR ID ==========");
        System.out.println(repositorio.porId(1L));  // Cada operación es independiente

        System.out.println("\n========== INSERTAR NUEVO PRODUCTO ==========");
        Producto nuevo = new Producto();
        nuevo.setNombre("Teclado Mecánico RGB");
        nuevo.setPrecio(850);
        nuevo.setFechaRegistro(new Date());
        
        Categoria categoria = new Categoria();
        categoria.setId(2L);  // ID de categoría existente
        nuevo.setCategoria(categoria);
        
        repositorio.guardar(nuevo);  // El repositorio maneja su conexión
        System.out.println("Producto guardado exitosamente!");
        
        System.out.println("\n========== LISTADO FINAL ==========");
        repositorio.listar().forEach(System.out::println);
    }
}