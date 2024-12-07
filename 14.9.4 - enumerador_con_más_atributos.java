public enum DiaSemana {
    LUNES(false), MARTES(false), MIERCOLES(false), JUEVES(false),
    VIERNES(false), SABADO(true), DOMINGO(true);

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

        if(hoy.esFinDeSemana()){
            System.out.println("¡Es fin de semana!");
        } else {
            System.out.println("Es día laboral.");
        }
    }
}

