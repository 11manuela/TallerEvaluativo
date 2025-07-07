package Registro;
import java.time.LocalDate;
public class Consulta {

    //Refactor
    private String codigo;
   // private String fecha;
    private Veterinario veterinario;
    private LocalDate fecha;


    public Consulta(String codigo, String fecha, Veterinario veterinario) {
       /*  this.codigo = codigo;
        this.fecha = fecha;
        this.veterinario = veterinario; */
        //Validación y conversión de fecha
        setCodigo(codigo);
        setFecha(fecha);
        setVeterinario(veterinario);
    }

    public String getCodigo() {
        return codigo;
    }

    /*public void setCodigo(String codigo) {
        this.codigo = codigo;
    }*/

    public void setCodigo(String codigo){

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public void mostrarDetallesConsulta() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Fecha: " + fecha);
        if(veterinario != null){
            veterinario.mostrarPerfil();
        }else{
            System.out.println("Sin veterinario asignado.");
        }
        System.out.println("Veterinario: " + veterinario.getEspecialidad());

    }
}
