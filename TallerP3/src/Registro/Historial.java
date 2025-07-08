package Registro;

import java.util.ArrayList;

public class Historial {


    //Se encapsula la lista de las consultas

    private ArrayList<Consulta> consultas;

    public Historial() {
        this.consultas = new ArrayList<>();
    }

    //Agrega una nueva consulta a la mascota
    public void agregarConsulta(Consulta consulta) {
        if (consulta != null) { //Verifica que sea diferente de null
            consultas.add(consulta);
        }
    }

    //Muestra de manera ordenada cada consulta de las mascotas.
    public void mostrarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta consulta : consultas) {
                consulta.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }
    }

    public ArrayList<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}
