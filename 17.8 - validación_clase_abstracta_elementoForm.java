//Modificación de la clase ElementoForm
package org.aguzman.pooclasesabstractas.form.elementos;

import org.aguzman.pooclasesabstractas.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {
    protected String valor;
    protected String nombre;

    //Modificación #1 
    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        //Modificación #2
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    //Modificación #3
    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    //Modificación #4
    public boolean esValido(){
        for(Validador v: validadores){
            if(!v.esValido(this.valor)){
                this.errores.add(v.getMensaje());
            }
        }
        return this.errores.isEmpty();
    }

    public abstract String dibujarHtml();
}
