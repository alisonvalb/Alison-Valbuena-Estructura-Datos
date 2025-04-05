import javax.swing.*;
import java.awt.*;

public class FormularioClientes extends JFrame{
    private JTextField ingresoCedula, ingresoNombre;
    private JButton botonAddCliente, botonVerCliente;
    private JTextArea zonaListaClientes;

public FormularioClientes(){

    setTitle("Admin de Clientes");
    setSize(500,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    JPanel panelIngreso = new JPanel(new GridLayout(3,2,5,5));
    panelIngreso.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    panelIngreso.add(new JLabel("Ingrese numero de Cedula:"));
    ingresoCedula = new JTextField();
    panelIngreso.add(ingresoCedula);

    panelIngreso.add(new JLabel("Ingrese su Nombre:"));
    ingresoNombre = new JTextField();
    panelIngreso.add(ingresoNombre);

    botonAddCliente = new JButton("Agregar Cliente");
    panelIngreso.add(botonAddCliente);

    botonVerCliente = new JButton("Ver Clientes");
    panelIngreso.add(botonVerCliente);

    zonaListaClientes = new JTextArea();
    zonaListaClientes.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(zonaListaClientes);

    add(panelIngreso,BorderLayout.NORTH);
    add(scrollPane,BorderLayout.CENTER);
}



}
