package Vista;

import Controlador.HuespedController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private HuespedController HC = new HuespedController();
    private JDesktopPane escritorio = new JDesktopPane();

    public Main() {
        super("Gestión de reservas EcoHotel");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new BorderLayout());

        add(escritorio, BorderLayout.CENTER); // Muy importante para mostrar

        setJMenuBar(crearBarraMenu());
    }

    // Barra de menú
    private JMenuBar crearBarraMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu menu = new JMenu("ECOHOTEL REGISTRO");
        menu.add(item("Registro de huésped", e -> abrirFormHuesped()));
        menu.add(item("Salir", e -> dispose()));

        barra.add(menu);
        return barra;
    }

    private JMenuItem item(String texto, ActionListener al) {
        JMenuItem item = new JMenuItem(texto);
        item.addActionListener(al);
        return item;
    }

    // abre el formulario para el husped poder registrarse
    private void abrirFormHuesped() {
        System.out.println("Abriendo formulario...");
        FormHuesped form = new FormHuesped(HC, () -> {
            System.out.println("Formulario guardado o cerrado");
        });

        escritorio.add(form);
        form.setVisible(true);

        try {
            form.setSelected(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
