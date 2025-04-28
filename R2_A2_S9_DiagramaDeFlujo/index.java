package R2_A2_S9_DiagramaDeFlujo;

import javax.swing.SwingUtilities;
import R2_A2_S9_DiagramaDeFlujo.vista.Formulario;



/** Clase principal para iniciar la aplicación. */
public class Index {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{        
            new Formulario().setVisible(true);
        });
    }
}
