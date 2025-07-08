package Registro;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Consulta {

    //Refactor
    private String codigo;
   // private String fecha;
    private Veterinario veterinario;
    private LocalDate fecha; //Uso del LocalDate


    public Consulta(String codigo, String fecha, Veterinario veterinario) {
       /*  this.codigo = codigo;
        this.fecha = fecha;
        this.veterinario = veterinario; */
        //Validación y conversión de fecha
        //Se llaman los setters ya con las validaciones
        setCodigo(codigo);
        setFecha(fecha);
        setVeterinario(veterinario);
    }

    //Datos de la consulta
    public void mostrarConsulta() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Fecha: " + fecha);
        if (veterinario != null) {
            veterinario.mostrarPerfil();
        } else {
            System.out.println("Sin veterinario asignado.");
        }
    }

    //Validaciones en los setters

    public String getCodigo() {
        return codigo;
    }

    /*public void setCodigo(String codigo) {
        this.codigo = codigo;
    }*/

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }
        this.codigo = codigo;
    }

    // public String getFecha() { return fecha; }
    public LocalDate getFecha() { return fecha; }

    public void setFecha(String fechaTexto) {
        try {
            this.fecha = LocalDate.parse(fechaTexto); // Formato YYYY-MM-DD
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido."); //Sino se agrega bien lanza una excepción.
        }
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            throw new IllegalArgumentException("Veterinario requerido.");
        }
        this.veterinario = veterinario;

    }
}
