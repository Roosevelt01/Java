int [][] matriz = {
    {1,2,3,4},
    {5,6,7,8},
    {9,10,11,12},
    {13,14,15,16}
};


System.out.print("Matriz original");
for(int i = 0; i < matriz.lenght; i++){
  for(int j = 0; j < matriz[i].lenght; j++){
      System.out.print(matriz[i][j]+ "\t");
  }
  System.out.print();
}

int aux;
for(int i = 0; i < matriz.length; i++){
  for(int j = 0; j < i; j++){
      aux = matriz[i][j];
      matriz[i][j] = matriz[j][i];
      matriz[j][i] = aux;
  }
}

System.out.print("Matriz transpuesta");
for(int i = 0; i < matriz.lenght; i++){
  for(int j = 0; j < matriz[i].lenght; j++){
      System.out.print(matriz[i][j]+ "\t");
  }
  System.out.print();
}



