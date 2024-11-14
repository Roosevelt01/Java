int[] a = new int[10]; // Crea un arreglo de 10 enteros llamado "a"
int ultimo; // Variable para almacenar el último elemento del arreglo

Scanner s = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

// Llena el arreglo "a" con valores ingresados por el usuario
for (int i = 0; i < a.length; i++) {
    System.out.print("Ingrese el número: ");
    a[i] = s.nextInt();
}

// Guarda el último elemento del arreglo en la variable "ultimo"
ultimo = a[a.length - 1];

// Desplaza todos los elementos del arreglo una posición hacia la derecha
for (int i = a.length - 2; i >= 0; i--) {
    a[i + 1] = a[i];
}

// Coloca el elemento que estaba al final al principio del arreglo
a[0] = ultimo;

System.out.println("El arreglo:");
// Imprime los elementos del arreglo modificado
for (int i = 0; i < a.length; i++) {
    System.out.println(a[i]);
}
