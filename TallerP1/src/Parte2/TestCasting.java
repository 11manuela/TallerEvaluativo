package Parte2;
import Parte1.Gato;
import Parte1.Mascota;
import Parte1.Perro;

public class TestCasting {

    public static void main(String[] args) {
        Mascota m = new Gato("Michi");

        // ¿Qué pasa aquí? - Se agrega el instanceof para ejecución sin erorres
        if(m instanceof Perro){
            Perro p = (Perro) m;  // Esto lanza ClassCastException
            p.ladrar();
        }else{
            System.out.println("No es un perro, no se puede ladrar");
        }

        // Ejemplos realizados de casting
        Mascota p = new Perro("Luna");
        if(p instanceof Gato){
            Gato g = (Gato) p;
            g.maullar();
        }else{
            System.out.println("No es un gato, no puede maullar");
        }
        Mascota f = new Perro("Zoe");
        if(f instanceof Perro){
            Perro e = (Perro) f;
            e.ladrar();
        }else{
            System.out.println("No es un perro, no se puede ladrar");
        }
    }
}
