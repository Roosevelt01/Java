package org.aguzman.junit5app.ejemplos.exceptions; // Paquete para excepciones personalizadas

// Paso 1 en la transcripción: Crear la clase de excepción
public class DineroInsuficienteException extends RuntimeException { // Hereda de RuntimeException

    // Constructor que acepta un mensaje
    public DineroInsuficienteException(String message) {
        // Llama al constructor de la superclase (RuntimeException) para establecer el mensaje
        super(message);
    }
}