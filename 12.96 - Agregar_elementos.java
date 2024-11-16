int[] a = new int[10]; 
int elemento, posicion;
Scanner s = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

// Llena el arreglo "a" con valores ingresados por el usuario
for (int i = 0; i < a.length-1; i++) {
    System.out.print("Ingrese el número: ");
    a[i] = s.nextInt();
}

System.out.print("Nuevo elemento: ");
elemento = s.nextInt();

System.out.print("Posición donde agregar(de 0 a 9): ");
posicion = s.nextInt();

for (int i = a.length - 2; i >= 0; i--) {
    a[i + 1] = a[i];
}

a[posicion] = elemento;

System.out.println("El arreglo:");
for (int i = 0; i < a.length; i++) {
    System.out.println(a[i]);
}
