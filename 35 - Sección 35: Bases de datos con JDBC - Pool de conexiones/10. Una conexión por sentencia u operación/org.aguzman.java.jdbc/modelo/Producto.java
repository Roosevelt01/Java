package org.aguzman.java.jdbc.modelo;

import java.util.Date;

/**
 * Clase que representa la entidad Producto en el sistema.
 * Ahora incluye una relación con Categoría.
 */
public class Producto {
    private Long id;                // ID único del producto
    private String nombre;         // Nombre del producto
    private Integer precio;        // Precio del producto
    private Date fechaRegistro;    // Fecha de registro
    private Categoria categoria;   // Relación con Categoría (nuevo campo)

    // Constructores
    public Producto() {}
    public Producto(Long id, String nombre, Integer precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters (incluyendo los nuevos para categoría)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return id + " | "+ nombre + " | " + precio + " | " + fechaRegistro +" | "+ categoria.getNombre();
    }
}