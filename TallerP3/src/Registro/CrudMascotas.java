package Registro;

import java.util.ArrayList;
public class CrudMascotas {

    ArrayList<Mascota> mascotas = new ArrayList<>();

    public class CrudMascota {

        private ArrayList<Mascota> mascotas;

        public CrudMascota() {
            mascotas = new ArrayList<>();
        }

        public ArrayList<Mascota> informacionMascota() {
            return mascotas;
        }

        public Mascota buscar(int clave) {
            for (Mascota m : mascotas) {
                if (m.getClave() == clave) return m;
            }
            return null;
        }

        // Guarda y devuelve true si no existe otra con la misma clave.
        public boolean guardar(Mascota mascota) {
            if (!validar(mascota)) return false;          // datos inválidos
            if (buscar(mascota.getClave()) == null) {
                mascotas.add(mascota);
                return true;
            }
            return false;
        }

        //Elimina por clave
        public boolean eliminar(int clave) {
            for (int i = 0; i < mascotas.size(); i++) {
                if (mascotas.get(i).getClave() == clave) {
                    mascotas.remove(i);
                    return true;
                }
            }
            return false;
        }

        public boolean editar(Mascota masc) {
            if (!validar(masc)) return false;
            for (int i = 0; i < mascotas.size(); i++) {
                if (mascotas.get(i).getClave() == masc.getClave()) {
                    mascotas.get(i).setNombre(masc.getNombre());
                    mascotas.get(i).setEspecie(masc.getEspecie());
                    mascotas.get(i).setEdad(masc.getEdad());
                    return true;
                }
            }
            return false;           // no encontrada
        }

        private boolean validar(Mascota m) {
            if (m.getNombre() == null || m.getNombre().isBlank()) return false;
            if (m.getEspecie() == null || m.getEspecie().isBlank()) return false;
            return m.getEdad() >= 0;
        }
    }
}






      /* Scanner sc = new Scanner(System.in);
        ArrayList<Mascota> mascotas = new ArrayList<>();
        int opcion;

        do {

            System.out.println("\n=== CRUD MASCOTAS ===");
            System.out.println("1. Agregar Mascota");
            System.out.println("2. Listar Mascotas");
            System.out.println("3. Actualizar Mascota");
            System.out.println("4. Eliminar Mascota");
            System.out.println("5 agregar consulta a una mascota: ");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Especie: ");
                    String especie = sc.nextLine();
                    System.out.println("Edad: ");
                    int edad = Integer.parseInt(sc.nextLine());
                    mascotas.add(new Mascota(nombre, especie, edad));
                }
                case 2 -> {
                    if (mascotas.isEmpty()) {
                        System.out.println("No hay mascotas registradas.");
                    } else {
                        for (Mascota m : mascotas) {
                            m.mostrarHistorial();
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Nombre de la mascota a actualizar: ");
                    String buscado = sc.nextLine();
                    boolean encontrado = false;
                    for (Mascota m : mascotas) {
                        if (m.getNombre().equalsIgnoreCase(buscado)) {
                            System.out.print("Nuevo nombre: ");
                            m.setNombre(sc.nextLine());
                            System.out.print("Nueva especie: ");
                            m.setEspecie(sc.nextLine());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Mascota no encontrada.");
                }
                case 4 -> {
                    System.out.print("Nombre de la mascota a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    boolean eliminado = mascotas.removeIf(m -> m.getNombre().equalsIgnoreCase(nombreEliminar));
                    if (!eliminado) System.out.println("Mascota no encontrada.");
                }
                case 5 -> {
                    System.out.println("Nombre de la mascota para agregar consulta");
                    String nombreBuscado = sc.nextLine();
                    boolean encontrada = false;

                    for (Mascota m : mascotas) {
                        if (m.getNombre().equalsIgnoreCase(nombreBuscado)) {
                            // Crear consulta
                            System.out.print("Fecha (YYYY-MM-DD): ");
                            String fecha = sc.nextLine();

                            System.out.print("Nombre del veterinario: ");
                            String nombreVet = sc.nextLine();

                            System.out.print("Especialidad del veterinario: ");
                            String especialidad = sc.nextLine();

                            Veterinario vet = new Veterinario(nombreVet, especialidad);
                            Consulta consulta = new Consulta(IDGenerator.generarCodigoConsulta(), fecha, vet);

                            m.agregarConsulta(consulta);
                            System.out.println("Consulta agregada correctamente.");
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("Mascota no encontrada.");
                    }
                }
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 6);
        sc.close();
 }*/

