//main principal
package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizaciónThread {
    public static void main(String[] args) {
        new Thread(new ImprimirFrases("¡Hola", " que tal!")).start();
        new Thread(new ImprimirFrases("¿Quién eres", " tú?")).start();
        new Thread(new ImprimirFrases("Muchas", " gracias, amigo")).start();
    }

    public synchronized static void imprimirFrases(String frase1, String frase2){
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2);

    }
}

//
package org.aguzman.hilos.ejemplos.runnable;

import static org.aguzman.hilos.ejemplos.EjemploSincronizaciónThread.imprimirFrases;

public class ImprimirFrases implements Runnable {
    private String frase1, frase2;

    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        imprimirFrases(this.frase1, this.frase2);
    }
}
