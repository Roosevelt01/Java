 String [] productos = new String[7];
        int total = productos.length;

        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Sansum Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";

        Arrays.sort(productos);
  
        //for
        for(int i=0;i<total;i++){
               System.out.println("Para indice: "+i+": "+productos[i]);
        }

        //forecha
        System.out.println("=== Usando foreach===");
        for(String prod: productos){
            System.out.println("prod = "+prod);
        }
        
        //while
        System.out.println("=== Usando while===");
        int i =0;
        while(i < total){
            System.out.println("Para indice: "+i+": "+productos[i]);
        }

        //do/while
        System.out.println("=== Usando do/while===");
        int j =0;
        do {
            System.out.println("Para indice: "+j+": "+productos[j]);
            j++;
        }while (j<total);
