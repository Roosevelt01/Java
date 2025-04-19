package org.aguzman.junit5app.ejemplos.models;

import org.aguzman.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;

    public Cuenta(String persona, BigDecimal saldo) {
        this.persona = persona;
        this.saldo = saldo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void debito(BigDecimal monto){
        // Calcular el saldo potencial después del débito
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);

        // Comparar el nuevo saldo con cero
        // compareTo() retorna:
        // -1 si nuevoSaldo es menor que BigDecimal.ZERO
        //  0 si nuevoSaldo es igual a BigDecimal.ZERO
        //  1 si nuevoSaldo es mayor que BigDecimal.ZERO
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){ // Si el nuevo saldo es negativo (< 0)
            // Si el saldo es insuficiente, lanzar la excepción personalizada
            throw new DineroInsuficienteException("Dinero Insuficiente"); // Lanzar la excepción con un mensaje
        }

        // Si hay saldo suficiente, actualizar el atributo saldo
        this.saldo = nuevoSaldo; // Reasignar el nuevo saldo si no se lanzó la excepción
    }


    public void credito(BigDecimal monto){
        this.saldo = this.saldo.add(monto);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cuenta)){
            return false;
        }

        Cuenta c = (Cuenta) obj;
        if(this.persona == null || this.saldo == null){
            return  false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());

    }
}
