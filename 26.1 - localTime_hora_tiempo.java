package org.aguzman.datetime.ejemplos;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1");       
        LocalTime ahora = LocalTime.now();
        System.out.println(ahora);
        System.out.println("Hora: "+ ahora.getHour());
        System.out.println("Minutos:"+ ahora.getMinute());
        System.out.println("Seg.:"+ ahora.getSecond());

        System.out.println("Ejemplo #2");
        LocalTime seisContreinta = LocalTime.of(6,30);
        System.out.println(seisContreinta);

        System.out.println("Ejemplo #3");
        LocalTime seisContreintatwo = LocalTime.of(6,30,59);
        System.out.println(seisContreintatwo);

        System.out.println("Ejemplo #4");
        LocalTime seisContreinta2 = LocalTime.parse("6:30");
        System.out.println(seisContreinta2);

        System.out.println("Ejemplo #5");
        LocalTime seisContreinta3 = LocalTime.of(6,30).plus(1, ChronoUnit.HOURS);
        System.out.println(seisContreinta3);

        System.out.println("Ejemplo #6");
        boolean esAnterior = LocalTime.of(6,30).isBefore(LocalTime.parse("7:30"));
        System.out.println("Es anterior = "+esAnterior);

    }
}
