package org.aguzman.junit5app.ejemplos.models;

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
        // BigDecimal es inmutable, por lo que la operación subtract() devuelve un *nuevo* BigDecimal.
        // Es necesario reasignar este nuevo valor al atributo saldo.
        this.saldo = this.saldo.subtract(monto);
    }

    public void credito(BigDecimal monto){
        // BigDecimal es inmutable, la operación add() devuelve un *nuevo* BigDecimal.
        // Se reasigna el nuevo valor al atributo saldo.
        this.saldo = this.saldo.add(monto);
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (obj == null || !(obj instanceof Cuenta)) { 
            return false;
        }
        Cuenta c = (Cuenta) obj; 
        return Objects.equals(this.persona, c.getPersona()) && Objects.equals(this.saldo, c.getSaldo());
    }
}
