package Registro;

public class Consulta {

    private String codigo;
    private String fecha;
    private Veterinario veterinario;

    public Consulta(String codigo, String fecha, Veterinario veterinario) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.veterinario = veterinario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        System.out.println("Nombre: " + veterinario.getNombre());
        System.out.println("Veterinario: " + veterinario.getEspecialidad());

    }
}
