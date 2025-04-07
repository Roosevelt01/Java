package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de productos con gestión interna de conexiones
 * Patrón: Cada método maneja su propia conexión a la base de datos
 */
public class ProductoRepositorioImpl implements Repositorio<Producto> {

    /**
     * Obtiene una nueva conexión para cada operación
     * (Cambio clave: Ya no usa Singleton estático)
     */
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    /**
     * Listar todos los productos con sus categorías
     * (Modificación: Ahora maneja su propia conexión)
     */
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        
        try (Connection conn = getConnection();  // Nueva conexión por operación
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                "SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id)")) {
            
            while (rs.next()) {
                productos.add(crearProducto(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    /**
     * Buscar producto por ID
     * (Modificación: Conexión independiente)
     */
    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        try (Connection conn = getConnection();  // Conexión dedicada
             PreparedStatement stmt = conn.prepareStatement(
                "SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    /**
     * Guardar producto (INSERT o UPDATE)
     * (Modificación: Manejo autónomo de conexión)
     */
    @Override
    public void guardar(Producto producto) {
        String sql = producto.getId() != null && producto.getId() > 0 ?
            "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?" :
            "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)";

        try (Connection conn = getConnection();  // Conexión transaccional
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId());
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar producto: " + e.getMessage(), e);
        }
    }

    /**
     * Eliminar producto por ID
     * (Modificación: Conexión autocontenida)
     */
    @Override
    public void eliminar(Long id) {
        try (Connection conn = getConnection();  // Conexión efímera
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id=?")) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar producto: " + e.getMessage(), e);
        }
    }

    /**
     * Método auxiliar para mapear ResultSet a Producto
     * (Nuevo: Ahora incluye mapeo de categoría)
     */
    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        
        return p;
    }
}