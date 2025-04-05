import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioClientes extends JFrame{
    private JTextField ingresoCedula, ingresoNombre;
    private JButton botonAddCliente, botonVerCliente, botonSalir;
    private JTextArea zonaListaClientes;

public FormularioClientes(){

    setTitle("Admin de Clientes");
    setSize(500,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    getContentPane().setBackground(new Color (236, 201, 245));

    JPanel panelIngreso = new JPanel(new GridLayout(3,2,5,5));
    panelIngreso.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    panelIngreso.setBackground(new Color(236, 201, 245));

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

    estiloBoton(botonAddCliente, new Color (161, 8, 161));
    estiloBoton(botonVerCliente, new Color (161, 8, 161));
  
    zonaListaClientes = new JTextArea();
    zonaListaClientes.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(zonaListaClientes);

    botonSalir = new JButton("Salir");
    estiloBoton(botonSalir, new Color (161, 8, 161));
    panelIngreso.add(botonSalir);
    botonSalir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    });

    JPanel panelSalir= new JPanel(new FlowLayout(FlowLayout.CENTER));
    panelSalir.setBackground(new Color(236, 201, 245));
    panelSalir.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    panelSalir.add(botonSalir);

    add(panelIngreso,BorderLayout.NORTH);
    add(scrollPane,BorderLayout.CENTER);
    add(panelSalir,BorderLayout.SOUTH);
}
private void estiloBoton(JButton boton,Color colorFondo){
    boton.setFocusPainted(false);
    boton.setBorderPainted(false);
    boton.setContentAreaFilled(true);
    boton.setBackground(colorFondo);
    boton.setForeground(Color.WHITE);
    boton.setOpaque(true);


}
}
