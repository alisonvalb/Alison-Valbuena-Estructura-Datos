package R2_A2_S9_DiagramaDeFlujo;

import javax.swing.*;
import java.awt.*;

public class formulario extends JFrame {
    private JTextField ingresoCedula, ingresoNombre;
    private JButton botonInsertarIzquierda, botonInsertarDerecha;
    private JButton botonAtenderIzquierda, botonAtenderDerecha;
    private JButton botonListar;
    private JButton botonSalir;
    private JTextArea zonaListaClientes;
    private ListaClientes listaClientes;

    public formulario() {
        listaClientes = new ListaClientes();

        setTitle("Gestión clientes");
        setSize(550, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(170, 202, 250));

        // Panel para ingreso datos
        JPanel panelIngreso = new JPanel(new GridLayout(4, 2, 5, 5));
        panelIngreso.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelIngreso.setBackground(new Color(170, 202, 250));

        panelIngreso.add(new JLabel("Ingrese número de cédula:"));
        ingresoCedula = new JTextField();
        panelIngreso.add(ingresoCedula);

        panelIngreso.add(new JLabel("Ingrese nombre:"));
        ingresoNombre = new JTextField();
        panelIngreso.add(ingresoNombre);

        // Panel botones bicola (sin salir)
        JPanel panelBicola = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBicola.setBackground(new Color(170, 202, 250));

        botonInsertarIzquierda = new JButton("Insertar Izquierda");
        botonInsertarDerecha = new JButton("Insertar Derecha");
        botonAtenderIzquierda = new JButton("Atender Izquierda");
        botonAtenderDerecha = new JButton("Atender Derecha");
        botonListar = new JButton("Listar");

        Color colorBotones = new Color(0, 40, 99);
        aplicarEstiloBoton(botonInsertarIzquierda, colorBotones);
        aplicarEstiloBoton(botonInsertarDerecha, colorBotones);
        aplicarEstiloBoton(botonAtenderIzquierda, colorBotones);
        aplicarEstiloBoton(botonAtenderDerecha, colorBotones);
        aplicarEstiloBoton(botonListar, colorBotones);

        panelBicola.add(botonInsertarIzquierda);
        panelBicola.add(botonInsertarDerecha);
        panelBicola.add(botonAtenderIzquierda);
        panelBicola.add(botonAtenderDerecha);
        panelBicola.add(botonListar);

        // Área de texto para mostrar lista
        zonaListaClientes = new JTextArea();
        zonaListaClientes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zonaListaClientes);

        // Panel central: botones arriba y área texto centro
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(new Color(170, 202, 250));
        panelCentral.add(panelBicola, BorderLayout.NORTH);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        // Panel para el botón salir solo abajo
        JPanel panelSalir = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSalir.setBackground(new Color(170, 202, 250));
        botonSalir = new JButton("Salir");
        aplicarEstiloBoton(botonSalir, colorBotones);
        panelSalir.add(botonSalir);

        // Agregar componentes al JFrame
        add(panelIngreso, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelSalir, BorderLayout.SOUTH);

        // Eventos
        botonInsertarIzquierda.addActionListener(e -> insertarIzquierda());
        botonInsertarDerecha.addActionListener(e -> insertarDerecha());
        botonAtenderIzquierda.addActionListener(e -> atenderIzquierda());
        botonAtenderDerecha.addActionListener(e -> atenderDerecha());
        botonListar.addActionListener(e -> listar());
        botonSalir.addActionListener(e -> System.exit(0));
    }

    private void aplicarEstiloBoton(JButton boton, Color colorFondo) {
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);
    }

    private void insertarIzquierda() {
        String cedula = ingresoCedula.getText().trim();
        String nombre = ingresoNombre.getText().trim();
        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.");
            return;
        }
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        listaClientes.insertarPorIzquierda(nuevoCliente);
        JOptionPane.showMessageDialog(this, "Cliente insertado por la izquierda.");
        limpiarCampos();
    }

    private void insertarDerecha() {
        String cedula = ingresoCedula.getText().trim();
        String nombre = ingresoNombre.getText().trim();
        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos.");
            return;
        }
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        listaClientes.insertarPorDerecha(nuevoCliente);
        JOptionPane.showMessageDialog(this, "Cliente insertado por la derecha.");
        limpiarCampos();
    }

    private void atenderIzquierda() {
        Cliente atendido = listaClientes.atenderPorIzquierda();
        if (atendido != null) {
            JOptionPane.showMessageDialog(this, "Atendido (izquierda): " + atendido.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No hay clientes por atender.");
        }
    }

    private void atenderDerecha() {
        Cliente atendido = listaClientes.atenderPorDerecha();
        if (atendido != null) {
            JOptionPane.showMessageDialog(this, "Atendido (derecha): " + atendido.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No hay clientes por atender.");
        }
    }

    private void listar() {
        String listado = listaClientes.listar();
        zonaListaClientes.setText(listado);
    }

    private void limpiarCampos() {
        ingresoCedula.setText("");
        ingresoNombre.setText("");
    }
}
