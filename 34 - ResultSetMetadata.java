import java.sql.*;

public class EjemploResultSetMetadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_basedatos";
        String usuario = "root";
        String contraseña = "password";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            // Obtener metadatos del ResultSet
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Mostrar información de las columnas
            System.out.println("Número de columnas: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Columna " + i + ":");
                System.out.println("  Nombre: " + metaData.getColumnName(i));
                System.out.println("  Tipo: " + metaData.getColumnTypeName(i));
                System.out.println("  Tamaño: " + metaData.getColumnDisplaySize(i));
            }

            // Cerrar recursos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
Explicación:
  - getMetaData(): Obtiene un objeto ResultSetMetaData desde el ResultSet.
  - getColumnCount(): Devuelve el número de columnas en el ResultSet.
  - getColumnName(): Devuelve el nombre de una columna.
  - getColumnTypeName(): Devuelve el tipo de datos de una columna.
  - getColumnDisplaySize(): Devuelve el tamaño máximo de una columna.
*/
