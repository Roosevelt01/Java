int [] numeros = new int[4];

numeros[0] = 10;
numeros[1] = Integer.valueOf("7");
numeros[2] = 35;
numeros[3] = -1;

for(int i=0;i < numeros.lenght -1;i++){
  for(int j=0;j < numeros.leght -1 -i;i++){
      if(((Integer)numeros[j+1]).compareTo(numeros[j]) < 0){
          int auxiliar = numeros[j];
          numeros[j] = numeros[j+1];
          numeros[j+1] = auxiliar
      }
  }
}

for(int i = 0;i < numeros.lenght; i++{
    System.out.println("i = "+i+" : "+ numeros[i]); 
}

