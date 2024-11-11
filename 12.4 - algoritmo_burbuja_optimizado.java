String[] productos = {"Kingston Pendrive 64GB", "Samsung Galaxy", 
                      "Disco Duro SSD Samsung Externo", "Asus Notebook", 
                      "Macbook Air", "Chromecast 4ta generación", "Bicicleta Oxford"};

int total = productos.length;

for (int i = 0; i < total-1; i++) {
    for (int j = i + 1; j < total -1 -i; j++) {
        if (productos[j+1].compareTo(productos[j]) > 0) {
            String auxiliar = productos[j];
            productos[j] = productos[j+1];
            productos[j+1] = auxiliar;
        }
    }

for(int i =0 ;i <total;i++){
  system.out.println(producto[i]);
}
  
