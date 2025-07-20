package Controlador;

import Dao.ReservaDao;
import Dto.ReservaDto;
import java.util.List;


public class ReservaController {

    private final ReservaDao dao = new ReservaDao();

    public List<ReservaDto> obtenerReserva() {
        return dao.listar();
    }

    public void eliminarReserva(int indice) {
        dao.eliminar(indice);
    }

    public String actualizarReserva(int indice, ReservaDto dto) {

        dao.actualizar(indice, dto);
        return "Reserva actualizado correctamentes.";
    }
}
