//Clase EjemploSingleton(main princiapl)
package org.aguzman.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {
        for(int i=0; i < 10; i++){
            ConexionBDSingleton con = ConexionBDSingleton.getInstance();
            System.out.println("con = "+ con);
        }
    }
}

//Clase ConexionBDSingleton
package org.aguzman.patrones.singleton;

public class ConexionBDSingleton {
    private static ConexionBDSingleton instancia;

    private ConexionBDSingleton(){
        System.out.println("Conectándose algún moto de base datos");
    }

    public static ConexionBDSingleton getInstance(){
        if(instancia == null){
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }
}
