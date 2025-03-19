/*Clase 1: EjemploJdbc*/

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

/*Clase 2: ConexionBaseDatos*/

package org.aguzman.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "root";
    private  static Connection connection;

    public static Connection getInstance() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}



