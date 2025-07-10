import javax.swing.*;

public class VentanaSecundaria extends JDialog{

    public VentanaSecundaria(){
        JOptionPane.showMessageDialog(this, "¡Que tengas un lindo día!");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
