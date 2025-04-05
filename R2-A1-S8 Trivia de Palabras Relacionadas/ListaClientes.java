public class ListaClientes {
    private Nodo inicial;

    public ListaClientes(){

        this.inicial = null;

    }
    public void insertarOrdenado(Cliente nuevoCliente){
        Nodo nuevoNodo = new Nodo(nuevoCliente);

        if (inicial == null || nuevoCliente.getCedula().compareTo(inicial.getCliente().getCedula())<0){
            nuevoNodo.setSiguiente(inicial);
            inicial = nuevoNodo;
        } else {
            Nodo actual = inicial;
            while (actual.getSiguiente() !=null &&
            nuevoCliente.getCedula().compareTo(actual.getSiguiente().getCliente().getCedula())>0) {
             actual= actual.getSiguiente();   
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        
    }


public String listar (){
    if (inicial==null){

        return "la lista esta vacia";

    }else{
        StringBuilder listaTexto = new StringBuilder();
        Nodo actual = inicial;
        while (actual !=null){
            listaTexto.append(actual.getCliente().toString()).append("\n");
            actual= actual.getSiguiente();
        }
         
    return listaTexto.toString();
}
}
}
