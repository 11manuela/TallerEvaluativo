package Relación;

public class Mascota {

    private String nombre;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre);
    }
}
