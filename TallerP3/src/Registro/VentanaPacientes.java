package Registro;
import javax.swing.*;
import java.awt.*;

public class VentanaPacientes extends JInternalFrame {

    private CrudMascotas.CrudMascota crud;
    private Runnable postSave;           // callback (refrescar tablas)

    public VentanaPacientes(CrudMascotas.CrudMascota crud, Runnable postSave) {
        super("Formulario de paciente", true, true, true, true);
        this.crud = crud;
        this.postSave = postSave;
        interfazPaciente();
        pack();
    }

    //Creacion de la interfaz
    private void interfazPaciente() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField txtNombre = new JTextField(15);
        JPasswordField txtClave = new JPasswordField(15);
        JComboBox<String> cboEsp = new JComboBox<>(new String[]{"Perro", "Gato", "Ave", "Otro"});
        JSpinner spEdad = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
        JButton btn = new JButton("Registrar");

        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Clave historial:"), gbc);
        gbc.gridx = 1; add(txtClave, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Especie:"), gbc);
        gbc.gridx = 1; add(cboEsp, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1; add(spEdad, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; add(btn, gbc);

        //Boton guardar
        btn.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            int edad = (Integer) spEdad.getValue();
            String especie = cboEsp.getSelectedItem().toString();

            int clave;
            try { clave = Integer.parseInt(new String(txtClave.getPassword())); }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La clave debe ser numérica", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Mascota nueva = new Mascota(nombre, especie, edad, clave);
            if (!crud.guardar(nueva)) {
                JOptionPane.showMessageDialog(this, "Ya existe esta clave", "Duplicado", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, "Paciente registrado");
            postSave.run();
            dispose();
        });
    }
}

