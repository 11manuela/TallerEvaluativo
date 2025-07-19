package Modelo;

public class Habitacion {

    private int numero;
    private String tipo;
    private int capacidad;
    private String estado;

    public Habitacion(int numero, String tipo, int capacidad, String estado) {
        setNumero(numero);
        setTipo(tipo);
        setCapacidad(capacidad);
        setEstado(estado);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
