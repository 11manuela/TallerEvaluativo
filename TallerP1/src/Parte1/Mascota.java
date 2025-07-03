package Parte1;

public class Mascota {

    //Protegido pero aun asi las clases hijas pueden acceder
    protected String nombre;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}
