int[] numeros = new int[10]; // Crea un arreglo de 10 enteros llamado "numeros"
int[] a = new int[10];       // Crea otro arreglo de 10 enteros llamado "a"

// Llena el arreglo "numeros" con los números del 1 al 10
for (int i = 0; i < numeros.length; i++) {
    numeros[i] = i + 1;
}

int aux = 0; // Variable auxiliar para controlar los índices del arreglo "a"
for (int i = 0; i < numeros.length / 2; i++) {
    // Copia el elemento actual de "numeros" a "a"
    a[aux++] = numeros[i];
    // Copia el elemento simétrico de "numeros" a "a"
    a[aux++] = numeros[numeros.length - 1 - i];
}

// Imprime los elementos del arreglo "a"
for (int i = 0; i < a.length; i++) {
    System.out.println("a[" + i + "] = " + a[i]);
}
