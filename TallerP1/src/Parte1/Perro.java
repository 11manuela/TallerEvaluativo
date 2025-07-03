package Parte1;

//Subclase
public class Perro extends Mascota {

    public Perro(String nombre) {
        super(nombre);
    }

    public void ladrar() {
        System.out.println(nombre + " dice: ¡Guau!");
    }
}
