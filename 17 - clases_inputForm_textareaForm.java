package org.aguzman.pooclasesabstractas.form.elementos;

public abstract class elementoForm {
    protected String valor;
    protected String nombre;

    public elementoForm() {}

    public elementoForm(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract String dibujarHtml();
}
