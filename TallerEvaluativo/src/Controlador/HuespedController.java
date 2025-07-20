package Controlador;

import Dao.HuespedDao;
import Dto.HuespedDto;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HuespedController {

        private final HuespedDao dao = new HuespedDao();

        // Validaciones
        public String agregarHuesped(HuespedDto dto) {
            try {
                if (dto.getNombre().isBlank() || dto.getCorreo().isBlank()
                        || dto.getDocumento().isBlank() || dto.getTelefono().isBlank()) {
                    throw new IllegalArgumentException("No pueden estar vacíos los campos.");
                }

                if (!validarCorreo(dto.getCorreo())) {
                    throw new IllegalArgumentException("Correo incorrecto.");
                }
            } catch (IllegalArgumentException e) {
                return "Error: " + e.getMessage();
            }
            dao.guardar(dto);
            return "Huésped registrado correctamente.";
        }

        public boolean validarCorreo(String correo) {
            Pattern pattern = Pattern.compile("@");
            Matcher matcher = pattern.matcher(correo);
            return matcher.find();
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

    public List<HuespedDto> obtenerHuespedes() {
        return dao.listar();  // el método listar() debe retornar la lista
    }
}
