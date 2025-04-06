package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcDelete {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("Lista completa");
            repositorio.listar().forEach(System.out::println);

            System.out.println("\nLista por por id");
            System.out.println(repositorio.porId(1L));

            System.out.println("\nEliminar producto");
            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
