package R2_A2_S9_DiagramaDeFlujo;

public class ListaClientes {
    private Nodo inicio = null;

    public void insertarOrdenado(Cliente nuevoCliente) {
        Nodo nuevoNodo = new Nodo(nuevoCliente);
        long cedulaNueva = Long.parseLong(nuevoCliente.getCedula());

        if (inicio == null) {
            // Primer nodo se enlaza consigo mismo (circularidad)
            nuevoNodo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nuevoNodo);
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;

            // Buscar posición ordenada
            do {
                if (cedulaNueva < Long.parseLong(actual.getCliente().getCedula())) break;
                actual = actual.getSiguiente();
            } while (actual != inicio);

            Nodo anterior = actual.getAnterior();

            // Enlazar nuevo nodo
            nuevoNodo.setSiguiente(actual);
            nuevoNodo.setAnterior(anterior);
            anterior.setSiguiente(nuevoNodo);
            actual.setAnterior(nuevoNodo);

            // Si el nuevo nodo debe ser el nuevo inicio (menor cédula)
            if (cedulaNueva < Long.parseLong(inicio.getCliente().getCedula())) {
                inicio = nuevoNodo;
            }
        }
    }

    public String listar() {
        if (inicio == null) return "La lista está vacía.";
        StringBuilder sb = new StringBuilder();
        Nodo actual = inicio;
        do {
            sb.append(actual.getCliente().toString()).append("\n");
            actual = actual.getSiguiente();
        } while (actual != inicio);
        return sb.toString();
    }

    public String listarInvertido() {
        if (inicio == null) return "La lista está vacía.";
        StringBuilder sb = new StringBuilder();
        Nodo actual = inicio.getAnterior(); // último nodo
        do {
            sb.append(actual.getCliente().toString()).append("\n");
            actual = actual.getAnterior();
        } while (actual != inicio.getAnterior());
        return sb.toString();
    }
}