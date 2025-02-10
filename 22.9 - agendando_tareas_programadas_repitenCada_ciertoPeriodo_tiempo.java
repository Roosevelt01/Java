package org.aguzman.hilos.ejemplos;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        AtomicInteger contadorAtomic = new AtomicInteger(3);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();

                if(i > 0){
                    System.out.println("Tarea periódica "+i+" en: "+ new Date() + " nombre del thread: " +
                            Thread.currentThread().getName());
                }else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }

            }

        },5000,10000);

        System.out.println("Agendamos una tarea para 5 minutos más...");
    }
}

//Toolkit 
package org.aguzman.hilos.ejemplos;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Timer timer = new Timer();
        AtomicInteger contadorAtomic = new AtomicInteger(3);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();

                if(i > 0){
                    toolkit.beep();
                    System.out.println("Tarea periódica "+i+" en: "+ new Date() + " nombre del thread: " +
                            Thread.currentThread().getName());
                }else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }

            }

        },0,10000);

        System.out.println("Agendamos una tarea inmediata que se repite 10 segundo...");
    }
}

