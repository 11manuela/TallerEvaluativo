package Clinica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VentanaConsultas extends JInternalFrame {

    private CrudMascota crudMascotas;
    private CrudConsultas crudConsultas;

    private final DefaultTableModel modelo = new DefaultTableModel(new String[]{
            "Código", "Fecha", "Mascota", "Veterinario", "Especialidad"}, 0);

    public VentanaConsultas(CrudMascota crudMascotas, CrudConsultas crudConsultas) {
        super("Consultas", true, true, true, true);
        this.crudMascotas = crudMascotas;
        this.crudConsultas = crudConsultas;
        interfaz();
        actualizar();
        pack();
    }

    private void interfaz() {
        setLayout(new BorderLayout());

        JTable tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel form = new JPanel(new FlowLayout());

        JTextField txtCodigo = new JTextField(5);
        JComboBox<Mascota> cboMascota = new JComboBox<>();
        JTextField txtVet = new JTextField(8);
        JTextField txtEsp = new JTextField(10);
        JTextField txtFecha = new JTextField(10); // yyyy-MM-dd
        JButton btnCrear = new JButton("Registrar consulta");

        form.add(new JLabel("Código:"));         form.add(txtCodigo);
        form.add(new JLabel("Mascota:"));        form.add(cboMascota);
        form.add(new JLabel("Veterinario:"));    form.add(txtVet);
        form.add(new JLabel("Especialidad:"));   form.add(txtEsp);
        form.add(new JLabel("Fecha (YYYY-MM-DD):")); form.add(txtFecha);
        form.add(btnCrear);

        add(form, BorderLayout.NORTH);

        // Renderizar nombres de mascota en el combo
        cboMascota.setRenderer((list, value, idx, sel, foc) ->
                new JLabel(value == null ? "" :
                        value.getNombre() + " (" + value.getClave() + ")"));

        // Llenar combo con mascotas
        cboMascota.setModel(new DefaultComboBoxModel<>(
                crudMascotas.informacionMascota().toArray(Mascota[]::new)));

        btnCrear.addActionListener(e -> {
            String cod = txtCodigo.getText().trim();
            Mascota m = (Mascota) cboMascota.getSelectedItem();
            String nombreVet = txtVet.getText().trim();
            String especial = txtEsp.getText().trim();
            String sFecha = txtFecha.getText().trim();

            if (cod.isBlank() || nombreVet.isBlank() || especial.isBlank() ||
                    sFecha.isBlank() || m == null) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }

            if (!sFecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Usa YYYY-MM-DD");
                return;
            }

            LocalDate fecha = LocalDate.parse(sFecha, DateTimeFormatter.ISO_LOCAL_DATE);
            Veterinario vet = new Veterinario(nombreVet, especial);
            Consulta consulta = new Consulta(cod, fecha, vet, m);

            if (!crudConsultas.guardar(consulta)) {
                JOptionPane.showMessageDialog(this, "Código duplicado");
                return;
            }

            actualizar();
            limpiarCampos(txtCodigo, txtVet, txtEsp, txtFecha);
        });
    }

    private void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) campo.setText("");
    }

    private void actualizar() {
        modelo.setRowCount(0);
        for (Consulta c : crudConsultas.listar()) {
            modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getFecha(),
                    c.getMascota().getNombre(),
                    c.getVeterinario().getNombre(),
                    c.getVeterinario().getEspecialidad()
            });
        }
    }
}
