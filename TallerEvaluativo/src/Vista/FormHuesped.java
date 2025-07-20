package Vista;

import Controlador.HuespedController;
import Dto.HuespedDto;
import javax.swing.*;
import java.awt.*;

public class FormHuesped extends JInternalFrame {
    private HuespedController HC;
    private Runnable postSave;

    public FormHuesped(HuespedController HC, Runnable postSave) {
        super("Registro de Huésped", true, true, true, true);
        this.HC = HC;
        this.postSave = postSave;
        diseñoHuesped();
        setBounds(30, 30, 400, 250); // Tamaño
    }

    private void diseñoHuesped() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField txtNombre = new JTextField(15);
        JTextField txtDocumento = new JTextField(15);
        JTextField txtCorreo = new JTextField(15);
        JTextField txtTelefono = new JTextField(15);
        JButton btn = new JButton("Registrar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Documento:"), gbc);
        gbc.gridx = 1;
        add(txtDocumento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Correo:"), gbc);
        gbc.gridx = 1;
        add(txtCorreo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        add(txtTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        add(btn, gbc);

        btn.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String documento = txtDocumento.getText().trim();
            String correo = txtCorreo.getText().trim();
            String telefono = txtTelefono.getText().trim();

            // Construir DTO
            HuespedDto dto = new HuespedDto(nombre, correo, documento, telefono);

            // Llamar a la lógica del controlador
            String resultado = HC.agregarHuesped(dto);

            // Mostrar mensaje
            JOptionPane.showMessageDialog(this, resultado);

            // Si fue exitoso, actualizar tabla y cerrar
            if (resultado.contains("correctamente")) {
                postSave.run();
                dispose();
            }
        });
    }
}