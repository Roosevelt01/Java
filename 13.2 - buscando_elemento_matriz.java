int [] [] matrizDeEnteros ={
  {35, 90, 3, 1978},
  {15, 2020, 10, 5},
  {677, 127, 32767, 1999},
};

int elementoBuscar = 15;
boolean encontrado = false;
int i;
int j = 0;

buscar: for(int = 0 ; i < matrizDeEntero.length; i++){
    for(j = 0; j < matrizDeEnteros[i].length;j++){
        encontrado = true;
        break buscar;
    }
}

if(encontrado){
    System.out.println("Encontrado "+ elementoBuscar + " en las coordenadas "+ i + ","+ j);
}else{
   System.out.println(elementoBuscar + " no se encontró ");
}
  