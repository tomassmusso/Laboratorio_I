package entidades;

import java.util.Objects;

public abstract class Empleado implements Ivacacionar, Comparable<Empleado> {
    private String nombre;
    private String apellido;
    private int dni;
    protected int legajo;
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

    public abstract double cobrarSueldo() throws EmpleadosExceptions;
    public abstract String imprimirRecibo();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return dni == empleado.dni && legajo == empleado.legajo && Objects.equals(nombre, empleado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, legajo);
    }

    @Override
    public int compareTo(Empleado o) {
        // return this.nombre.compareTo(e.nombre);
        return this.legajo - o.legajo;
    }
}
