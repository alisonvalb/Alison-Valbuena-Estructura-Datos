package R2_A2_S9_DiagramaDeFlujo.Controlador;

import R2_A2_S9_DiagramaDeFlujo.modelo.Cliente;
import R2_A2_S9_DiagramaDeFlujo.modelo.ListaClientes;

/**Clase ControladorClientes - gestiona la comunicación entre la vista y el modelo.*/
public class ControladorClientes {
    private ListaClientes listaClientes;

    public ControladorClientes(){
        listaClientes= new ListaClientes();
    }
    public void agregarClientes(String cedula, String nombre){
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        listaClientes.insertarOrdenado(nuevoCliente);
    }

    public String listarDerecha(){
        return listaClientes.listar();
    }
    public String listarIzquierda(){
        return listaClientes.listarInvertido();
    }
}
