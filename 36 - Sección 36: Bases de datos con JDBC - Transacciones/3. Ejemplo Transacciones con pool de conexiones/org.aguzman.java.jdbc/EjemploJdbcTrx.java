package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args)throws SQLException {
          try(Connection conn = ConexionBaseDatos.getConnection()){
            if(conn.getAutoCommit()){
                    conn.setAutoCommit(false);
            }
            try{
                    Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                    System.out.println("Insertar nueva categoría");
                    Categoria categoria = new Categoria();
                    categoria.setNombre("Electrohogar");
                    Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                    System.out.println("Categoría guardado con éxito: "+nuevaCategoria.getId());

                    Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                    System.out.println("\nLista completa");
                    repositorio.listar().forEach(System.out::println);

                    System.out.println("\nLista por por id");
                    System.out.println(repositorio.porId(1L));

                    System.out.println("\nInsertar nuevo producto");
                    Producto producto = new Producto();
                    producto.setNombre("Refrigerador Samsung");
                    producto.setPrecio(9900);
                    producto.setFechaRegistro(new Date());
                    producto.setSku("abcdef1234");

                    producto.setCategoria(nuevaCategoria);
                    repositorio.guardar(producto);
                    System.out.println("Producto guardado con éxito: "+producto.getId());
                    repositorio.listar().forEach(System.out::println);
                    conn.commit();
            }catch (SQLException e){
                    conn.rollback();
                    e.printStackTrace();
            }
          }
    }
}