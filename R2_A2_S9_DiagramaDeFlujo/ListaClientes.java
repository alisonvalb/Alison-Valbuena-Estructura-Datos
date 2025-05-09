package R2_A2_S9_DiagramaDeFlujo;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {
    private Nodo inicial;
    private Nodo cabezaSinOrden;

    public ListaClientes() {
        this.inicial = null;
        this.cabezaSinOrden = null;
    }

    // Método para insertar ordenado (doblemente enlazada)
    public void insertarOrdenado(Cliente nuevoCliente) {
        Nodo nuevoNodo = new Nodo(nuevoCliente);

        if (inicial == null || nuevoCliente.getCedulaNumerica() < inicial.getCliente().getCedulaNumerica()) {
            nuevoNodo.setSiguiente(inicial);
            if (inicial != null) {
                inicial.setAnterior(nuevoNodo);
            }
            inicial = nuevoNodo;
        } else {
            Nodo actual = inicial;
            while (actual.getSiguiente() != null &&
                   nuevoCliente.getCedulaNumerica() > actual.getSiguiente().getCliente().getCedulaNumerica()) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            nuevoNodo.setAnterior(actual);
            actual.setSiguiente(nuevoNodo);

            if (nuevoNodo.getSiguiente() != null) {
                nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
            }
        }

        insertarFinalSinOrden(nuevoCliente); // También insertar en lista desordenada
    }

    // Insertar al final de la lista sin orden
    private void insertarFinalSinOrden(Cliente nuevoCliente) {
        Nodo nuevoNodo = new Nodo(nuevoCliente);
        if (cabezaSinOrden == null) {
            cabezaSinOrden = nuevoNodo;
        } else {
            Nodo actual = cabezaSinOrden;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    // Listar ordenado (doblemente enlazada de izquierda a derecha)
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

    // Listar invertido (de derecha a izquierda)
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

    // Listar sin orden
    public String listarSinOrden() {
        if (cabezaSinOrden == null) {
            return "La lista está vacía.";
        } else {
            StringBuilder listaTexto = new StringBuilder();
            Nodo actual = cabezaSinOrden;
            while (actual != null) {
                listaTexto.append(actual.getCliente().toString()).append("\n");
                actual = actual.getSiguiente();
            }
            return listaTexto.toString();
        }
    }

    // Ordenamiento BURBUJA
    public String ordenarBurbuja() {
        if (cabezaSinOrden == null) return "La lista está vacía.";

        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabezaSinOrden;
        while (actual != null) {
            clientes.add(actual.getCliente());
            actual = actual.getSiguiente();
        }

        for (int i = 0; i < clientes.size() - 1; i++) {
            for (int j = 0; j < clientes.size() - i - 1; j++) {
                if (clientes.get(j).getCedulaNumerica() > clientes.get(j + 1).getCedulaNumerica()) {
                    Cliente temp = clientes.get(j);
                    clientes.set(j, clientes.get(j + 1));
                    clientes.set(j + 1, temp);
                }
            }
        }

        StringBuilder listaTexto = new StringBuilder();
        for (Cliente c : clientes) {
            listaTexto.append(c.toString()).append("\n");
        }
        return listaTexto.toString();
    }

    // Ordenamiento QUICKSORT
    public String ordenarQuicksort() {
        if (cabezaSinOrden == null) return "La lista está vacía.";

        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabezaSinOrden;
        while (actual != null) {
            clientes.add(actual.getCliente());
            actual = actual.getSiguiente();
        }

        quicksort(clientes, 0, clientes.size() - 1);

        StringBuilder listaTexto = new StringBuilder();
        for (Cliente c : clientes) {
            listaTexto.append(c.toString()).append("\n");
        }
        return listaTexto.toString();
    }

    private void quicksort(List<Cliente> lista, int inicio, int fin) {
        if (inicio < fin) {
            int pi = particion(lista, inicio, fin);
            quicksort(lista, inicio, pi - 1);
            quicksort(lista, pi + 1, fin);
        }
    }

    private int particion(List<Cliente> lista, int inicio, int fin) {
        Cliente pivote = lista.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getCedulaNumerica() <= pivote.getCedulaNumerica()) {
                i++;
                Cliente temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }
        Cliente temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fin));
        lista.set(fin, temp);
        return i + 1;
    }

    // Ordenamiento SECUENCIAL (por selección)
    public String ordenarSecuencial() {
        if (cabezaSinOrden == null) return "La lista está vacía.";

        List<Cliente> clientes = new ArrayList<>();
        Nodo actual = cabezaSinOrden;
        while (actual != null) {
            clientes.add(actual.getCliente());
            actual = actual.getSiguiente();
        }

        for (int i = 0; i < clientes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < clientes.size(); j++) {
                if (clientes.get(j).getCedulaNumerica() < clientes.get(minIndex).getCedulaNumerica()) {
                    minIndex = j;
                }
            }
            Cliente temp = clientes.get(i);
            clientes.set(i, clientes.get(minIndex));
            clientes.set(minIndex, temp);
        }

        StringBuilder listaTexto = new StringBuilder();
        for (Cliente c : clientes) {
            listaTexto.append(c.toString()).append("\n");
        }
        return listaTexto.toString();
    }
}
