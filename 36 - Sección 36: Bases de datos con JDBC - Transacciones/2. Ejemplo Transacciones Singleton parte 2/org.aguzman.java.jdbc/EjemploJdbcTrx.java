public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            
            // Paso 1: Desactivar auto-commit
            if(conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {
                // Operaciones transaccionales
                System.out.println("Lista completa");
                repositorio.listar().forEach(System.out::println);

                System.out.println("\nInsertar nuevo producto");
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM mécanico");
                producto.setPrecio(1550);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcde12345");
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);

                System.out.println("\nEditar producto");
                producto = new Producto();
                producto.setId(3L);
                producto.setNombre("Teclado Corsair k95 mecánico");
                producto.setPrecio(1000);
                producto.setSku("abcdf1234");
                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);
                repositorio.guardar(producto);

                // Confirmar transacción
                conn.commit();
            } catch (SQLException exception) {
                // Revertir transacción en caso de error
                conn.rollback();
                exception.printStackTrace();
            }
        }
    }
}