package R2_A2_S9_DiagramaDeFlujo.modelo;

public class Cliente{

    private String cedula, nombre;

    public Cliente (String cedula, String nombre){
   
    this.cedula = cedula;
    this.nombre = nombre;

    }


    public String getCedula(){
    return cedula;
    }


    public String getNombre(){
    return nombre;
    }



     public String toString(){
    return "Cedula:" + cedula + "  " + "Nombre:" + nombre;
    }
}
