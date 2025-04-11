package org.aguzman.java.jdbc.servicio;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class CatalogoServicio implements Servicio{
    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoServicio() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        //Paso 9
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
        }
        return List.of();
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        //Paso 10
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
        }

        return null;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        //Paso 11
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
        }

        return null;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        //Paso 12
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        //Paso 13
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
        }

        return List.of();
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        //Paso 14
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
        }

        return null;
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        //Paso 15
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
        }

        return null;
    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {
        //Paso 16
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        //Paso 17
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            categoriaRepositorio.setConn(conn);
        }
    }
}


