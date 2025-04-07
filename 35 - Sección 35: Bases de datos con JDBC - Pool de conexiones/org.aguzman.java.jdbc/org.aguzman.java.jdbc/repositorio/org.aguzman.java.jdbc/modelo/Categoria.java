package org.aguzman.java.jdbc.modelo;

/**
 * Clase que representa la entidad Categoría en el sistema.
 * Contiene los atributos básicos de una categoría de productos.
 */
public class Categoria {
    private Long id;        // Identificador único de la categoría
    private String nombre;  // Nombre descriptivo de la categoría

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}