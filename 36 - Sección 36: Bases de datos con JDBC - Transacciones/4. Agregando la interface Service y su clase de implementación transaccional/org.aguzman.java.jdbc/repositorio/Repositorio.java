package org.aguzman.java.jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T>{
    //Añadido para permitir inyección de conexión desde el Service.
    void setConn(Connection conn);

    // --- Métodos CRUD estándar ---
    List<T> listar() throws SQLException;
    T porId(Long id) throws SQLException;
    T guardar(T t) throws SQLException;
    void eliminar(Long id) throws SQLException;    
}
