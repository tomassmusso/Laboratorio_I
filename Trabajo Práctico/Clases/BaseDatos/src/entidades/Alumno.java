package entidades;

import java.util.ArrayList;

public class Alumno {
    private int id;
    private String nombre;
    private int nota;
    //private ArrayList<Materia> materias;


    public Alumno() {
    }

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public void cambiarNota(int nota){
             this.nota=nota;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
