package Relación;

import java.util.ArrayList;

public class Propietario {

    private String nombre;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void mostrarMascotas() {
        for (Mascota mascota1: mascotas) {
            mascota1.mostrarInfo();
        }
    }
}
