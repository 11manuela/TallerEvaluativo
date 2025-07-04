package Parte1;

public class Main {

//Función del sistema

    public static void main(String[] args) {
        ClinicaVeterinaria c = new ClinicaVeterinaria();

        //Polimorfismo
        Mascota m1 = new Perro("Toby");
        Mascota m2 = new Gato("Pelusa");

        c.recibirMascota(m1);
        c.recibirMascota(m2);
    }
}
