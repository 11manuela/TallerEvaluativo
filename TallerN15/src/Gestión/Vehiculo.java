package Gestión;

public class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private Propietario propietario;

    public Vehiculo(String placa, String marca, String modelo, Propietario propietario) {
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        this.propietario = propietario;
    }

    private void setPlaca(String placa) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("Placa inválida");
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
