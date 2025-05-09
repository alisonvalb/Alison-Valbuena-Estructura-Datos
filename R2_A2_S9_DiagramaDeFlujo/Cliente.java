package R2_A2_S9_DiagramaDeFlujo;

public class Cliente {
    private String cedula, nombre;

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para convertir la cédula en un número, rellenando con ceros a la izquierda si es necesario
    public long getCedulaNumerica() {
        // Convertir la cédula en un número, eliminando ceros a la izquierda
        return Long.parseLong(cedula);
    }

    @Override
    public String toString() {
        return "Cedula: " + cedula + "  Nombre: " + nombre;
    }
}

