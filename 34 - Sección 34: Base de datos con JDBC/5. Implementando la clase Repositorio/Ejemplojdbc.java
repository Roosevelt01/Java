package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        // Se utiliza un bloque try-with-resources para asegurar el cierre automático de la conexión.
        try (Connection conn = ConexionBaseDatos.getInstance()) {
            // Se crea una instancia del repositorio de productos.
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

            // Se llama al método listar() del repositorio para obtener una lista de productos.
            // Se utiliza forEach para imprimir el nombre de cada producto en la consola.
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            // Se captura cualquier excepción SQL y se imprime la traza de la pila.
            e.printStackTrace();
        }
    }
}
