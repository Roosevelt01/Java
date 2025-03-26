package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("Lista completa");
            repositorio.listar().forEach(System.out::println);//Modificado en esa clase

            //Recien agregado en esa clase
            System.out.println("\nLista por detalle");
            System.out.println(repositorio.porId(1L));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
