public class Consulta {

    //Atributos
    private String codigo;
    private String fecha;
    private Diagnostico diagnostico;

    //Constructor
    public Consulta(String codigo, String fecha, Diagnostico diagnostico) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
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

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    //Metodo que muestra la información de la consulta
    public void mostrarConsulta(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Diagnostico: " + diagnostico.getDescripcion());
        System.out.println("Tratamiento: " + diagnostico.getTratamiento());
    }
}
