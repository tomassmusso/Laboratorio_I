package entidades;

import java.util.*;

public class Dueno {
    private String nombre;
    private String apellido;
    private String telefono;
    private List<Animal> mascotas;

    public Dueno(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        mascotas = new ArrayList();
    }

    public Dueno(){
        mascotas = new ArrayList();
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void agregarMascota(Animal mascota){
        mascotas.add(mascota);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dueno dueno = (Dueno) o;
        return Objects.equals(telefono, dueno.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(telefono);
    }

    public double totalAPagar(){
        double total = 0;
        for(Animal mascota:mascotas){
            total += mascota.costoConsulta();
        }
        return total;
    }
}