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

        // ¿Que pasa si se envía una clase que no hereda a mascotas?
        //No podría tener los métodos y atributos de la clase padre.
        // ¿Cómo se comporta si eliminas el instanceof y casteas directamente?
        //El instanceof permite verificar antes del casteo lo cual es obligatorio hacerlo
        // ya que si no se hace en tiempo de ejecución habría un error ClassCastException.
    }
}
