package entidades;

import java.util.ArrayList;

public class Alumno extends Usuario {
    private int limiteCursos;
    private ArrayList<Curso> cursos;
    private double saldo;

    public Alumno(String nombre, String apellido, String mail, String usuario, String contraseña, int limiteCursos) {
        super(nombre, apellido, mail, usuario, contraseña);
        this.limiteCursos = limiteCursos;
        cursos = new ArrayList<>();
        this.saldo = 0; // inicializo el saldo de un nuevo alumno a 0
    }

    public Alumno(){
        super();
        cursos = new ArrayList<>();
        this.saldo = 0;
    }

    public int getLimiteCursos() {
        return limiteCursos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void agregarCurso(Curso curso){
        cursos.add(curso);
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
        for(Curso curso:cursos){
            total++;
        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + " - Cursos Inscriptos: " + cursos;
    }

    /*public void pagarDeuda(double monto){
        this.saldo -= monto;
    }*/
}





