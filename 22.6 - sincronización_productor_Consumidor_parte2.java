//Main principal
package org.aguzman.hilos.ejemplos.ejemplosync;

import org.aguzman.hilos.ejemplos.ejemplosync.runnable.*;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}

//Clase Hija(Consumidor)
package org.aguzman.hilos.ejemplos.ejemplosync.runnable;

import org.aguzman.hilos.ejemplos.ejemplosync.Panaderia;

public class Consumidor implements Runnable {
    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            panaderia.consumir();
        }
    }
}

//Clase Hija(Panadero)
package org.aguzman.hilos.ejemplos.ejemplosync.runnable;

import org.aguzman.hilos.ejemplos.ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
       for (int i = 0; i < 10; i++){
           panaderia.hornear("Pan n: "+ i);

           try {
               Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

