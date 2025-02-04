  LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada+", size = "+ enlazada.size());
        System.out.println("Está vacía = "+ enlazada.isEmpty());
        enlazada.add(new Alumno("Pato",5));
        enlazada.add(new Alumno("Cata",6));
        enlazada.add(new Alumno("Luci",4));
        enlazada.add(new Alumno("Jano",7));
        enlazada.add(new Alumno("Andrés",3));

        System.out.println(enlazada+ ", size = "+enlazada.size());

        ListIterator<Alumno> li = enlazada.listIterator();

        System.out.println("\nNext");
        while(li.hasNext()){
            Alumno alumno = li.next();
            System.out.println(alumno);
        }

        System.out.println("\nPrevious");
        while(li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }
