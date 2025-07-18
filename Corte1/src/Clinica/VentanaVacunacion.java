package Clinica;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VentanaVacunacion extends JInternalFrame {

    private CrudMascota crud;

    public VentanaVacunacion(CrudMascota crud) {
        super("Vacunación", true, true, true, true);
        this.crud = crud;
        crearInterfaz();
        pack();
    }

    private void crearInterfaz() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JComboBox<Mascota> cboMascota = new JComboBox<>(crud.informacionMascota().toArray(Mascota[]::new));
        cboMascota.setRenderer((list, value, idx, sel, foc) -> {
            JLabel lbl = new JLabel();
            if (value != null) lbl.setText(value.getNombre() + " (" + value.getClave() + ")");
            return lbl;
        });

        JTextField txtVacuna = new JTextField(12);
        JTextField txtFecha = new JTextField(10); // YYYY-MM-DD
        JButton btnGuardar = new JButton("Registrar vacuna");

        int y = 0;
        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Mascota:"), gbc);
        gbc.gridx = 1; add(cboMascota, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Vacuna:"), gbc);
        gbc.gridx = 1; add(txtVacuna, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Fecha (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1; add(txtFecha, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; gbc.gridwidth = 2; add(btnGuardar, gbc);

        btnGuardar.addActionListener(e -> {
            Mascota mascota = (Mascota) cboMascota.getSelectedItem();
            String vacuna = txtVacuna.getText().trim();
            String Fecha = txtFecha.getText().trim();

            if (mascota == null || vacuna.isBlank() || Fecha.isBlank()) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }

            LocalDate fecha = LocalDate.parse(Fecha, DateTimeFormatter.ISO_LOCAL_DATE);

            JOptionPane.showMessageDialog(this,
                    "Vacuna '" + vacuna + "' registrada para " + mascota.getNombre() + " el " + fecha);
            dispose();
        });
    }
}
