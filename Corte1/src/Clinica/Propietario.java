package Clinica;

import java.util.ArrayList;

public class Propietario {

    private String nombre;
    private String documento;
    private String telefono;
    private ArrayList<Mascota> mascotas = new ArrayList<>(); //Relación uno a muchos

    public Propietario(String nombre, String documento, String telefono) {
        /*this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;*/
        //Refactor: se usa setters con validaciones
        setNombre(nombre);
        setDocumento(documento);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();

    }
    //Añade una mascota a la lista
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public String getNombre() {
        return nombre;
    }

    /*public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/

    //Validación del nombre
    public void setNombre(String nombre){
        if (nombre == null | nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    /*public void setTelefono(String telefono) {
        this.telefono = telefono;
    }*/

    //Refactor Telefono
    public void setTelefono(String telefono){
        if(telefono == null || telefono.length()<7){
            throw new IllegalArgumentException("Telefono inválido.");
        }
        this.telefono = telefono;
    }


    /*public void setDocumento(String documento) {
        this.documento = documento;
    }*/
    //Refactor Documento
    public void setDocumento(String documento){
        if (documento == null || documento.length()<5){
            throw new IllegalArgumentException("Documento inválido.");
        }
        this.documento = documento;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    //Se elimina para proteger la colección interna
    /*public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }*/

    public void mostrarInformación() {
        System.out.println("Nombre del propietario: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Telefono: " + telefono);
      /*  for (Mascota m : mascotas) { //Separe la responsabilidad para que sea mucho mas oredenado
            m.mostrarHistorial();*/

    }

    //Muestra la información de cada mascota con su historial.
    public void mostrarMascotas() {
        for (Mascota m : mascotas) {
            System.out.println();
            m.mostrarHistorial();

        }

    }
}
