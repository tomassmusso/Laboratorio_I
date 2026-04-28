package entidades;

import java.util.*;

public abstract class Animal {
    private String nombre;
    private double peso;
    protected List<Tratamiento> tratamientos;

    public Animal(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
        tratamientos = new ArrayList();
    }

    public Animal(){
        tratamientos = new ArrayList();
    }

    public abstract double costoConsulta();
}