package Clinica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaPacientes extends JInternalFrame {

    private CrudMascota crud;
    private DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nombre", "Especie", "Edad", "ID"}, 0);

    public TablaPacientes(CrudMascota crud) {
        super("Lista de pacientes", true, true, true, true);
        this.crud = crud;
        interfazPacientes();
        actualizar();
        pack();
    }

    private void interfazPacientes() {
        setLayout(new BorderLayout());

        JTable tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JToolBar bar = new JToolBar();
        JButton btnEdit = new JButton("Editar");
        JButton btnDel = new JButton("Eliminar");
        bar.add(btnEdit);
        bar.add(btnDel);
        add(bar, BorderLayout.NORTH);

        JProgressBar barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);
        add(barra, BorderLayout.SOUTH);

        new javax.swing.Timer(30, e -> {
            int v = barra.getValue();
            barra.setValue(v < 100 ? v + 2 : 100);
        }).start();

        // Eliminar sin try-catch
        btnDel.addActionListener(e -> {
            String sClave = JOptionPane.showInputDialog(this, "Ingrese su clave:");
            if (sClave == null || sClave.isBlank()) return;

            sClave = sClave.trim();
            if (!sClave.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "La clave debe ser numérica");
                return;
            }

            int clave = Integer.parseInt(sClave);
            if (crud.eliminar(clave)) {
                actualizar();
                JOptionPane.showMessageDialog(this, "Mascota eliminada");
            } else {
                JOptionPane.showMessageDialog(this, "Clave no encontrada");
            }
        });

        // Editar sin try-catch
        btnEdit.addActionListener(e -> {
            String sClave = JOptionPane.showInputDialog(this, "Ingrese su clave:");
            if (sClave == null || sClave.isBlank()) return;

            sClave = sClave.trim();
            if (!sClave.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "La clave debe ser numérica");
                return;
            }

            int clave = Integer.parseInt(sClave);
            Mascota m = crud.buscar(clave);
            if (m == null) {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
                return;
            }

            JTextField tNom = new JTextField(m.getNombre());
            JTextField tEsp = new JTextField(m.getEspecie());
            JSpinner spEd = new JSpinner(new SpinnerNumberModel(m.getEdad(), 0, 50, 1));

            int ok = JOptionPane.showConfirmDialog(this,
                    new Object[]{"Nombre:", tNom,
                            "Especie:", tEsp,
                            "Edad:", spEd},
                    "Editar paciente", JOptionPane.OK_CANCEL_OPTION);

            if (ok == JOptionPane.OK_OPTION) {
                Mascota edit = new Mascota(
                        tNom.getText(), tEsp.getText(),
                        (Integer) spEd.getValue(), clave);
                crud.editar(edit);
                actualizar();
            }
        });
    }

    public void actualizar() {
        modelo.setRowCount(0);
        for (Mascota m : crud.informacionMascota()) {
            modelo.addRow(new Object[]{
                    m.getNombre(), m.getEspecie(), m.getEdad(), m.getClave()
            });
        }
    }
}
