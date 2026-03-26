package entidades;

public class Empleado {
    private String nombre;
    private String apellido;
    private int dni;
    private int legajo;
    private int ultimoLegajo = 100;

    public Empleado(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.legajo = ultimoLegajo;
        ultimoLegajo++;
    }

    public Empleado(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni + " Legajo: " + legajo + " Sueldo Cobrado: " + "$" + cobrarSueldo();
    }

    public double cobrarSueldo(){
        return 0;
    }
}
