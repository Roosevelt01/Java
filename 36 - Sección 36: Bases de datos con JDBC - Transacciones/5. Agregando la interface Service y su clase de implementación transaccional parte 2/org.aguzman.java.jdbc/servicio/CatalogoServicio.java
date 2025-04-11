package org.aguzman.java.jdbc.servicio;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class CatalogoServicio implements Servicio{
    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoServicio() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    //Modififando metodos

    @Override
    public List<Producto> listar() throws SQLException {
        // Obtiene/Cierra conexión e inyecta en repositorio.
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn); // Inyecta conexión
            return productoRepositorio.listar();// Delega y retorna
        }
        // La conexión se cierra automáticamente por el try-with-resources.
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        // Obtiene/Cierra conexión e inyecta en repositorio.
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);// Inyecta conexión
            return productoRepositorio.porId(id);// Delega y retorna
        }
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        // Operación con manejo de transacción.
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);// 1. Inyectar conexión

            // 2. Control Transaccional Explícito
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);// 2a. Deshabilitar auto-commit (Iniciar TX)
            }

            Producto nuevoProducto = null;// Variable para almacenar resultado

            try{
                nuevoProducto = productoRepositorio.guardar(producto);// 3. Ejecutar operación del repositorio
                conn.commit();// 4. Confirmar transacción si la operación fue exitosa
            }catch (SQLException e){
                conn.rollback();// 5. Revertir transacción si ocurrió un error
                e.printStackTrace();// 6. Manejar la excepción (aquí se imprime, podría registrarse o relanzarse)
                // 7. ¡Importante! Relanzar la excepción es generalmente preferible
                //    para notificar al llamador que la operación falló.
            }
            return nuevoProducto;// 8. Retornar el resultado (será null si hubo rollback)
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        // Operación con manejo de transacción.
        try(Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);// 1. Inyectar conexión

            // 2. Control Transaccional Explícito
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);// 2a. Deshabilitar auto-commit
            }

            try{
                // 3. Ejecutar operación del repositorio
                productoRepositorio.eliminar(id);
                // 4. Confirmar transacción si fue exitosa
                conn.commit();
            }catch (SQLException e){
                conn.rollback(); // 5. Revertir transacción en caso de error
                e.printStackTrace();// 6. Manejar la excepción
                // 7. Considerar relanzar la excepción
                // throw e;
            }
        }
        // La conexión se cierra automáticamente.
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.porId(id);
        }
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);

            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            Categoria nuevaCategoria=null;

            try{
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }

            return nuevaCategoria;
       }

    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {

        try(Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);

            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try{
                    categoriaRepositorio.eliminar(id);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        // Operación combinada con manejo de transacción.
        try(Connection conn = ConexionBaseDatos.getConnection()){
            // 1. Inyectar la MISMA conexión a AMBOS repositorios.
            productoRepositorio.setConn(conn);
            categoriaRepositorio.setConn(conn);

            // 2. Control Transaccional Explícito
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try{
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);// 3. Guardar Categoría primero
                // 4. Actualizar el producto con la referencia a la categoría guardada (con ID).
                producto.setCategoria(nuevaCategoria);
                productoRepositorio.guardar(producto);// 5. Guardar el producto (que ahora tiene la FK correcta).
                conn.commit();// 6. Confirmar transacción si AMBAS operaciones fueron exitosas.
            }catch (SQLException e){
                conn.rollback();// 7. Revertir transacción si CUALQUIER operación falla.
                e.printStackTrace(); // 8. Manejar la excepción.
            }
        }
    }


}


