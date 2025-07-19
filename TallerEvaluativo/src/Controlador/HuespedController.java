package Controlador;
import Dao.HuespedDao;
import Dto.HuespedDto;

import java.util.List;

public class HuespedController {

        private final HuespedDao dao = new HuespedDao();

        // Validaciones incluidas
        public String agregarHuesped(HuespedDto dto) {
            if (dto.getNombre().isBlank() || dto.getCorreo().isBlank() || dto.getDocumento().isBlank() || dto.getTelefono().isBlank()) {
                return "No pueden estar vacios los campos.";
            }
            dao.guardar(dto);
            return "Huesped registrado correctamente.";
        }

        public List<HuespedDto> obtenerHuesped() {
            return dao.listar();
        }

        public void eliminarHuesped(int indice) {
            dao.eliminar(indice);
        }

        public String actualizarHuesped(int indice, HuespedDto dto) {
            if (dto.getNombre().isBlank() || dto.getCorreo().isBlank() || dto.getDocumento().isBlank() || dto.getTelefono().isBlank()) {
                return "No pueden estar vacios los campos.";
            }
            dao.actualizar(indice, dto);
            return "Huesped actualizado correctamentes.";
    }
}
