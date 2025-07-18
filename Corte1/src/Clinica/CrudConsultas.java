package Clinica;

import java.util.ArrayList;

public class CrudConsultas {

    private ArrayList<Consulta> listaConsultas = new ArrayList<>();

    public ArrayList<Consulta> listar() {
        return listaConsultas;
    }

    public boolean guardar(Consulta c) {
        if (buscar(c.getCodigo()) != null) return false;
        listaConsultas.add(c);
        return true;
    }

    public boolean eliminar(String codigo) {
        Consulta c = buscar(codigo);
        if (c != null) {
            listaConsultas.remove(c);
            return true;
        }
        return false;
    }

    public boolean editar(Consulta consulta) {
        for (int i = 0; i < listaConsultas.size(); i++) {
            if (listaConsultas.get(i).getCodigo().equals(consulta.getCodigo())) {
                listaConsultas.set(i, consulta);
                return true;
            }
        }
        return false;
    }

    public Consulta buscar(String codigo) {
        for (Consulta c : listaConsultas) {
            if (c.getCodigo().equals(codigo)) return c;
        }
        return null;
    }
}
