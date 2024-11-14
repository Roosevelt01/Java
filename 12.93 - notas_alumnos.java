double [] claseMatematicas, claseHistoria, claseLenguaje;
double sumNotasMatematicas=0, sumNotasHistoria=0, sumNotasLenguaje= 0;
claseMatematicas = new double[7];
claseHistoria = new double[7];
claseLenguajes = new double[7];


Scanner s = new Scanner(System.in);
System.out.println("Ingrese 7 notas de estudiadiantes para matemáticas");
for(int i=0;i<claseMatematicas.lenght;i++){
  claseMatematicas[i] = n.nextDouble();
}

System.out.println("Ingrese 7 notas de estudiadiantes para historias");
for(int i=0;i<claseHistoria.lenght;i++){
  claseHistoria[i] = n.nextDouble();
}

System.out.println("Ingrese 7 notas de estudiadiantes para lenguaje");
for(int i=0;i<claseLenguaje.lenght;i++){
  claseLenguaje[i] = n.nextDouble();
}

for(int i= 0 ; i < 7 ; i++){
    sumNotasMatematicas += claseMatematicas[i];
    sumNotasHistoria += claseHistoria[i];
    sumNotasLenguaje += claseLenguaje[i];
}

double promedioMatematica = (SumNotasMatematicas/claseMatemicas.lenght);
double promedioHistoria = (SumNotasHistoria/claseHistoria.lenght);
double promedioLenguaje = (SumNotasLenguaje/claseLenguaje.lenght);

System.out.println("Promedio clase matemáticas: "+ promedioMatematica);
System.out.println("Promedio clase Historia: "+ promedioHistoria);
System.out.println("Promedio clase Lenguaje: "+ promedioLenguaje);
System.out.println("Promedio total del curso: "+ (promedioMatematica+promedioHistoria+promedioLenguaje)/3);

System.out.println("Ingrese el identificador del alumno(de 0 -6): "+);
int id = s.nextInt();
double promedioAlumno = (claseHistoria[i]+(claseLenguaje[i]+(claseMatematicas[i]/3);
System.out.println("Promedio alumno Nro: : "+id+ " : "+promedioAlumno);

