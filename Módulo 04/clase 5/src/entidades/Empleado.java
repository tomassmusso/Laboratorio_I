package entidades;

import java.util.Objects;

public class Empleado {
    private String nombre;
    private String apellido;
    private int dni;
    private int legajo;
    private static int ultimoLegajo = 100;

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
        try {
            return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni + " Legajo: " + legajo + " Sueldo Cobrado: " + "$" + cobrarSueldo();
        } catch (EmpleadosExceptions err) {
            System.err.println("Ocurrio un error: " + err.getMessage());
        }
        return "Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni + " Legajo: " + legajo;
    }

    public double cobrarSueldo() throws EmpleadosExceptions {
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return getDni() == empleado.getDni() && Objects.equals(getNombre(), empleado.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDni());
    }
}
