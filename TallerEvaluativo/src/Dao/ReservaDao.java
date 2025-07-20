package Dao;

import Dto.ReservaDto;

import java.util.ArrayList;
import java.util.List;

public class ReservaDao {

    private List<ReservaDto> reservas = new ArrayList<>();

    public void guardar(ReservaDto dto) {
        reservas.add(dto);
    }

    public List<ReservaDto> listar() {
        return reservas;
    }

    public void eliminar(int indice) {
        if (indice >= 0 && indice < reservas.size()) {
            reservas.remove(indice);
        }
    }

    public void actualizar(int indice, ReservaDto dto) {
        if (indice >= 0 && indice < reservas.size()) {
            reservas.set(indice, dto);
        }
    }
}

