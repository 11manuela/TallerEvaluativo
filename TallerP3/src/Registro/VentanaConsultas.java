
package Registro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class VentanaConsultas extends JInternalFrame {

    private CrudMascotas.CrudMascota crudMascotas;
    private CrudConsultas crudConsultas;

    private final DefaultTableModel modelo = new DefaultTableModel(new String[]{
            "Código",
            "Fecha",
            "Mascota",
            "Veterinario",
            "Especialidad"}, 0);

    //Constructor
    public VentanaConsultas(CrudMascotas.CrudMascota crudMascotas, CrudConsultas crudConsultas) {
        super("Consultas", true, true, true, true);
        this.crudMascotas  = crudMascotas;
        this.crudConsultas = crudConsultas;
        interfaz();   // construir la interfaz
        actualizar();    //llenar la tabla
        pack();          // ajustar tamaño
    }

    private void interfaz() {
        setLayout(new BorderLayout());
        JTable tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        JPanel form = new JPanel(new FlowLayout());

        JTextField txtCodigo = new JTextField(5);
        JComboBox<Mascota> cboMascota = new JComboBox<>();
        JTextField txtVet   = new JTextField(8);
        JTextField txtEsp   = new JTextField(10);
        JTextField txtFecha = new JTextField(10); // formato yyyy-MM-dd
        JButton btnCrear = new JButton("Registrar consulta");

        form.add(new JLabel("Código:"));       form.add(txtCodigo);
        form.add(new JLabel("Mascota:"));      form.add(cboMascota);
        form.add(new JLabel("Veterinario:"));  form.add(txtVet);
        form.add(new JLabel("Especialidad:")); form.add(txtEsp);
        form.add(new JLabel("Fecha (YYYY-MM-DD):")); form.add(txtFecha);
        form.add(btnCrear);
        add(form, BorderLayout.NORTH);

        cboMascota.setRenderer((list, value, idx, sel, foc) ->
                new JLabel(value == null ? "" :
                        value.getNombre() + " (" + value.getClave() + ")"));
        cboMascota.setModel(new DefaultComboBoxModel<>(
                crudMascotas.informacionMascota().toArray(Mascota[]::new)));

        //Registrar consulta
        btnCrear.addActionListener(e -> {
            String cod        = txtCodigo.getText().trim();
            Mascota m         = (Mascota) cboMascota.getSelectedItem();
            String nombreVet  = txtVet.getText().trim();
            String especial   = txtEsp.getText().trim();
            String sFecha     = txtFecha.getText().trim();

            // Validación de llenar los campos
            if (cod.isBlank() || nombreVet.isBlank() || especial.isBlank() ||
                    sFecha.isBlank() || m == null) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }

            //Fecha
            LocalDate fecha;
            try {
                DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE; // yyyy-MM-dd
                fecha = LocalDate.parse(sFecha, fmt);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this,
                        "Fecha inválida.");
                return;
            }

            Veterinario vetObj = new Veterinario(nombreVet, especial);
            Consulta c = new Consulta(cod, fecha, vetObj, m);

            if (!crudConsultas.guardar(c)) {
                JOptionPane.showMessageDialog(this, "Código duplicado");
                return;
            }
            actualizar();
            limpiarCampos(txtCodigo, txtVet, txtEsp, txtFecha);
        });
    }

    //Limpia los campos del formulario
    private void limpiarCampos(JTextField... campos) {
        for (JTextField t : campos) t.setText("");
    }

    //Actualiza la tabla de consultas
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
