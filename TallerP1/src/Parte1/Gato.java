package Parte1;

//Subclase
public class Gato extends Mascota {

    public Gato(String nombre) {
        super(nombre);
    }

    public void maullar() {
        System.out.println(nombre + " dice: ¡Miau!");
    }
}
