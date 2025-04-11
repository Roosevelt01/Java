package org.aguzman.java.jdbc.servicio;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

//Interfaz que define las operaciones de negocio del catálogo.
//Actúa como contrato para la capa de servicio.
public interface Servicio {

    // --- Productos ---
    List<Producto> listar() throws SQLException;
    Producto porId(Long id) throws SQLException;
    Producto guardar(Producto producto) throws SQLException;
    void eliminar(Long id) throws SQLException;

    // --- Categorías ---
    List<Categoria> listarCategoria() throws SQLException;
    Categoria porIdCategoria(Long id) throws SQLException;
    Categoria guardarCategoria(Categoria categoria) throws SQLException;
    void eliminarCategoria(Long id) throws SQLException;

    // --- Operaciones Combinadas ---
    //Guarda producto y su categoría asociada (operación transaccional).
    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;
}
