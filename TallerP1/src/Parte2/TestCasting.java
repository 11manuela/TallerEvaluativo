package Parte2;
import Parte1.Gato;
import Parte1.Mascota;
import Parte1.Perro;

public class TestCasting {

    public static void main(String[] args) {
        Mascota mascota2 = new Gato("Michi");

        // ¿Qué pasa aquí? - Se agrega el instanceof para ejecución sin erorres
        if(mascota2 instanceof Perro){
            Perro perro2 = (Perro) mascota2;  // Esto lanza ClassCastException
            perro2.ladrar();
        }else{
            System.out.println("No es un perro, no se puede ladrar");
        }

        // Ejemplos realizados de casting
        Mascota perro3 = new Perro("Luna");
        if(perro3 instanceof Gato){
            Gato gato1 = (Gato) perro3;
            gato1.maullar();
        }else{
            System.out.println("No es un gato, no puede maullar");
        }
        Mascota perro4 = new Perro("Zoe");
        if(perro4 instanceof Perro){
            Perro perro5 = (Perro) perro4;
            perro5.ladrar();
        }else{
            System.out.println("No es un perro, no se puede ladrar");
        }
    }
}
