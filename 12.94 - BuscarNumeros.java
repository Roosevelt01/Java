int[] a = new int[10];
Scanner s = new Scanner(System.in);

for(int i = 0; i < a.length; i++){
  System.out.print("Ingrese un número");
  a[i] = s.nextInt();
}

System.out.print("\r\nIngrese un número a buscar: ");
int num = s.nextInt();
int i = 0;
while(i < a.length && a[i] != num){
  i++;
}

if(i == a.length){ 
  System.out.print("Número no encontrado");
}else if(i[i] == num){
  System.out.print("Encontrado en la posición: "+i);
}

//Para buscar de tipo String

int[] a = new String[4];
Scanner s = new Scanner(System.in);

for(int i = 0; i < a.length; i++){
  System.out.print("Ingrese un nombre");
  a[i] = s.nextInt();
}

  System.out.print("\r\nIngrese un nombre a buscar: ");
  int String = s.next();
  int i = 0;
  for(;i<a.lenght && !a[i]equalsIgnoreCase(nombre);i++){
    if(i == a.length){ 
      System.out.print("Número no encontrado");
    }else if(a[i].toLowerCase().compareTo(nombre.toLowerCase())==0){
      System.out.print("Encontrado en la posición: "+i);
    }
  }
