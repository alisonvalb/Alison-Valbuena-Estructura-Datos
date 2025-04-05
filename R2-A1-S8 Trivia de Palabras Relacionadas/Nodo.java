
public class Nodo {
    private Cliente cliente;
    private Nodo siguiente;

    public Nodo (Cliente cliente){
        this.cliente = cliente;
        this.siguiente=null;
    }
    public Cliente getCliente(){
        return cliente;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }

    public void setCliente( Cliente cliente){
        this.cliente = cliente;
    }

    public void setSiguiente( Nodo siguiente){
        this.siguiente = siguiente;
    }
}
