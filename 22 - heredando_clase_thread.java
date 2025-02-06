package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Jhon Doe");
        hilo.start();
        //Thread.sleep(100);
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();
        System.out.println(hilo.getState());

    }
}

//
package org.aguzman.hilos.ejemplos.threads;

public class NombreThread extends Thread{
    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el método run del hilo: "+getName());

        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName());
        }
        System.out.println("Finaliza el hilo");

    }
}

