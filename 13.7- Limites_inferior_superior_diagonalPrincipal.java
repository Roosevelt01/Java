int [][] matriz = new int [5][5];

for(int i = 0; i < matriz.length;i++){
    for(int j = 0; j < matriz[i].length;j++){
        matriz[i][j] = 1;  
    }
}

for(int i = 0; i < matriz.length;i++){
    for(int j = 0; j < matriz[i].length;j++){
        System. out. println(matriz[i][j]+"\t");  
    }
}

// Imprime
// 1  0  0  0  0    
// 0  1  0  0  0
// 0  0  1  0  0
// 0  0  0  1  0
// 0  0  0  0  1

int [][] matriz = new int [5][5];

for(int i = 0; i < matriz.length;i++){
    for(int j = 0; j < matriz[i].length;j++){
        if(i == 0 || i == matriz.length-1 || j == 0 || j == matriz[i].length -1 || i==j){
            matriz[i][j] = 1; 
        }  
    }
}

for(int i = 0; i < matriz.length;i++){
    for(int j = 0; j < matriz[i].length;j++){
        System. out. println(matriz[i][j]+"\t");  
    }
}

// Imprime
// 1  1  1  1  1    
// 1  1  0  0  1
// 1  0  1  0  1
// 1  0  0  1  1
// 1  1  1  1  1


