package org.aguzman.hilos.ejemploexecute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecuter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");

            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException exception){
                Thread.currentThread().interrupt();
                exception.printStackTrace();
            }
            System.out.println("Finaliza la tarea....");
        };
        
        executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS );
        System.out.println("Continuando con la ejecución del método main 2");

    }
}
