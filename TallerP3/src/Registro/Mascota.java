package Registro;

import java.util.ArrayList;

public class Mascota {

    private String nombre;
    private String especie;
    private int edad;
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void agregarConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    public void mostrarHistorial(){
        System.out.println("Mascota: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
        for (Consulta consu : consultas) {
            consu.mostrarDetallesConsulta();
        }
    }
}
