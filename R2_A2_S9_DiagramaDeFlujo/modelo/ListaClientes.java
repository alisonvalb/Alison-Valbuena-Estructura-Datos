package R2_A2_S9_DiagramaDeFlujo.modelo;

public class ListaClientes {
    private Nodo inicial;

    
    public ListaClientes() {
        this.inicial = null;
    }

    
    public void insertarOrdenado(Cliente nuevoCliente) {
        Nodo nuevoNodo = new Nodo(nuevoCliente);
        Long cedulaNueva = Long.parseLong(nuevoCliente.getCedula());
    
        if (inicial == null || cedulaNueva < Long.parseLong(inicial.getCliente().getCedula())) {
            nuevoNodo.setSiguiente(inicial);
            if (inicial != null) {
                inicial.setAnterior(nuevoNodo);
            }
            inicial = nuevoNodo;
        } else {
            Nodo actual = inicial;
            while (actual.getSiguiente() != null &&
                   cedulaNueva > Long.parseLong(actual.getSiguiente().getCliente().getCedula())) {
                actual = actual.getSiguiente();
            }
    
            nuevoNodo.setSiguiente(actual.getSiguiente());
            nuevoNodo.setAnterior(actual);
            actual.setSiguiente(nuevoNodo);
    
            if (nuevoNodo.getSiguiente() != null) {
                nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
            }
        }
    }
    
    

    public String listar() {
        if (inicial == null) {
            return "La lista está vacía.";
        } else {
            StringBuilder listaTexto = new StringBuilder();
            Nodo actual = inicial;

            while (actual != null) {
                listaTexto.append(actual.getCliente().toString()).append("\n");
                actual = actual.getSiguiente();
            }
            return listaTexto.toString();
        }
    }

   
    public String listarInvertido() {
        if (inicial == null) {
            return "La lista está vacía.";
        } else {
            Nodo actual = inicial;

          
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            StringBuilder listaTexto = new StringBuilder();

            
            while (actual != null) {
                listaTexto.append(actual.getCliente().toString()).append("\n");
                actual = actual.getAnterior();
            }

            return listaTexto.toString();
        }
    }
}