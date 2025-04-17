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

    @Override // Indica que estamos sobrescribiendo el método equals de la superclase Object
    public boolean equals(Object obj) {
        if (this == obj) { // Optimización: si son la misma instancia, son iguales
            return true;
        }
        if (obj == null || !(obj instanceof Cuenta)) { // Verifica si el objeto es nulo o no es una instancia de Cuenta
            return false;
        }
         // Castea el objeto a tipo Cuenta
        Cuenta c = (Cuenta) obj;
        // Compara los atributos persona y saldo utilizando Objects.equals para manejar nulos de forma segura
        return Objects.equals(this.persona, c.getPersona()) && Objects.equals(this.saldo, c.getSaldo()); 
    }

}
