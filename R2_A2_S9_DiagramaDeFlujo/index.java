package R2_A2_S9_DiagramaDeFlujo;

import javax.swing.SwingUtilities;

public class index {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new formulario().setVisible(true);
        });
    }
}
