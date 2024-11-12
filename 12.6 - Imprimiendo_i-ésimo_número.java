// Se solicita diseñar un algoritmo que, dado un arreglo de 10 enteros, genere una secuencia de pares de elementos de la siguiente manera: en la primera iteración, se muestran
// el primer y el último elemento del arreglo; en la segunda iteración, se muestran el segundo y el penúltimo, y así sucesivamente hasta agotar todos los elementos. Se pide detallar el 
// proceso de implementación y proporcionar un ejemplo.

   int[] numeros = new int[10];
        int[] a = new int[10];

        for(int i=0;i<numeros.length;i++){
            numeros[i] = i+1;
        }

        //Arreglo original
        System.out.println("\nArreglo original");
        for(int i=0;i<numeros.length;i++){
            System.out.println(numeros[i]);
        }

        System.out.println("\n");
        for(int i =0;i<numeros.length/2;i++){
            System.out.println(numeros[i] + " - "+numeros[numeros.length - 1 - i]);
        }

        int aux=0;
        for(int i=0;i<numeros.length-i;i++){
            a[aux++] = numeros[i];
            a[aux++] = numeros[numeros.length - 1 -i];
        }

        System.out.println("\nArreglo modificado");
        for(int i=0;i<a.length;i++){
            System.out.println(i+" = "+ a[i]);
        }
