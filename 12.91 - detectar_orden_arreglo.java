int [] a = new int[7];
Scanner s = new Scanner(System.in);

System.out.println("Ingrese un número");
for(int i=0;i<a.lenght;i++){
 a[i] = s.nextInt();
}

boolean ascend=false;
boolean descend=false;
for(int i=0;i<a.lenght;i++){
  if(a[i]>a[i+1]){
    descend=true;   
  } 

  if(a[i]<a[i+1]){
    ascend=true;
  }
}

if(ascend == true && descend == true){
    System.out.println("El arreglo está desordenado");  
}  

if(ascend == false && descend == false){
  System.out.println("Los elementos del arreglo son iguales");
}

if(ascend == true && descend == false){
  System.out.println("El arreglo está ordenado de forma ascendente");
}

if(ascend == false && descend == false){
  System.out.println("El arreglo está ordenado de forma descendente");
}
  
