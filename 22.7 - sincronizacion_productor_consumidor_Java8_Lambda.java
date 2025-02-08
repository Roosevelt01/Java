//Main principal
package org.aguzman.hilos.ejemplos.ejemplosync;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread( () -> {
            for (int i = 0; i < 10; i++){
                p.hornear("Pan n: "+ i);

                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                p.consumir();
            }
        }).start();
    }
}

//Clase Panaderia
package org.aguzman.hilos.ejemplos.ejemplosync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa){
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.pan = masa;
        System.out.println("Panadero hornea -> "+ this.pan);
        this.disponible = true;
        notify();

    }

    public synchronized String consumir(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cliente consume el pan -> "+this.pan);
        System.out.println("\n");
        this.disponible = false;
        notify();
        return pan;
    }
}
