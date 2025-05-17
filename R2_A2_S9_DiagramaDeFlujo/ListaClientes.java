package R2_A2_S9_DiagramaDeFlujo;

// Bicola implementada con lista simple
public class ListaClientes {
    private Nodo inicio; // Referencia al primer nodo de la lista

    public ListaClientes() {
        this.inicio = null;
    }

    // Insertar por la izquierda (al inicio de la lista)
    public void insertarPorIzquierda(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    // Insertar por la derecha (al final de la lista)
    public void insertarPorDerecha(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    // Atender por la izquierda (eliminar y devolver el primer nodo)
    public Cliente atenderPorIzquierda() {
        if (inicio == null) return null;
        Cliente atendido = inicio.getCliente();
        inicio = inicio.getSiguiente();
        return atendido;
    }

    // Atender por la derecha (eliminar y devolver el último nodo)
    public Cliente atenderPorDerecha() {
        if (inicio == null) return null;
        if (inicio.getSiguiente() == null) {
            Cliente atendido = inicio.getCliente();
            inicio = null;
            return atendido;
        }
        Nodo actual = inicio;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Cliente atendido = actual.getSiguiente().getCliente();
        actual.setSiguiente(null);
        return atendido;
    }

    // Listar todos los clientes desde la izquierda a la derecha
    public String listar() {
        if (inicio == null) return "La bicola está vacía.";
        StringBuilder sb = new StringBuilder();
        Nodo actual = inicio;
        while (actual != null) {
            sb.append(actual.getCliente().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
