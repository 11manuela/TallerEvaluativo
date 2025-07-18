package Clinica;

import java.util.ArrayList;

public class CrudMascota {

        private ArrayList<Mascota> mascotas = new ArrayList<>();

        public ArrayList<Mascota> informacionMascota() {
            return mascotas;
        }

        public Mascota buscar(int clave) {
            for (Mascota m : mascotas) {
                if (m.getClave() == clave) return m;
            }
            return null;
        }

        public boolean guardar(Mascota mascota) {
            if (!validar(mascota)) return false;
            if (buscar(mascota.getClave()) == null) {
                mascotas.add(mascota);
                return true;
            }
            return false;
        }

        public boolean eliminar(int clave) {
            for (int i = 0; i < mascotas.size(); i++) {
                if (mascotas.get(i).getClave() == clave) {
                    mascotas.remove(i);
                    return true;
                }
            }
            return false;
        }

        public boolean editar(Mascota masc) {
            if (!validar(masc)) return false;
            for (int i = 0; i < mascotas.size(); i++) {
                if (mascotas.get(i).getClave() == masc.getClave()) {
                    mascotas.get(i).setNombre(masc.getNombre());
                    mascotas.get(i).setEspecie(masc.getEspecie());
                    mascotas.get(i).setEdad(masc.getEdad());
                    return true;
                }
            }
            return false;
        }

        private boolean validar(Mascota m) {
            if (m.getNombre() == null || m.getNombre().isBlank()) return false;
            if (m.getEspecie() == null || m.getEspecie().isBlank()) return false;
            return m.getEdad() >= 0;
        }
}
