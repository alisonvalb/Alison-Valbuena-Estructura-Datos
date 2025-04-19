package R2_A2_S9_DiagramaDeFlujo;


public class Nodo {
    private Cliente cliente;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
        this.anterior = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}


