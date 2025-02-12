import java.sql.SQLOutput;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        System.out.println("Ejemplo #1");
        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(7);
        System.out.println("r = " + r);// r = false

        System.out.println("\nEjemplo #2");
        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(t2.test("ROLE_ADMIN"));// iMPRIME TRUE

        System.out.println("\nEjemplo #3");
        BiPredicate<String, String> t3 = String::equals; //(a, b) -> a.equals(b);
        System.out.println(t3.test("andres", "pepe"));//imprime false

        System.out.println("\nEjemplo #4");
        BiPredicate<Integer, Integer> t4 = (i, j) -> j > i;
        boolean r2 = t4.test(5,10);
        System.out.println(r2);//Imprime true

        System.out.println("\nEjemplo #5");
        Usuario a = new Usuario();
        Usuario a = new Usuario();
        a.setNombre("Maria");
        a.setNombre("Pepa");
        BiPredicate<Usuario, Usuario> t5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a, b)); //imprime false

    }
}
