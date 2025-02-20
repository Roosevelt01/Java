package org.aguzman.datetime.ejemplos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
        
        System.out.println("Ejemplo #1");
        LocalTime ahora = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormatedo = ahora.format(df);
        System.out.println(ahoraFormatedo);

        System.out.println("\nEjemplo #2");
        LocalTime seisConTreinta = LocalTime.parse("06:30");
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormatedo2 = seisConTreinta.format(df2);
        System.out.println(ahoraFormatedo2);

        System.out.println("\nEjemplo #3");
        LocalTime seisConTreinta2 = LocalTime.parse("18:30");
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormatedo3 = seisConTreinta2.format(df3);
        System.out.println(ahoraFormatedo3);

        System.out.println("\nEjemplo #4");
        LocalTime seisConTreinta3 = LocalTime.parse("06:30");
        DateTimeFormatter df4 = DateTimeFormatter.ofPattern("HH:mm:ss a");
        String ahoraFormatedo4 = seisConTreinta3.format(df3);
        System.out.println(ahoraFormatedo4);

        System.out.println("\nEjemplo #5");
        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;

        System.out.println("Max = "+max);
        System.out.println("Min = "+min);

    }
}
