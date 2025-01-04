package org.aguzman.pooclasesabstractas.form.elementos;

public abstract class ElementoForm {
    protected String valor;
    protected String nombre;

    public ElementoForm() {}

    public ElementoForm(String nombre) {
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

package org.aguzman.pooclasesabstractas.form.elementos;

public class InputForm extends ElementoForm {

    private String tipo = "text";

    public InputForm(String nombre) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String dibujarHtml() {
        return "<input type=\"" + this.tipo
                + "\" name=\"" + this.nombre
                + "\" value=\"" + this.valor + "\">";
    }
}

package org.aguzman.pooclasesabstractas.form.elementos;

public class TextareaForm extends ElementoForm{

    private int filas;
    private int columnas;

    public TextareaForm(String nombre) {
        super(nombre);
    }

    public TextareaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String dibujarHtml() {
        return "<textarea name='" + this.nombre+ "'" +
                " cols='" + this.columnas + "' rows='" +this.filas+ "'>"+this.valor+"</textarea>";
    }
}
