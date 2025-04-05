import javax.swing.SwingUtilities;


public class index {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( ()->{
            new FormularioClientes().setVisible(true);
            
        });
    }
    
} 