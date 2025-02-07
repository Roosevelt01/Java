package org.aguzman.hilos.ejemplos.runnable;

public class ViajeTarea implements  Runnable{
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10;i++){
            System.out.println(i+ " - " + nombre);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a: "+ nombre);
    }
}

//Main Principal
package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
