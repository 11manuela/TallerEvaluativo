package Registro;

import java.util.ArrayList;

public class Propietario {

    private String nombre;
    private int documento;
    private int telefono;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Propietario(String nombre, int documento, int telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);
    }

    public void mostrarInformación() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Telefono: " + telefono);
        for (Mascota m : mascotas) {
            m.mostrarHistorial();
    }
}
