package R2_A2_S9_DiagramaDeFlujo;

import javax.swing.*;
import java.awt.*;


public class formulario extends JFrame{
    private JTextField ingresoCedula,ingresoNombre;
    private JButton botonAddCliente, botonDerecha, botonIzquierda, botonSalir;
    private JTextArea zonaListaClientes;



    public formulario(){
        setTitle("Gestion clientes");
        setSize(550, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color (170,202,250));

        JPanel panelIngreso = new JPanel(new GridLayout(4,2,5,5));
        panelIngreso.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelIngreso.setBackground(new Color(170,202,250));
    
        panelIngreso.add(new JLabel("ingrese numero de cedula:"));
        ingresoCedula = new JTextField();
        panelIngreso.add(ingresoCedula);

        panelIngreso.add(new JLabel("ingrese nombre:"));
        ingresoNombre = new JTextField();
        panelIngreso.add(ingresoNombre);

        JPanel panelBotonesAccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotonesAccion.setBackground(new Color(170, 202, 250));
          
        botonAddCliente = new JButton("Agregar Cliente");
        botonDerecha = new JButton("Listar Derecha");
        botonIzquierda = new JButton("Listar Izquierda");

        
        Color colorBotones = new Color(0, 40, 99);
        aplicarEstiloBoton(botonAddCliente, colorBotones);
        aplicarEstiloBoton(botonDerecha, colorBotones);
        aplicarEstiloBoton(botonIzquierda, colorBotones);

        panelBotonesAccion.add(botonAddCliente);
        panelBotonesAccion.add(botonDerecha);
        panelBotonesAccion.add(botonIzquierda);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(170, 202, 250));
        panelSuperior.add(panelIngreso, BorderLayout.CENTER);
        panelSuperior.add(panelBotonesAccion, BorderLayout.SOUTH);

        zonaListaClientes = new JTextArea();
        zonaListaClientes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zonaListaClientes);

        JPanel panelSalir = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSalir.setBackground(new Color(170, 202, 250));

      botonSalir = new JButton("Salir");
        aplicarEstiloBoton(botonSalir, colorBotones);
        panelSalir.add(botonSalir);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelSalir, BorderLayout.SOUTH); 
        
    }
    private void aplicarEstiloBoton(JButton boton,Color colorFondo){

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);
    }


}
