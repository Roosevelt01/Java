import models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        System.out.println("Ejemplo #1 - BiConsumer");
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre+ " tiene "+ edad+ " años!");
        consumidorBi.accept("Pepe", 20);

        System.out.println("\nEjemplo #2");
        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        System.out.println("\nEjemplo #3");
        List<String> nombres = Arrays.asList("andres","pepe","luz","paco");
        nombres.forEach(consumidor2);

        System.out.println("\nEjemplo #4");
        Usuario usuario = new Usuario();
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;

        asignarNombre.accept(usuario, "Andrés");
        System.out.println("Nombre de usuario: "+ usuario.getNombre());

        System.out.println("\nEjemplo #5");
        Supplier<String> proveedor = () -> "Hola mundo lambda supplier";
        System.out.println(proveedor.get());

        System.out.println("\nEjemplo #6");
        Supplier<Usuario> crearUsuario = Usuario::new;
        Usuario usuario2 = crearUsuario.get();

        BiConsumer<Usuario, String> asignarNombre2 = Usuario::setNombre;
        asignarNombre.accept(usuario2, "Andrés");
        System.out.println("Nombre de usuario: "+ usuario2.getNombre());


    }
}
