package Controlador;

import Dao.HabitacionDao;
import Dto.HabitacionDto;
import Dto.HuespedDto;


import java.util.List;

public class HabitacionController {

    private final HabitacionDao dao = new HabitacionDao();

    public List<HabitacionDto> obtenerHabitacion() {
        return dao.listar();
    }

    public void eliminarHabitacion(int indice) {
        dao.eliminar(indice);
    }

    public String actualizarReserva(int indice, HabitacionDto dto) {

        dao.actualizar(indice, dto);
        return "Habitación actualizado correctamentes.";
    }
}
