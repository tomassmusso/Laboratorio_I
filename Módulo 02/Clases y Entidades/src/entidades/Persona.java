package entidades;

public class Persona {
    private String nombre;
    private int dni;

    public Persona(){
        // contructor por defecto
    }

    public Persona(String nombre, int dni){
        // constructor
        this.nombre = nombre;
        this.dni = dni;
    }

    public String toString(){

        return "Nombre: " + nombre + "\n" + "DNI: " + dni;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDni(int dni){
        this.dni = dni;
    }

    public String getNombre(){
        return nombre;
    }
}
