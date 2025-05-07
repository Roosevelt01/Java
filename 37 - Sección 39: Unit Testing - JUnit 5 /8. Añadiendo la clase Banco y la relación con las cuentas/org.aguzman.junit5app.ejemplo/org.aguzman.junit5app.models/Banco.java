package org.aguzman.junit5app.ejemplos.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;


//Representa un banco con cuentas y operaciones de transferencia
public class Banco {
    private List<Cuenta> cuentas = new ArrayList<>(); // Lista de cuentas
    private String nombre;

    // Constructor vacío (inicializa lista automáticamente)
    public Banco() {}

    // Getters y setters básicos
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Cuenta> getCuentas() { return cuentas; }

    
    // Agrega cuenta al banco y establece relación bidireccional
    // cuenta Cuenta a agregar
    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
        cuenta.setBanco(this); // Relación inversa
    }

    // Transfiere monto entre cuentas
    // origen Cuenta que envía
    // destino Cuenta que recibe
    // monto Cantidad a transferir
    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto) {
        origen.debito(monto);  // Resta de origen
        destino.credito(monto); // Suma a destino
    }
}