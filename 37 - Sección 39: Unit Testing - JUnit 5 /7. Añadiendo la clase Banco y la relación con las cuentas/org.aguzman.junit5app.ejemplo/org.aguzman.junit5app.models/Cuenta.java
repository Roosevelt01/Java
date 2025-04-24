package org.aguzman.junit5app.ejemplos.models;

import org.aguzman.junit5app.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;
    private Banco banco;// Referencia al banco al que pertenece

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

    //Getter para banco
    public Banco getBanco() {
        return banco;
    }

    //Setter para banco
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void debito(BigDecimal monto){
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new DineroInsuficienteException("Dinero Insuficiente");
        }
        this.saldo = nuevoSaldo;
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




public class Cuenta {
    // ... (campos persona, saldo y constructor) ...
    private Banco banco; // Paso 8: Referencia al banco al que pertenece

    // ... (get/set Persona, get/set Saldo) ...

    // Paso 9: Getter para banco
    public Banco getBanco() {
        return banco;
    }

    // Paso 10: Setter para banco
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    // ... (métodos debito, credito, equals) ...
}