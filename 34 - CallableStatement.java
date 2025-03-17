//SQL
CREATE PROCEDURE obtener_producto_por_id(IN id INT, OUT nombre VARCHAR(100))
BEGIN
    SELECT nombre INTO nombre FROM productos WHERE id = id;
END;

//Code Java
import java.sql.*;

public class EjemploCallableStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_basedatos";
        String usuario = "root";
        String contraseña = "password";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Llamar al procedimiento almacenado
            String sql = "{call obtener_producto_por_id(?, ?)}";
            CallableStatement cstmt = conexion.prepareCall(sql);

            // Establecer parámetro de entrada
            cstmt.setInt(1, 5); // ID del producto

            // Registrar parámetro de salida
            cstmt.registerOutParameter(2, Types.VARCHAR); // Nombre del producto

            // Ejecutar el procedimiento
            cstmt.execute();

            // Obtener el valor del parámetro de salida
            String nombreProducto = cstmt.getString(2);
            System.out.println("Nombre del producto: " + nombreProducto);

            // Cerrar recursos
            cstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

