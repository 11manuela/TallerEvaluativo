package TallerPractico;

public class Main {

    public static void main(String[] args) {

        //Mostrar en consola la consulta, el diagnostico y tratamiento
        Diagnostico diagnostico = new Diagnostico("Infección pulmonar", "Antibioticos y guardar reposo por 20 días ");

        Consulta consulta = new Consulta ("C015", "07-07-25", diagnostico);

        consulta.mostrarConsulta();
    }
}

