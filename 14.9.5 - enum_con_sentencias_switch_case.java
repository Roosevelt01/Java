public enum DiaSemana {
    LUNES(false), MARTES(false), MIERCOLES(false), JUEVES(false),
    VIERNES(false), SABADO(false), DOMINGO(true);

    private final boolean esFinDeSemana;

    DiaSemana(boolean esFinDeSemana) {
        this.esFinDeSemana = esFinDeSemana;
    }

    public boolean esFinDeSemana() {
        return esFinDeSemana;
    }
}

public class EjemploDiaSemana {
    public static void main(String[] args) {
        DiaSemana hoy = DiaSemana.SABADO;

        switch (hoy){
            case LUNES -> System.out.println("Es hoy es Lunes");

            case MARTES -> System.out.println("Es hoy es Martes");

            case MIERCOLES -> System.out.println("Es hoy es Miercoles");

            case JUEVES -> System.out.println("Es hoy es Jueves");

            case VIERNES -> System.out.println("Es hoy es Viernes");

            case SABADO -> System.out.println("Es hoy es Sábado");

            case DOMINGO -> System.out.println("Es hoy es Domingo");
        }
    }
}

