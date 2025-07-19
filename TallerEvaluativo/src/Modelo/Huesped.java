package Modelo;

public class Huesped {

    private String nombre;
    private String documento;
    private String correo;
    private String telefono;

    public Huesped(String nombre, String documento, String correo, String telefono) {
        setNombre(nombre);
        setDocumento(documento);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
