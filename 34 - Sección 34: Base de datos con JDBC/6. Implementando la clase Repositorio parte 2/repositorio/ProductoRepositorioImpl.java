package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos")){
            while (rs.next()){
                Producto p = crearProducto(rs);//Recien agregado en esa clase
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    //Recien agregado en esa clase
    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        try(PreparedStatement stmt = getConnection().
            prepareStatement("SELECT * FROM productos WHERE id = ?")) {
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                producto = crearProducto(rs);
            }
            rs.close();//Recién agregado en esa clase
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    //Recien agregado en esa clase
    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        return p;
    }
}
