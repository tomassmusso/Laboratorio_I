package entidades;

import java.util.ArrayList;

public class Alumno extends Usuario {
    private int limiteCursos;
    private ArrayList<Inscripcion> inscripciones;
    private double deuda;

    // CONSTRUCTORES
    public Alumno(String nombre, String apellido, String mail, String usuario, String contraseña, int limiteCursos) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.limiteCursos = limiteCursos;
        inscripciones = new ArrayList<>();
        this.deuda = 0;
    }

    public Alumno(){
        super();
        inscripciones = new ArrayList<>();
        this.deuda = 0;
    }

    // GETTERS Y SETTERS
    public int getLimiteCursos() {
        return limiteCursos;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public double getDeuda() {
        return deuda;
    }

    // MÉTODOS
    public boolean puedeInscribirse(){
        int total = contadorCursosInscriptos();
        return total < limiteCursos;
    }

    public void inscribirseACurso(Inscripcion inscripcion){
        inscripciones.add(inscripcion);
    }

    public int contadorCursosInscriptos(){
        int total = 0;
        for(Inscripcion inscripcion:inscripciones){
            total++;
        }
        return total;
    }

    public void aumentarDeuda(double monto){
        this.deuda += monto;
    }

    public void pagarDeuda(double monto){
        this.deuda -= monto;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}





