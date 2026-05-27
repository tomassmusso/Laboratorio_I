package entidades;

import java.util.ArrayList;

public class Alumno extends Usuario {
    private int limiteCursos;
    private ArrayList<Inscripcion> inscripciones;
    private double saldo;

    public Alumno(String nombre, String apellido, String mail, String usuario, String contraseña, int limiteCursos) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.limiteCursos = limiteCursos;
        inscripciones = new ArrayList<>();
        this.saldo = 0; // inicializo el saldo de un nuevo alumno a 0
    }

    public Alumno(){
        super();
        inscripciones = new ArrayList<>();
        this.saldo = 0;
    }



    public int getLimiteCursos() {
        return limiteCursos;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public void inscribirseACurso(Inscripcion inscripcion){
        inscripciones.add(inscripcion);
    }

    public boolean puedeInscribirse(){
        int total = contadorCursosInscriptos();
        if(total < limiteCursos){
            return true;
        }
        return false;
    }

    public int contadorCursosInscriptos(){
        int total = 0;
        for(Inscripcion inscripcion:inscripciones){
            total++;
        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + " - Cursos Inscriptos: " + inscripciones;
    }

    /*public void pagarDeuda(double monto){
        this.saldo -= monto;
    }*/
}





