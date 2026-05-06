package entidades;

import java.util.ArrayList;

public class Alumno extends Usuario {
    private int limiteCursos;
    private ArrayList<Inscripcion> inscripciones;
    //private double saldo;

    public Alumno(String nombre, String apellido, String mail, String usuario, String contraseña, int limiteCursos) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.limiteCursos = limiteCursos;
        inscripciones = new ArrayList<>();
    }

    public Alumno(){
        super();
        inscripciones = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString() + " - Inscripciones: " + inscripciones;
    }

    /*public void pagarDeuda(double monto){
        this.saldo -= monto;
    }*/



}





