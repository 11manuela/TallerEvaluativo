package Dao;

import Dto.HabitacionDto;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDao {

    private List<HabitacionDto> habitaciones = new ArrayList<>();

    public void guardar(HabitacionDto dto) {
        habitaciones.add(dto);
    }

    public List<HabitacionDto> listar() {
        return habitaciones;
    }

    public void eliminar(int indice) {
        if (indice >= 0 && indice < habitaciones.size()) {
            habitaciones.remove(indice);
        }
    }

    public void actualizar(int indice, HabitacionDto dto) {
        if (indice >= 0 && indice < habitaciones.size()) {
            habitaciones.set(indice, dto);
        }
    }
}