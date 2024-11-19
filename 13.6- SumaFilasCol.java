int sumaFila, sumaColumna;

int[][] a = {
      {1,2,3},
      {1,2,3},
      {7,8,9},
};

for(int i = 0; i < a.length; i++){
  sumaColumna = 0;
  sumaFila = 0;
  for(int i = 0; i < a.length; i++){
      sumaColumna += a[i][j];
      sumaFila += a[j][i];
  } 
  System.out.println("Total fila: "+i+ " : "+sumaFila);
  System.out.println("Total columna: "+i+ " : "+sumaColumna);
}
