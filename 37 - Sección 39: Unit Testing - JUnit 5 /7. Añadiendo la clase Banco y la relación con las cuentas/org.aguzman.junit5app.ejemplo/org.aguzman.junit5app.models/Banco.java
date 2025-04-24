package org.aguzman.junit5app.ejemplos.models;

// (Imports se añadirán después)

public class Banco {
    private List<Cuenta> cuentas;//Lista de cuentas asociadas
    private String nombre; // Nombre del banco

    // --- Getters y Setters para nombre ---
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //Getter para cuentas
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    //Setter para cuentas
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    // Paso 7: Método para añadir una cuenta a la lista
    public void addCuenta(Cuenta cuenta){
        // Si la lista no se inicializa en el constructor, esto dará NullPointerException
        if (this.cuentas == null) {
             this.cuentas = new ArrayList<>(); // Inicialización perezosa (alternativa)
        }
        this.cuentas.add(cuenta);
        // Falta establecer la relación inversa: cuenta.setBanco(this);
    }
     
    //Transfiere un monto específico desde una cuenta origen a una cuenta destino.
    //origen Cuenta desde la que se debita el monto.
    //destino Cuenta a la que se acredita el monto.
    //monto Monto a transferir (BigDecimal).
    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto){
        // Llama al método debito de la cuenta origen
        origen.debito(monto);
        // Llama al método credito de la cuenta destino
        destino.credito(monto);
    }
}