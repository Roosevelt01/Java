package Set;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMAp {
    public static void main(String[] args) {
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
        
    }
}
