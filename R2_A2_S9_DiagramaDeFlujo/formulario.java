package R2_A2_S9_DiagramaDeFlujo;

import javax.swing.*;
import java.awt.*;


public class formulario extends JFrame {
    private JTextField ingresoCedula, ingresoNombre;
    private JButton botonAddCliente, botonDerecha, botonIzquierda, botonSalir;
    private JButton botonSinOrden, botonBurbuja, botonQuicksort, botonSecuencial;
    private JTextArea zonaListaClientes;
    private ListaClientes listaClientes;


    public formulario(){

        listaClientes = new ListaClientes();

        setTitle("Gestion clientes");
        setSize(600, 500);
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
        botonSinOrden = new JButton("Listar sin orden");
        botonBurbuja = new JButton("Ordenar Burbuja");
        botonQuicksort = new JButton("Ordenar Quicksort");
        botonSecuencial = new JButton("Ordenar Secuencial");


        
        Color colorBotones = new Color(0, 40, 99);
        aplicarEstiloBoton(botonAddCliente, colorBotones);
        aplicarEstiloBoton(botonDerecha, colorBotones);
        aplicarEstiloBoton(botonIzquierda, colorBotones);
        aplicarEstiloBoton(botonSinOrden, colorBotones);
        aplicarEstiloBoton(botonBurbuja, colorBotones);
        aplicarEstiloBoton(botonQuicksort, colorBotones);
        aplicarEstiloBoton(botonSecuencial, colorBotones);

        panelBotonesAccion.add(botonAddCliente);
        panelBotonesAccion.add(botonDerecha);
        panelBotonesAccion.add(botonIzquierda);
        panelBotonesAccion.add(botonSinOrden);
        panelBotonesAccion.add(botonBurbuja);
        panelBotonesAccion.add(botonQuicksort);
        panelBotonesAccion.add(botonSecuencial);


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

        botonAddCliente.addActionListener(e->agregarCliente());
        botonDerecha.addActionListener(e->listarDerecha());
        botonIzquierda.addActionListener(e->listarIzquierda());
        botonSinOrden.addActionListener(e -> listarSinOrden());
        botonBurbuja.addActionListener(e -> ordenarBurbuja());
        botonQuicksort.addActionListener(e -> ordenarQuicksort());
        botonSecuencial.addActionListener(e -> ordenarSecuencial());
        botonSalir.addActionListener(e->System.exit(0));
    }
    private void aplicarEstiloBoton(JButton boton,Color colorFondo){

        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);
    }

  
    private void agregarCliente() {
        String cedula = ingresoCedula.getText();
        String nombre = ingresoNombre.getText();

        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.");
        } else {
            Cliente nuevoCliente = new Cliente(cedula, nombre);
            listaClientes.insertarOrdenado(nuevoCliente);
            JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");
        }
    }

   
    private void listarDerecha() {
        String clientes = listaClientes.listar();
        zonaListaClientes.setText(clientes);
    }

    
    private void listarIzquierda() {
        String clientes = listaClientes.listarInvertido();
        zonaListaClientes.setText(clientes);
    }

    private void listarSinOrden() {
        String clientes = listaClientes.listarSinOrden();
        zonaListaClientes.setText(clientes);
    }
    
    private void ordenarBurbuja() {
        zonaListaClientes.setText(listaClientes.ordenarBurbuja());
    }

    private void ordenarQuicksort() {
        zonaListaClientes.setText(listaClientes.ordenarQuicksort());
    }

    private void ordenarSecuencial() {
        zonaListaClientes.setText(listaClientes.ordenarSecuencial());
    }
}

