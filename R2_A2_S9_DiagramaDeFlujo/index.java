package R2_A2_S9_DiagramaDeFlujo;

import javax.swing.SwingUtilities;

public class Index {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Formulario().setVisible(true);
        });
    }
}
