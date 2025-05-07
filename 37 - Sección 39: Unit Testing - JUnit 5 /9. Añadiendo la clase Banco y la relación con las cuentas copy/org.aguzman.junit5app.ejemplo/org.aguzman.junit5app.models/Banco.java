package org.aguzman.junit5app.ejemplos.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;
    private String nombre;

    public Banco() {//Paso 1: Constructor sin parámetros: inicializa la lista de cuentas vacía 
        cuentas = new ArrayList<>();// inicializa la lista para evitar NullPointerException
    }

    // ... (Otro constructor si existe, getters y setters para nombre y cuentas) ...

    // ... (Método addCuenta y transferir) ...

    public Banco(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        cuenta.setBanco(this);// Paso 4: asigna este banco a la cuenta para mantener la relación
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto){
        origen.debito(monto);
        destino.credito(monto);
    }
}
