package org.aguzman.datetime.ejemplos;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) throws InterruptedException {

        LocalDateTime fechaLocal = LocalDateTime.now();

        System.out.println("Ejemplo #1");
        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal, newYork);
        System.out.println("Horario de partida en New York: "+ zonaNy);

        System.out.println("\nEjemplo #2");
        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNy.withZoneSameInstant(madrid);
        System.out.println("Hora de llegada en Madrid: "+ zonaMadrid);

        System.out.println("\nEjemplo #3");
        ZoneId madrid2 = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid2 = zonaNy.withZoneSameInstant(madrid2).plusHours(8);
        System.out.println("Hora de llegada en Madrid: "+ zonaMadrid2);
    }
}
