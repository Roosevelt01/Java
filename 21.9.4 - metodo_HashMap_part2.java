package Set;

import java.util.*;

public class EjemploHashMAp {
    public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>();
        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre","Jhon");
        persona.put("apellido","Doe");
        persona.put("email","jhon.doe@gmail.com");
        persona.put("edad","30");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais","USA");
        direccion.put("estado","California");
        direccion.put("ciudad","Santa Barbara");
        direccion.put("calle","One Street");
        direccion.put("numero","120");

        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);

        String nombre =(String) persona.get("nombre");

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La playa"); //solo para comprobar el false
        System.out.println("El país de "+nombre+" es: "+pais);
        System.out.println("El ciudad de "+nombre+" es: "+ciudad);
        System.out.println("El barrio de "+nombre+" es: "+barrio);

        System.out.println();
        for(String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof  Map){
                String nom = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El pais de "+nom+": "+direccionMap.get("pais"));
                System.out.println("El estado de "+nom+": "+direccionMap.get("estado"));
                System.out.println("El ciudad de "+nom+": "+direccionMap.get("ciudad"));
            }else {
                System.out.println(llave+ " => "+ valor );
            }
        }
    }
}
