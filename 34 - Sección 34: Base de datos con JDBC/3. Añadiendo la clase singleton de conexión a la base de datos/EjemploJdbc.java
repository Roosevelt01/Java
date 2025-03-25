package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance();
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

            while(resultado.next()){
                System.out.print(resultado.getString("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getString("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getString("fecha_registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}