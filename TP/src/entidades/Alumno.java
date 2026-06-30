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

    public void setLimiteCursos(int limiteCursos) {
        this.limiteCursos = limiteCursos;
    }

    public void setDeuda(double deuda){
        this.deuda = deuda;
    }

    // MÉTODOS
    public boolean puedeInscribirse(){
        int activas = 0;
        for(Inscripcion inscripcion:inscripciones){
            if(!inscripcion.isFinalizada()){
                activas++;
            }
        }
        return activas < limiteCursos;
    }

    public void inscribirseACurso(Inscripcion inscripcion){
        inscripciones.add(inscripcion);
    }

    public void pagarDeuda(double monto){
        this.deuda -= monto;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}





