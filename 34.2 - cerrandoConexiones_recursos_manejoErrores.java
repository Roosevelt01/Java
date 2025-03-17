package org.aguzman.java.jdbc;

import javax.xml.transform.Result;
import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
        String username = "root";
        String password = "root";

        try(Connection conn = DriverManager.getConnection(url, username, password);
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
