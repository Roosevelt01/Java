//Clase hija(LargoValidador) heredado de la clase Padre(Validador)
package org.aguzman.pooclasesabstractas.form.validador;

public class LargoValidador extends Validador{
    protected String mensaje = "el campo debe tener mínimo %d carácteres y máximo %d carácteres";
    private int min;
    private int max = Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return false;
    }
}
