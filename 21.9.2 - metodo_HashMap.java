package Set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMAp {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1 - Método remove");
        Map<String, String> persona = new HashMap<>();
        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre","Jhon");
        persona.put("apellido","Doe");
        persona.put("email","jhon.doe@gmail.com");
        persona.put("edad","30");

        System.out.println("persona = "+ persona);

        String nombre = persona.get("nombre");
        System.out.println("nombre = "+nombre);

        //String apellidoPaterno = persona.remove("paellidoPaterno");
        boolean b = persona.remove("apellido", "Doe");
        System.out.println("Eliminado: "+b);
        System.out.println("Persona = "+persona);

        System.out.println("\nEjemplo containskey");
        boolean b2 = persona.containsKey("apellido");
        System.out.println("b2: "+b2);

        System.out.println("\nEjemplo #2 - containsValue");
        Map<String, String> persona2 = new HashMap<>();
        persona2.put(null, "1234");
        persona2.put(null, "12345");
        persona2.put("nombre","Jhon");
        persona2.put("apellido","Doe");
        persona2.put("email","jhon.doe@gmail.com");
        persona2.put("edad","30");

        System.out.println("persona = "+ persona2);

        boolean b3 = persona2.containsValue("30");
        System.out.println("b3 = "+b3);

        System.out.println("\nEjemplo #3 - Value()");
        Map<String, String> persona3 = new HashMap<>();
        persona3.put(null, "1234");
        persona3.put(null, "12345");
        persona3.put("nombre","Jhon");
        persona3.put("apellido","Doe");
        persona3.put("email","jhon.doe@gmail.com");
        persona3.put("edad","30");

        System.out.println("persona = "+ persona3);

        Collection<String> valores = persona3.values();
        for(String v: valores){
            System.out.println(v);
        }

        System.out.println("\nEjemplo #4 - keySet()");
        Map<String, String> persona4 = new HashMap<>();
        persona4.put(null, "1234");
        persona4.put(null, "12345");
        persona4.put("nombre","Jhon");
        persona4.put("apellido","Doe");
        persona4.put("email","jhon.doe@gmail.com");
        persona4.put("edad","30");

        System.out.println("persona = "+ persona4);

        Set<String> llaves = persona4.keySet();
        for(String k: llaves){
            System.out.println(k);
        }

        System.out.println("\nEjemplo #5 - entrySet");
        Map<String, String> persona5 = new HashMap<>();
        persona5.put(null, "1234");
        persona5.put(null, "12345");
        persona5.put("nombre","Jhon");
        persona5.put("apellido","Doe");
        persona5.put("email","jhon.doe@gmail.com");
        persona5.put("edad","30");

        for (Map.Entry<String, String> par: persona5.entrySet()){
            System.out.println(par.getKey() + " => "+par.getValue());
        }

        System.out.println("\n");
        for(String llave: persona5.keySet()){
            String valor = persona.get(llave);
            System.out.println(llave + " => "+valor);
        }

        System.out.println("\nEjemplo #6 - interación-foreach");
        Map<String, String> persona6 = new HashMap<>();
        persona6.put(null, "1234");
        persona6.put(null, "12345");
        persona6.put("nombre","Jhon");
        persona6.put("apellido","Doe");
        persona6.put("email","jhon.doe@gmail.com");
        persona6.put("edad","30");

        persona5.forEach((keys, values) ->{
            System.out.println(keys + " => " + values);

        });

        System.out.println("\nEjemplo #7 - size()");
        Map<String, String> persona7 = new HashMap<>();
        persona7.put(null, "1234");
        persona7.put(null, "12345");
        persona7.put("nombre","Jhon");
        persona7.put("apellido","Doe");
        persona7.put("email","jhon.doe@gmail.com");
        persona7.put("edad","30");

        System.out.println("Total: "+persona6.size());
        System.out.println("Contiene elementos: " +!persona6.isEmpty());

        System.out.println("\nEjemplo #8 - replace()");
        Map<String, String> persona8 = new HashMap<>();
        persona8.put(null, "1234");
        persona8.put(null, "12345");
        persona8.put("nombre","Jhon");
        persona8.put("apellido","Doe");
        persona8.put("email","jhon.doe@gmail.com");
        persona8.put("edad","30");

        persona8.replace("nombre","Alejandro");
        System.out.println("persona8  = "+ persona8);
    }
}
