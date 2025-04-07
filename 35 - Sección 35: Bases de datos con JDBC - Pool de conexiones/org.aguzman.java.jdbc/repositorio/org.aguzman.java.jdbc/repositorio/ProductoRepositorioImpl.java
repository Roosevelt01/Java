package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de productos con soporte para relaciones con categorías.
 * Incluye operaciones CRUD completas con manejo de la relación Producto-Categoría.
 */
public class ProductoRepositorioImpl implements Repositorio<Producto> {

    /**
     * Obtiene una conexión a la base de datos
     * @return Conexión activa a la BD
     * @throws SQLException Si hay error al conectar
     */
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    /**
     * Lista todos los productos con su información de categoría asociada
     * @return Lista completa de productos con sus categorías
     */
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        /**
         * Consulta SQL modificada con INNER JOIN para obtener:
         * - Todos los campos de productos (p.*)
         * - El nombre de la categoría (c.nombre as categoria)
         */
        try (Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id)")) {
            
            // Procesa cada registro y crea objetos Producto completos
            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    /**
     * Busca un producto por su ID incluyendo su categoría asociada
     * @param id ID del producto a buscar
     * @return Producto encontrado o null si no existe
     */
    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        /**
         * Consulta preparada con JOIN para obtener:
         * - Producto específico filtrado por ID
         * - Información de su categoría asociada
         */
        try(PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            
            // Establece el parámetro ID en la consulta
            stmt.setLong(1, id);

            // Ejecuta y procesa el resultado
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
     * Guarda un producto (inserta o actualiza) incluyendo su relación con categoría
     * @param producto Producto a guardar con su categoría asociada
     */
    @Override
    public void guardar(Producto producto) {
        String sql;
        
        // Determina si es INSERT (nuevo) o UPDATE (existente)
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)";
        }

        try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            // Parámetros comunes
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            
            /**
             * Nuevo parámetro: categoria_id obtenido del objeto Categoria asociado
             * Nota: producto.getCategoria() no debe ser null
             */
            stmt.setLong(3, producto.getCategoria().getId());

            // Parámetros específicos por operación
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId()); // Para UPDATE
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime())); // Para INSERT
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar producto: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM productos WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar producto: " + e.getMessage(), e);
        }
    }

    /**
     * Método auxiliar para crear objetos Producto a partir de ResultSet
     * Ahora incluye el mapeo de la relación con Categoría
     * @param rs ResultSet con los datos del producto y su categoría
     * @return Objeto Producto completo
     * @throws SQLException Si hay error al acceder a los datos
     */
    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        
        // Mapeo de campos básicos
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        
        /**
         * Mapeo de la categoría asociada:
         * 1. Crea objeto Categoria
         * 2. Establece ID desde categoria_id (llave foránea)
         * 3. Establece nombre desde alias 'categoria'
         * 4. Asigna al producto
         */
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        
        return p;
    }
}