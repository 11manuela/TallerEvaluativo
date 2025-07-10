import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Sistema Clínica Veterinaria");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar ventana

        JTabbedPane pestanas = new JTabbedPane();

        //Bienvenida - Paso 1
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel("¡Bienvenido!");
        panelBienvenida.add(etiqueta, BorderLayout.CENTER);

        //Boton cambiar color
        JButton buttonColor1 = new JButton("Fondo");
        panelBienvenida.add(buttonColor1, BorderLayout.SOUTH);

        // Asignar acción al botón para cambiar el color de fondo
        buttonColor1.addActionListener(e -> {
            Color color = JColorChooser.showDialog(null, "Seleccione un color", panelBienvenida.getBackground()); // Color inicial sugerido
            if (color != null) {
                panelBienvenida.setBackground(color); // Cambiar el fondo del panel
            }
        });

        pestanas.addTab("Ventana Principal", panelBienvenida);

        //Pestaña 2 - Paso 2
        JPanel panelInformacion = new JPanel();
        panelInformacion.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea("¿Como estas?");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollTexto = new JScrollPane(textArea); // Insertar el JTextArea dentro de un JScrollPane
        panelInformacion.add(scrollTexto, BorderLayout.CENTER); // Agregar el JScrollPane al panel
        pestanas.addTab("Información", panelInformacion);// Añadir el panel como segunda pestaña

        //Cambiar el fondo de la pestaña “Bienvenida”
        //Mi modificación fue agregar la opción de cambiarle el fondo a la pestaña 2 de manera independiente a la primera pestaña
        JButton buttonColor2 = new JButton("Fondo");
        panelInformacion.add(buttonColor2, BorderLayout.NORTH);

        // Asignar acción al botón para cambiar el color de fondo
        buttonColor2.addActionListener(e -> {
            Color color = JColorChooser.showDialog(null, "Seleccione un color", panelInformacion.getBackground());
            if (color != null) {
                panelInformacion.setBackground(color); // Cambiar el fondo del panel
                textArea.setBackground(color);
                textArea.setBackground(color);
                scrollTexto.getViewport().setBackground(color);
            }
        });


        //Agregar un botón para abrir ventana secundaria (sin eventos funcionales aún)
        JButton buttonVentana = new JButton("Selecciona Aquí");
        panelInformacion.add(buttonVentana, BorderLayout.SOUTH);

        add(pestanas);
        setVisible(true);

    }
}
