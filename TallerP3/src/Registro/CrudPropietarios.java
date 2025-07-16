package Registro;

import java.util.ArrayList;
import java.util.List;

public class CrudPropietarios {

    private final List<Propietario> lista = new ArrayList<>();

    public List<Propietario> listar() {
        return lista;
    }

    public Propietario buscar(String documento) {
        return lista.stream()
                .filter(p -> p.getDocumento().equals(documento))
                .findFirst().orElse(null);
    }

    public boolean guardar(Propietario p) {
        if (buscar(p.getDocumento()) != null) return false;
        lista.add(p);
        return true;
    }

    public boolean editar(Propietario propietario) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDocumento().equals(propietario.getDocumento())) {
                lista.set(i, propietario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String doc) {
        return lista.removeIf(p -> p.getDocumento().equals(doc));
    }
}
