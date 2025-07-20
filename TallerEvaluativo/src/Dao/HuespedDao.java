package Dao;

import Dto.HuespedDto;
import java.util.ArrayList;
import java.util.List;

public class HuespedDao {

        private List<HuespedDto> huespedes = new ArrayList<>();

        public void guardar(HuespedDto dto) {
            huespedes.add(dto);
        }

        public List<HuespedDto> listar() {
            return huespedes;
        }

        public void eliminar(int indice) {
            if (indice >= 0 && indice < huespedes.size()) {
                huespedes.remove(indice);
            }
        }

        public void actualizar(int indice, HuespedDto dto) {
            if (indice >= 0 && indice < huespedes.size()) {
                huespedes.set(indice, dto);
        }
    }
}
