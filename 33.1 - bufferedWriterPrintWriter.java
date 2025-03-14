

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "D:\\Cursos\\Java\\archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo2(nombreArchivo);
    }
}


public class ArchivoServicio {

    public void crearArchivo(String nombre){
       
        File archivo = new File(nombre);
        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))) {
            buffer.append("Hola que tal amigos!\n")
                    .append("Todo bien? Yo acá escribiendo un archivo...\n")
                    .append("Hasta luego Lucas!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void crearArchivo2(String nombre){

        File archivo = new File(nombre);
        try(PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))) {
            buffer.println("Hola que tal amigos!\n");
            buffer.println("Todo bien? Yo acá escribiendo un archivo...\n");
            buffer.println("Hasta luego Lucas!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
