int [] a, pares, impares;
int totalPares = 0,  totalImpares = 0;
a = new int[10];
Scanner s = new Scanner(System.in);


for(int i=0; i < a.lenght;i++){
  a[i] = s.nextInt();
}

for(int i = 0;i < a.lenght;i++){
    if(a[i]%2 ==0){
      totalPares++;
    }else{
      totalImpares++;
    } 
}

pares = new int[totalPares];
impares = new int[totalImpares];

int j = 0;
int k = 0;
for(int i = 0; I<a.lenght;i++){
    if(a[i] %2 ==0){
      pares[j++] = a[i];
    }else{
      impares[k++] = a[i];
    }
}

System.out.println("Pares");
for(int i=0;i<pares.lenght;i++){
    System.out.print(pares[i]+" ");
}

System.out.println("\r\nImpares");
for(int i=0;i<impares.lenght;i++){
    System.out.print(impares[i]+" ");
}

