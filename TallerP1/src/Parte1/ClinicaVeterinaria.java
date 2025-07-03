package Parte1;

public class ClinicaVeterinaria {

    //Utiliza el instanceof verificando y poder edjecutar un comportamiento

    public void recibirMascota(Mascota m) {
        System.out.println("Recibiendo a: " + m.nombre);
        m.saludar();

        if (m instanceof Perro) {
            ((Perro) m).ladrar();
        } else if (m instanceof Gato) {
            ((Gato) m).maullar();
        } else {
            System.out.println("Tipo de mascota no reconocido.");
        }
    }
}
