package Parte2;

import Parte1.Gato;
import Parte1.Mascota;
import Parte1.Perro;

public class TestCastingSeguro {

    public static void main(String[] args) {
        Mascota mascota1 = new Gato("Michi");

        if (mascota1 instanceof Perro) {
            Perro perro1 = (Perro) mascota1;
            perro1.ladrar();
        } else {
            System.out.println("No es un perro, no se puede ladrar.");
        }
    }

}
