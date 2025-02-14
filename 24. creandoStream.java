       System.out.println("\nOpción #1");
        Stream<String> nombres = Stream.of("Pato","Paco","Pepa","Pepe");
        nombres.forEach(System.out::println);

        System.out.println("\nOpción #2");
        String [] arr = {"Pato","Paco","Pepa","Pepe"};
        Stream<String> nombres2 = Arrays.stream(arr);
        nombres2.forEach(System.out::println);

        System.out.println("\nOpción #3");
        Stream<String> nombres3 = Stream.<String>builder()
                .add("Pato")
                .add("Paco")
                .add("Pepa")
                .add("Pepe")
                .build();
        nombres3.forEach(System.out::println);

        System.out.println("\nOpción #4");
        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Pepa");

        Stream<String> nombres4 = lista.stream();
        nombres4.forEach(System.out::println);

        System.out.println("\nAlternativa");
        List<String> lista2 = new ArrayList<>();
        lista2.add("Pato");
        lista2.add("Paco");
        lista2.add("Pepe");
        lista2.add("Pepa");

        lista2.stream().forEach(System.out::println);
