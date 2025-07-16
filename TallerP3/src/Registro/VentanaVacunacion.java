package Registro;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VentanaVacunacion extends JInternalFrame {

    // Referencia al CRUD de mascotas para acceder a la lista
    private final CrudMascotas.CrudMascota crudMascotas;

    // Constructor que recibe el CRUD
    public VentanaVacunacion(CrudMascotas.CrudMascota crudMascotas) {
        super("Vacunación", true, true, true, true);
        this.crudMascotas = crudMascotas;
        crearInterfaz(); // Construcción de la interfaz
        pack(); // Ajusta tamaño automático
    }

    // Metodo para crear el formulario de vacunación
    private void crearInterfaz() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ComboBox con las mascotas registradas
        JComboBox<Mascota> cboMascota = new JComboBox<>(
                crudMascotas.informacionMascota().toArray(Mascota[]::new));
        cboMascota.setRenderer((list, value, idx, sel, foc) -> {
            JLabel lbl = new JLabel();
            if (value != null) lbl.setText(value.getNombre() + " (" + value.getClave() + ")");
            return lbl;
        });

        // Los campos para ingresar la información
        JTextField txtVacuna = new JTextField(12);
        JTextField txtFecha  = new JTextField(10); // Fecha escrita por el usuario
        JButton btnGuardar   = new JButton("Registrar vacuna");

        // Distribución por filas usando GridBag
        // GridBag sirve para organizar componentes dentro de un contenedor
        int y = 0;
        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Mascota:"), gbc);
        gbc.gridx = 1;             add(cboMascota, gbc);            y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Vacuna:"), gbc);
        gbc.gridx = 1;             add(txtVacuna, gbc);             y++;

        gbc.gridx = 0; gbc.gridy = y; add(new JLabel("Fecha (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;             add(txtFecha, gbc);              y++;

        gbc.gridx = 0; gbc.gridy = y; gbc.gridwidth = 2; add(btnGuardar, gbc);

        // Guarda el registro de la vacuna
        btnGuardar.addActionListener(e -> {
            Mascota m     = (Mascota) cboMascota.getSelectedItem();
            String vacuna = txtVacuna.getText().trim();
            String sFecha = txtFecha.getText().trim();

            // Validación de campos vacíos
            if (m == null || vacuna.isBlank() || sFecha.isBlank()) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }

            // Validación de la fecha
            LocalDate fecha;
            try {
                fecha = LocalDate.parse(sFecha, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Fecha inválida. Usa YYYY-MM-DD");
                return;
            }

            //Confrima el registro
            JOptionPane.showMessageDialog(this,
                    "Vacuna '" + vacuna + "' registrada para " + m.getNombre() + " el " + fecha);
            dispose(); // Cierra la ventana
        });
    }
}
