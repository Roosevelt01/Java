package org.aguzman.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class EjemploLocalDate {
    public static void main(String[] args) {
        System.out.println("Ejemplo - 1");
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual: "+fechaActual);
        System.out.println("Día: "+fechaActual.getDayOfYear());
        System.out.println("Mes: "+fechaActual.getMonth());
        System.out.println("Año: "+fechaActual.getYear());
        System.out.println("Día del año: "+fechaActual.getDayOfYear());
        System.out.println("Era: "+fechaActual.getEra());
        

        System.out.println("\nEjemplo - 2");
        LocalDate fechaActual2 = LocalDate.of(2020, 12, 25);
        System.out.println(fechaActual2);

        System.out.println("\nEjemplo - 3");
        LocalDate fechaActual3 = LocalDate.of(2020, Month.NOVEMBER, 11);
        System.out.println(fechaActual3);

        System.out.println("\nEjemplo - 4");
        LocalDate fechaActual4 = LocalDate.parse("2020-02-01");
        System.out.println(fechaActual4);

        System.out.println("\nEjemplo - 5");
        LocalDate diademaniana = LocalDate.now().plusDays(1);
        System.out.println(diademaniana);

        System.out.println("\nEjemplo - 6");
        LocalDate mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(mesAnteriorMismoDia);

        System.out.println("\nEjemplo - 7");
        DayOfWeek Jueves = LocalDate.parse("2024-02-20").getDayOfWeek();
        System.out.println(Jueves);

        System.out.println("\nEjemplo - 8");
        int twenty = LocalDate.of(2025, 02, 20).getDayOfMonth();
        System.out.println(twenty);

        System.out.println("\nEjemplo - 9");
        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println(esBisiesto);

        System.out.println("\nEjemplo - 10");
        boolean esAntes = LocalDate.of(2020,11,11).isBefore(LocalDate.parse("2020-11-10"));
        System.out.println("esAntes = "+esAntes);

        System.out.println("\nEjemplo - 11");
        boolean esDespues = LocalDate.of(2020,11,11).isAfter(LocalDate.parse("2020-11-10"));
        System.out.println("esDespues = "+esDespues);
    }
}
