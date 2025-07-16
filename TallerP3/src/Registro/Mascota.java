package Registro;

import java.util.ArrayList;

public class Mascota {

    private String nombre;
    private String especie;
    private int edad;
    private int clave;
    //private ArrayList<Consulta> consultas = new ArrayList<>();
    private Historial historial;

    public Mascota(String nombre, String especie, int edad, int clave) {
        /*this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this. consultas = new ArrayList<>();
         */

        //Setters con validación
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        setClave(clave);
        this.historial = new Historial(); //Inicializa un nuevo historial
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    /*public void setNombre(String nombre) {
        this.nombre = nombre;
      }*/
    public void setNombre (String nombre){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre inválido.");

        }
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

   /* public void setEspecie(String especie) {
        this.especie = especie;
    }*/

    public void setEspecie(String especie){
        if (especie == null || especie.isBlank()){
            throw new IllegalArgumentException("Especie inválida");
        }
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    /*public void setEdad(String edad) {
        this.edad = edad;
    }*/

    public void setEdad (int edad){
        if( edad < 0 ){
            throw new IllegalArgumentException(("La edad no puede ser negativa."));
        }
        this.edad = edad;
    }
    //La clase historial se encarga de manejar la lista de consultas
    /*public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }*/

    public void agregarConsulta(Consulta consulta){
       // consultas.add(consulta);
        historial.agregarConsulta(consulta);
    }

    //Información del registro de mascotas
    public void mostrarHistorial(){
        /*System.out.println("Mascota: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);*/
        System.out.println("Mascota: " + nombre + " || Especie: " + especie + " || Edad: " + edad + " años");
        System.out.println("Historial de consultas: ");
        historial.mostrarConsultas();

       /* for (Consulta consu : consultas) { //Se remplazo por historial.mostrarConsulta
            consu.mostrarDetallesConsulta();
        }*/
    }
}
