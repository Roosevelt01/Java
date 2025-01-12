package org.aguzman.poointerfaces.imprenta;

import org.aguzman.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo("John Doe", "Ingeniero de sistemas", "Resumen Laboral...");
        cv.addExperiencia("Java");
        cv.addExperiencia("Oracle DBA");
        cv.addExperiencia("Spring Framework");
        cv.addExperiencia("Desarrolador Fullstack");
        cv.addExperiencia("Angula");

        Informe informe = new Informe("Martin Fewler","James", "Estudio sobre microservicio");
        imprimir(cv);
        imprimir(informe);
    }

    public static void imprimir(Hoja imprimible){
        System.out.println(imprimible.imprimir());
    }
}
