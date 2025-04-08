package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;

import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        try(Connection conn = ConexionBaseDatos.getInstance()){
                    Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                    System.out.println("Lista completa");
                    repositorio.listar().forEach(System.out::println);

                    System.out.println("\nLista por por id");
                    System.out.println(repositorio.porId(1L));

                    System.out.println("\nInsertar nuevo producto");
                    // Se crea un nuevo objeto Producto para insertar
                    Producto producto = new Producto();
                    producto.setNombre("Teclado IBM mécanico");
                    producto.setPrecio(1550);
                    producto.setFechaRegistro(new Date());
                    Categoria categoria = new Categoria();
                    categoria.setId(3L);
                    producto.setCategoria(categoria);
                    // Se establece el valor del nuevo campo 'sku' para el producto a insertar
                    producto.setSku("abcde12345");
                    // Se guarda el nuevo producto en la base de datos
                    repositorio.guardar(producto);
                    System.out.println("Producto guardado con éxito");

                    System.out.println("\nEditar producto");
                    producto = new Producto();
                    producto.setId(3L);
                    producto.setNombre("Teclado Corsair k95 mecánico");
                    producto.setPrecio(1000);
                    producto.setSku("abcd123456");// Se establece un valor para el nuevo campo 'sku' para el producto a actualizar
                    categoria = new Categoria();
                    categoria.setId(2L);
                    producto.setCategoria(categoria);
                    repositorio.guardar(producto);
                    System.out.println("Producto editado con éxito");

                    repositorio.listar().forEach(System.out::println);

            }catch (SQLException e){
                    e.printStackTrace();
            }
    }
}
