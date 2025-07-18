package Clinica;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    //Crud
    private CrudMascota crudMascotas = new CrudMascota();
    private CrudConsultas crudConsultas = new CrudConsultas();

    private JDesktopPane escritorio = new JDesktopPane();
    private JTree arbolServicios;

    public VentanaPrincipal() {
        super("Sistema de Gestión Clínica Veterinaria");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(escritorio, BorderLayout.CENTER);
        add(crearBarraMenu(), BorderLayout.NORTH);
        add(crearPanelServicios(), BorderLayout.WEST);
    }

    //Menu
    private JMenuBar crearBarraMenu() {
        JMenuBar barra = new JMenuBar();

        JMenu mArchivo = new JMenu("Archivo");
        mArchivo.add(item("Nuevo registro", e -> abrirFormularioPaciente()));
        mArchivo.add(item("Salir", e -> dispose()));

        JMenu mVista = new JMenu("Vista");
        mVista.add(item("Pacientes", e -> abrirTablaPacientes()));
        mVista.add(item("Consultas", e -> abrirPanelConsultas()));

        barra.add(mArchivo);
        barra.add(mVista);
        return barra;
    }
    private JMenuItem item(String txt, ActionListener al) {
        JMenuItem it = new JMenuItem(txt);
        it.addActionListener(al);
        return it;
    }

    //Arbol de servicios
    private JScrollPane crearPanelServicios() {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Servicios");
        for (String s : java.util.List.of("Medicina general","Cirugía",
                "Vacunación","Peluquería","Urgencias")) {
            raiz.add(new DefaultMutableTreeNode(s));
        }

        arbolServicios = new JTree(raiz);
        arbolServicios.addTreeSelectionListener(e -> ServicioSeleccionado());

        JScrollPane sc = new JScrollPane(arbolServicios);
        sc.setPreferredSize(new Dimension(170,0));
        return sc;
    }

    private void ServicioSeleccionado() {
        Object obj = arbolServicios.getLastSelectedPathComponent();
        if (obj == null) return;

        String nombre = obj.toString();
        switch (nombre) {
            case "Vacunación" -> abrirVentanaVacunacion();
            // en el futuro: case "Cirugía" -> abrirVentanaCirugia();
            default -> { /* otros nodos no hacen nada por ahora */ }
        }
    }

    private void abrirVentanaVacunacion() {
        // evitar duplicados
        for (JInternalFrame f : escritorio.getAllFrames()) {
            if (f instanceof VentanaVacunacion) {

            }
        }
        VentanaVacunacion vac = new VentanaVacunacion(crudMascotas);
        escritorio.add(vac);
        vac.setVisible(true);
    }

    //Ventanas
    private void abrirFormularioPaciente() {
        escritorio.add(new VentanaPacientes(crudMascotas, this::actualizarTablas)).setVisible(true);
    }

    private void abrirTablaPacientes() {
        escritorio.add(new TablaPacientes(crudMascotas)).setVisible(true);
    }

    private void abrirPanelConsultas() {
        escritorio.add(new VentanaConsultas(crudMascotas, crudConsultas)).setVisible(true);
    }

    //Actualizar tablas
    private void actualizarTablas() {
        for (JInternalFrame f : escritorio.getAllFrames()) {
            if (f instanceof TablaPacientes tabla) tabla.actualizar();
        }
    }

    //Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}

