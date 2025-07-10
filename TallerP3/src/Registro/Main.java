package Registro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Registro del propietario
        Scanner sc = new Scanner(System.in); //Crea lector desde el teclado
        System.out.println("----------------------------");
        System.out.println(" \n REGISTRO DEL PROPIETARIO ");
        System.out.println("Nombre del propietario: ");
        String nombrePropietario = sc.nextLine();//nextline lee una linea completa
        System.out.println("Documento: ");
        String documentoPropietario = sc.nextLine();
        System.out.println("Telefono: ");
        String telefonoPropietario = sc.nextLine();
        System.out.println("----------------------------");

        Propietario propietario = new Propietario(nombrePropietario, documentoPropietario, telefonoPropietario);

        //Registro de mascotas
        System.out.println(" \n REGISTRO DE LAS MASCOTAS ");
        System.out.println(" \n ¿Cuantas mascotas deseas registrar?");
        int cantMascotas = Integer.parseInt(sc.nextLine());

        for (int mascotas = 0; mascotas < cantMascotas; mascotas++) {
            System.out.println("Mascota: " + (mascotas + 1));
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Especie: ");
            String especie = sc.nextLine();
            System.out.println("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            System.out.println("----------------------------");

            //Usar codigo automatico para la mascota
            Mascota mascota = new Mascota(nombre, especie, edad);
            propietario.agregarMascota(mascota);

            //Registro de consultas
            System.out.println(" \n¿Cuantas consultas desea registrar?: ");
            int cantidadConsultas = Integer.parseInt(sc.nextLine());

            for (int consultas = 0; consultas < cantidadConsultas; consultas++) {
                System.out.println("Consulta: " + (consultas + 1));

                //Codigo automatico con IDGenerator
                String codigo = IDGenerator.generarCodigoConsulta();

                /*System.out.println("Codigo: ");
                String codigo = sc.nextLine();
                System.out.println("Fecha: ");*/
                System.out.print("Fecha (YYY-MM-DD): "); //Se implementa el uso del LocalDate
                String fecha = sc.nextLine();

                System.out.println("Información del veterinario: ");
                System.out.println("Nombre del veterinario: ");
                String nombreVeterinario = sc.nextLine();
                System.out.println("Especialidad: ");
                String especialidad = sc.nextLine();
                System.out.println("----------------------------");

                Veterinario veterinario = new Veterinario(nombreVeterinario, especialidad);
                Consulta consulta = new Consulta(codigo, fecha, veterinario);
                mascota.agregarConsulta(consulta);

            }
            //Remplazo por propietario.mostrarInformación y propietario.mostrarMascotas ya que de esta manera es más organizado.
            /*System.out.println("Propietario: " + propietario.getNombre());
            System.out.println("Documento: " + propietario.getDocumento());
            System.out.println("Telefono: " + propietario.getTelefono());

            for (Mascota masc : propietario.getMascotas()) {
                System.out.println("Mascota: " + mascota.getNombre() + " | Especie: " + mascota.getEspecie() + " | Edad: " + mascota.getEdad());*/

                /*for (Consulta consulta : mascota.();) {
                    System.out.println("Codigo de la consulta: " + consulta.getCodigo());
                    System.out.println("Fecha: " + consulta.getFecha());
                    System.out.println("Veterinario: " + consulta.getVeterinario().getNombre());
                    System.out.println("Especialidad: " + consulta.getVeterinario().getEspecialidad());*/

            //
            System.out.println(" \n FICHA CLÍNICA");
            propietario.mostrarInformación(); // Permite mostrar los datos del propietario.
            propietario.mostrarMascotas(); //Muestra a las mascotas y su historial correspondiente.

            System.out.println("----------------------------");
            sc.close();

        }
    }
}
