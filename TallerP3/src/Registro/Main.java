package Registro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

      /*  //Registro del propietario
        Scanner sc = new Scanner(System.in); //Crea lector desde el teclado
        System.out.println("----------------------------");
        System.out.println(" \n REGISTRO DEL PROPIETARIO ");
        System.out.println("Nombre: ");
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
            System.out.println("Mascota: "+(mascotas+1));
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Especie: ");
            String especie = sc.nextLine();
            System.out.println("Edad: ");
            String edad = sc.nextLine();
            System.out.println("----------------------------");

            Mascota mascota = new Mascota(nombre, especie, edad);
            propietario.agregarMascota(mascota);

            System.out.println(" \n¿Cuantas consultas desea registrar?: ");
            int cantidadConsultas = Integer.parseInt(sc.nextLine());

            for (int consultas = 0; consultas < cantidadConsultas; consultas++) {
                System.out.println("Consulta: " +(consultas+1));
                System.out.println("Codigo: ");
                String codigo = sc.nextLine();
                System.out.println("Fecha: ");
                String fecha = sc.nextLine();
                System.out.println("Nombre del veterinario: ");
                String nombreVeterinario = sc.nextLine();
                System.out.println("Especialidad: ");
                String especialidad = sc.nextLine();
                System.out.println("----------------------------");

                Veterinario veterinario = new Veterinario(nombreVeterinario, especialidad);
                Consulta consulta = new Consulta(codigo, fecha, veterinario);
                mascota.agregarConsulta(consulta);

            }

            System.out.println(" \n FICHA CLÍNICA");
            System.out.println("Propietario: " + propietario.getNombre());
            System.out.println("Documento: " + propietario.getDocumento());
            System.out.println("Telefono: " + propietario.getTelefono());

            for (Mascota masc : propietario.getMascotas()) {
                System.out.println("Mascota: " + mascota.getNombre() + " | Especie: " + mascota.getEspecie() + " | Edad: " + mascota.getEdad());

                System.out.println(("\n HISTORIAL DE CONSULTAS "));

                for (Consulta consulta : mascota.getConsultas()) {
                    System.out.println("Codigo de la consulta: " + consulta.getCodigo());
                    System.out.println("Fecha: " + consulta.getFecha());
                    System.out.println("Veterinario: " + consulta.getVeterinario().getNombre());
                    System.out.println("Especialidad: " + consulta.getVeterinario().getEspecialidad());

                    System.out.println("----------------------------");

                }
            }
        }
        sc.close();*/

            Scanner sc = new Scanner(System.in);

            // === Registro del Propietario ===
            System.out.println("=== Registro del Propietario ===");
            System.out.print("Nombre: ");
            String nombreProp = sc.nextLine();

            System.out.print("Documento: ");
            String documento = sc.nextLine();

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();

            Propietario propietario = new Propietario(nombreProp, documento, telefono);

            // === Registro de Mascotas ===
            System.out.print("\n¿Cuántas mascotas desea registrar?: ");
            int numMascotas = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= numMascotas; i++) {
                System.out.println("\n--- Mascota #" + i + " ---");

                System.out.print("Nombre de la mascota: ");
                String nombreMascota = sc.nextLine();

                System.out.print("Especie: ");
                String especie = sc.nextLine();

                System.out.print("Edad: ");
                int edad = Integer.parseInt(sc.nextLine());

                // Usar código automático para la mascota (no almacenado aún)
                Mascota mascota = new Mascota(nombreMascota, especie, edad);
                propietario.agregarMascota(mascota);

                // === Registro de Consultas ===
                System.out.print("¿Cuántas consultas desea agregar a esta mascota?: ");
                int numConsultas = Integer.parseInt(sc.nextLine());

                for (int j = 1; j <= numConsultas; j++) {
                    System.out.println("-> Consulta #" + j);

                    // Código automático con IDGenerator
                    String codigo = IDGenerator.generarCodigoConsulta();

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.println("Información del veterinario:");
                    System.out.print("Nombre: ");
                    String nombreVet = sc.nextLine();

                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();

                    Veterinario vet = new Veterinario(nombreVet, especialidad);
                    Consulta consulta = new Consulta(codigo, fecha, vet);

                    mascota.agregarConsulta(consulta);
                }
            }

            // Mostrar resultados
            System.out.println("\n===== FICHA CLÍNICA COMPLETA =====");
            propietario.mostrarInformación();
            propietario.mostrarMascotas();

            sc.close();
        }

    /*
    public static void main(String[] args) {
        // Este bloque de código fue reemplazado por una versión más segura con validaciones,
        // generación de códigos únicos y uso de LocalDate.
    }
    */
}

