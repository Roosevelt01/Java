package org.aguzman.java.jdbc.modelo;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private Integer precio;
    private Date fechaRegistro;
    private Categoria categoria;
    private String sku;//SKU (Stock Keeping Unit) - Identificador único del producto en el sistema de inventario.

    public Producto() {
    }

    public Producto(Long id, String nombre, Integer precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /*
    * Obtiene el código SKU del producto
    * @return String con el código SKU asignado al producto
    */
    public String getSku() {
        return sku;
    }

    /*
    * Asigna un código SKU al producto
    * @param sku Código identificador único (Stock Keeping Unit)
    */
    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return id + " | "+ 
        nombre + " | " + 
        precio + " | " + 
        fechaRegistro +" | "+ 
        categoria.getNombre() +" | "+ 
        sku; // Incluye el SKU en la representación textual
       
    }
}