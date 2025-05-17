package R2_A2_S9_DiagramaDeFlujo;

public class Nodo {
    private Cliente cliente;
    private Nodo siguiente;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
