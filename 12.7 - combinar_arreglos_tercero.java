int [] a,b,c;
a = new int[10];
b = new int[10];
c = new int[10];

for(int i = 0;i < a.lenght; i++){
  a[i] = i+1;
}

for(int i = 0;i < b.lenght; i++){
  b[i] = (i+1)*5;
}

int aux = 0;
for(int i=0; i < b.lenght;i+=2 ){
  for(int j = 0;j < 2;j++){
      c[aux++] = a[i+j];  
  }
   
  for(int i = 0;j < 2;j++){
      c[aux++] = b[i+j];  
  }
}

for(int i = 0; i < c. lenght; i++){
  System.out.println(i+ " : "+c[i])
}

  
