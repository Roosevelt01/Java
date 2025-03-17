import java.sql.*;

public class EjemploDatabaseMetadata {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_basedatos";
        String usuario = "root";
        String contraseña = "password";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Obtener metadatos de la base de datos
            DatabaseMetaData metaData = conexion.getMetaData();

            // Información general de la base de datos
            System.out.println("Nombre de la base de datos: " + metaData.getDatabaseProductName());
            System.out.println("Versión de la base de datos: " + metaData.getDatabaseProductVersion());
            System.out.println("Nombre del usuario conectado: " + metaData.getUserName());

            // Obtener información de las tablas
            ResultSet tablas = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("\nTablas en la base de datos:");
            while (tablas.next()) {
                System.out.println(" - " + tablas.getString("TABLE_NAME"));
            }

            // Obtener información de las columnas de una tabla específica
            ResultSet columnas = metaData.getColumns(null, null, "productos", null);
            System.out.println("\nColumnas de la tabla 'productos':");
            while (columnas.next()) {
                System.out.println(" - " + columnas.getString("COLUMN_NAME") + 
                                  " (" + columnas.getString("TYPE_NAME") + ")");
            }

            // Cerrar recursos
            tablas.close();
            columnas.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*

Explicación del Código:

  1 Obtener DatabaseMetaData:
    - Se obtiene un objeto DatabaseMetaData desde la conexión:
         DatabaseMetaData metaData = conexion.getMetaData();

  2. Información General:
    - Se utiliza getDatabaseProductName() y getDatabaseProductVersion() para obtener el nombre y la versión del motor de la base de datos.
    
    - getUserName() devuelve el nombre del usuario conectado.

  3. Obtener Tablas:
    - Se utiliza getTables() para obtener un ResultSet con información sobre las tablas de la base de datos.

    - El método getTables() recibe cuatro parámetros:
        catalog: Nombre del catálogo (generalmente null).
        schemaPattern: Patrón del esquema (generalmente null).
        tableNamePattern: Patrón del nombre de la tabla (% para todas las tablas).
        types: Tipos de objetos a recuperar (por ejemplo, TABLE).

  4 Obtener Columnas:
      - Se utiliza getColumns() para obtener un ResultSet con información sobre las columnas de una tabla específica.
      
      - El método getColumns() recibe cuatro parámetros:
          catalog: Nombre del catálogo (generalmente null).
          schemaPattern: Patrón del esquema (generalmente null).
          tableNamePattern: Nombre de la tabla (por ejemplo, "productos").
          columnNamePattern: Patrón del nombre de la columna (% para todas las columnas).

  5. Mostrar Resultados:
    - Se itera sobre los ResultSet para mostrar los nombres de las tablas y columnas.
    
*/
