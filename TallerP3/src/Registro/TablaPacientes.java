package Registro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaPacientes extends JInternalFrame {

    // Crud para poder modificar mascotas
    private CrudMascotas.CrudMascota crud;

    // Las columnas de la tabla registro
    private final DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nombre", "Especie", "Edad", "ID"}, 0);

    public TablaPacientes(CrudMascotas.CrudMascota crud) {
        super("Lista de pacientes", true, true, true, true);
        this.crud = crud;
        interfazPacientes();
        actualizar();        // llena la tabla
        pack();              // ajusta tamaño
    }

    //Construye la interfaz grafica
    private void interfazPacientes() {
        setLayout(new BorderLayout());

        //Tabla
        JTable tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        //Diseño de botones
        JToolBar bar = new JToolBar();
        JButton btnEdit = new JButton("Editar");
        JButton btnDel  = new JButton("Eliminar");
        bar.add(btnEdit); bar.add(btnDel);
        add(bar, BorderLayout.NORTH);

        //Barra de progreso
        JProgressBar barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);
        add(barra, BorderLayout.SOUTH);
        // Anima del 0 al 100 % para dar sensación de actividad
        new javax.swing.Timer(30, e -> {
            int v = barra.getValue();
            barra.setValue(v < 100 ? v + 2 : 100);
        }).start();

        //Boton de eliminar
        btnDel.addActionListener(e -> {
            String sClave = JOptionPane.showInputDialog(this, "Ingrese su clave:");
            if (sClave == null || sClave.isBlank()) return;
            try {
                int clave = Integer.parseInt(sClave.trim());
                if (crud.eliminar(clave)) {
                    actualizar();
                    JOptionPane.showMessageDialog(this, "Mascota eliminada");
                } else {
                    JOptionPane.showMessageDialog(this, "Clave no encontrada");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Clave inválida");
            }
        });

        //Boton de editar
        btnEdit.addActionListener(e -> {
            String sClave = JOptionPane.showInputDialog(this, "Ingrese su clave:");
            if (sClave == null || sClave.isBlank()) return;
            try {
                int clave = Integer.parseInt(sClave.trim());
                Mascota m = crud.buscar(clave);
                if (m == null) {
                    JOptionPane.showMessageDialog(this, "Usuario no encontrado");
                    return;
                }
                // Campos precargados
                JTextField tNom = new JTextField(m.getNombre());
                JTextField tEsp = new JTextField(m.getEspecie());
                JSpinner spEd  = new JSpinner(new SpinnerNumberModel(m.getEdad(), 0, 50, 1));

                // Edicion
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
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Clave incorrecta");
            }
        });
    }

    // Actualiza la tabla de las mascotas registradas
    public void actualizar() {
        modelo.setRowCount(0); // limpia
        for (Mascota m : crud.informacionMascota()) {
            modelo.addRow(new Object[]{
                    m.getNombre(), m.getEspecie(), m.getEdad(), m.getClave()
            });
        }
    }
}
