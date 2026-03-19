package entidades;

public class Persona {
    private String nombre;
    private int dni;
    private static int ultimoDni = 58650142;
    private Fecha fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Persona(){
    }

    public Persona(String nombre, Fecha fecha) {
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
        this.dni = ultimoDni;
        ultimoDni++;
    }

    public String toString(){
        return "Nombre: " + nombre + " DNI: " + dni + " Fecha Nacimiento: " + fechaNacimiento;
    }

    public int edad(){
        Fecha fechaHoy = new Fecha();
        return fechaHoy.diferenciaAnios(fechaNacimiento);
    }
}
