public class Diagnostico {

    //Atributos
    private String descripcion;
    private String tratamiento;

    //Constuctor
    public Diagnostico(String descripcion, String tratamiento) {
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    //Metodo que retorna true si el tratamiento es largo cuando es mayor a 30 caracteres
    public boolean esTratamientoLargo(){
        return tratamiento.length() > 30;
    }
}
