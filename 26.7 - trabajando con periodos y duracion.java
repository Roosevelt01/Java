        System.out.println("Ejemplo #1");
        LocalDateTime fecha1 = LocalDateTime.now();
        LocalDateTime fecha2 = LocalDateTime.now();
        Duration lapsus = Duration.between(fecha1,fecha2);
        System.out.println(lapsus.getSeconds());
        System.out.println(lapsus.toDays());
        System.out.println(lapsus.toHours());
        System.out.println(lapsus.toMinutes());

        System.out.println("\nEjemplo #2");
        Instant i1 = Instant.now();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant i2 = Instant.now();
        Duration tiempo = Duration.between(i1,i2);
        System.out.println("Tiempo: "+ tiempo);


        System.out.println("\nEjemplo #3");
        LocalDate fecha1 = LocalDate.of(2011, 9, 23);
        LocalDate fecha2 = LocalDate.of(2025, 2, 21);

        Period periodo = Period.between(fecha1,fecha2);
        System.out.println(periodo);
        System.out.printf("Periodo entre %s y %s hay %d años, %d mses y %d dias",
                fecha1, fecha2, periodo.getYears(), periodo.getMonths(), periodo.getDays());


        System.out.println("\nEjemplo #4");
        LocalDate fecha3 = LocalDate.of(2025, 2, 21);
        fecha3.withMonth(12);
        fecha3.withDayOfMonth(28);

        System.out.println(fecha3);
