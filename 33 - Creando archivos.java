package org.aguzman.archivos.ejemplos;

import org.aguzman.archivos.ejemplos.servicio.ArchivoServicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "D:\\Cursos\\Java\\archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo(nombreArchivo);
    }
}

package org.aguzman.archivos.ejemplos.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoServicio {

    public void crearArchivo(String nombre){
        File archivo = new File(nombre);
        try {
            FileWriter escritor = new FileWriter(archivo,true);
            escritor.append("Hola que tal amigos!\n")
                    .append("Todo bien? Yo acá escribiendo un archivo...\n")
                    .append("Hasta luego Lucas!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

