//Ejemplo 1
package org.aguzman.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class EjemploStreamparallel {
    public static void main(String[] args) {
        System.out.println("\nEjemplo #1 - Ejemplo básico");
        List<String> nombres = Arrays.asList("Pato", "Paco", "Pepa", "Pepe", "Lalo");

        // Convertir el Stream a paralelo
        nombres.stream().parallel() // Convierte el Stream en paralelo
                .forEach(System.out::println);

        System.out.println("\nEjemplo #2 - Operaciones");
        // Calcular la suma de los cuadrados de los números del 1 al 100,000 en paralelo
        int suma = IntStream.rangeClosed(1, 100_000)
                .parallel() // Convertir el Stream en paralelo
                .map(n -> n * n) // Elevar al cuadrado cada número
                .sum(); // Sumar los resultados

        System.out.println("\nSuma de cuadrados: " + suma);

        System.out.println("Ejemplo #4 - Procesamiento de una lista de cadenas en paralelo");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Contar los números pares en paralelo
        long cantidadPares = numeros.stream()
                .parallel() // Convertir el Stream en paralelo
                .filter(n -> n % 2 == 0) // Filtrar números pares
                .count(); // Contar los números pares

        System.out.println("Cantidad de números pares: " + cantidadPares);

        System.out.println("Ejemeplo #5 - Búsqueda de elementos en paralelo");
        List<String> names = Arrays.asList("Pato", "Paco", "Pepa", "Pepe", "Lalo", "Juan", "Ana", "Luis");

        // Buscar un nombre que comience con "P" en paralelo
        Optional<String> nombreEncontrado = names.stream()
                .parallel() // Convertir el Stream en paralelo
                .filter(n -> n.startsWith("P")) // Filtrar nombres que comienzan con "P"
                .findAny(); // Encontrar cualquier nombre que cumpla la condición

        nombreEncontrado.ifPresent(System.out::println);

        System.out.println("Ejemeplo #6 - Búsqueda de elementos en paralelo");
        List<String> imagenes = Arrays.asList("imagen1.jpg", "imagen2.jpg", "imagen3.jpg", "imagen4.jpg");

        // Procesar imágenes en paralelo (simulado)
        imagenes.stream()
                .parallel() // Convertir el Stream en paralelo
                .map(imagen -> {
                    System.out.println("Procesando " + imagen + " en el hilo: " + Thread.currentThread().getName());
                    // Simular un procesamiento costoso
                    try {
                        Thread.sleep(1000); // Simular un retraso de 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return imagen.toUpperCase();
                })
                .forEach(System.out::println); // Imprimir las imágenes procesadas
    }
}

//Ejemplo 2
package org.aguzman.api.stream.models;

import java.util.Arrays;
import java.util.List;

class Facture {
    private String descripcion;
    private double monto;

    public Facture(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return descripcion + " - $" + monto;
    }
}

public class Facturacion {
    public static void main(String[] args) {
        List<Facture> facturas = Arrays.asList(
                new Facture("Compra de tecnología", 1500.0),
                new Facture("Compra de muebles", 800.0),
                new Facture("Compra de ropa", 300.0),
                new Facture("Compra de alimentos", 200.0)
        );

        // Calcular el total de las facturas en paralelo
        double total = facturas.stream()
                .parallel() // Convertir el Stream en paralelo
                .mapToDouble(Facture::getMonto) // Obtener el monto de cada factura
                .sum(); // Sumar los montos

        System.out.println("Total de facturas: $" + total);
    }
}

