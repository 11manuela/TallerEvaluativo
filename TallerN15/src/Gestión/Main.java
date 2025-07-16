package Gestión;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }

        private final java.util.List<Vehiculo> lista = new ArrayList<>();
        private final DefaultTableModel tablaV = new DefaultTableModel(new String[]{"Propietario", "Placa","Marca","Modelo"}, 0);
        public Main() {

            setTitle("Gestión de Vehículos");
            setSize(700, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            add(new JScrollPane(new JTable(tablaV)), BorderLayout.CENTER);

            /* menú */
            JMenuBar bar = new JMenuBar();
            JMenu menu   = new JMenu("Opciones");
            JMenuItem mReg = new JMenuItem("Registrar");
            JMenuItem mEdit= new JMenuItem("Editar modelo");
            JMenuItem mDel = new JMenuItem("Eliminar por placa");
            menu.add(mReg); menu.add(mEdit); menu.add(mDel);
            bar.add(menu); setJMenuBar(bar);

            mReg.addActionListener(e -> registrar());
            mEdit.addActionListener(e -> editar());
            mDel.addActionListener(e -> eliminar());
       }

    //Registrar
    private void registrar() {
        JTextField tNom   = new JTextField();
        JTextField tDoc   = new JTextField();
        JTextField tPlaca = new JTextField();
        JTextField tMarca = new JTextField();
        JTextField tModelo= new JTextField();

        int ok = JOptionPane.showConfirmDialog(
                this,
                new Object[]{
                        "Nombre del propietario:", tNom,
                        "Documento:", tDoc,
                        "Placa:", tPlaca,
                        "Marca:", tMarca,
                        "Modelo:", tModelo
                },
                "Registrar vehículo",
                JOptionPane.OK_CANCEL_OPTION);

        if (ok == JOptionPane.OK_OPTION) {
            Propietario p = new Propietario(tNom.getText(), tDoc.getText());
            Vehiculo v = new Vehiculo(
                    tPlaca.getText(),
                    tMarca.getText(),
                    tModelo.getText(),
                    p);

            lista.add(v);
            tablaV.addRow(new Object[]{
                    p.getNombre(),
                    v.getPlaca(),
                    v.getMarca(),
                    v.getModelo()});
        }
    }

    //Editar
    private void editar() {
        String placa = JOptionPane.showInputDialog(this, "Placa a editar:");
        if (placa == null) return;

        for (int i = 0; i < lista.size(); i++) {
            Vehiculo v = lista.get(i);
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                String nuevo = JOptionPane.showInputDialog(
                        this, "Nuevo modelo:", v.getModelo());
                if (nuevo != null && !nuevo.isBlank()) {
                    v.setModelo(nuevo);
                    tablaV.setValueAt(nuevo, i, 3); // 3 = Modelo
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Placa no encontrada.");
    }

    //Eliminar
    private void eliminar() {
        String placa = JOptionPane.showInputDialog(this, "Placa a eliminar:");
        if (placa == null) return;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPlaca().equalsIgnoreCase(placa)) {
                lista.remove(i);
                tablaV.removeRow(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Placa no encontrada.");
    }
}
