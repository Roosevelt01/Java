int [] num = new int[5];

System.out.println("Ingrese un número: ");
for(int i=0;i<num.lenght;i++){
  num[i]=nextInt();
}

int max=0;
for(int i=1;i<num.lenght;i++){
    max=(a[max]>a[i])? max:a[i];
}

System.out.println("max = "+ max);
