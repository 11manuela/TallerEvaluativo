package Relación;

public class Main {

    public static void main(String[] args) {
        Propietario perro1 = new Propietario("Ana");
        Mascota mascota1 = new Mascota("Toby");
        Mascota mascota2 = new Mascota("Luna");

        perro1.agregarMascota(mascota1);
        perro1.agregarMascota(mascota2);

        perro1.mostrarMascotas();
    }
}
