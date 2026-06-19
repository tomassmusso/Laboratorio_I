package entidades;

import java.util.*;

public class Inscripcion {
    private int inscripcionId;
    private Alumno alumno;
    private Curso curso;
    private ArrayList<NotaParcial> notasParciales;
    private Double notaFinal;
    private boolean finalizada;


    // CONSTRUCTORES
    public Inscripcion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        notasParciales = new ArrayList<>();
    }

    public Inscripcion(){
        notasParciales = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public int getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(int inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public int getAlumnoId() {
        return alumno.getId();
    }

    public int getCursoId() {
        return curso.getIdCurso();
    }

    public ArrayList<NotaParcial> getNotasParciales() {
        return notasParciales;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void setNotaFinal(Double notaFinal) {
            this.notaFinal = notaFinal;
            this.finalizada = true;
    }

    // MÉTODOS
    public void agregarNotaParcial(NotaParcial nota){
        notasParciales.add(nota);
    }

    public double calcularAcumulado(){
        double acumulado = 0;
        for(NotaParcial nota:notasParciales){
            acumulado += nota.getNota();
        }
        return acumulado;
    }

    public int cantidadNotasCargadas(){
        int cantidad = 0;
        for(NotaParcial nota:notasParciales){
            cantidad++;
        }
        return cantidad;
    }

    public double calcularPromedio(){
        double promedio = 0;
        double acumulado = calcularAcumulado();
        int cantidadNotas = cantidadNotasCargadas();
        if(cantidadNotas == curso.getCantidadParciales()){
            promedio = acumulado / cantidadNotas;
        }
        return promedio;
    }

    public boolean materiaAprobada() {
        return notaFinal != null && notaFinal >= curso.getNotaAprobacion();
    }

    public boolean materiaPromocionada() {
        return notaFinal != null && notaFinal >= curso.getNotaPromocion();
    }

    public String toString(){
        return " ID Curso: " + curso.getIdCurso() + " - ID Alumno: " + alumno.getId() + " - Notas Parciales: " + notasParciales + " - Nota Final: " + notaFinal;
    }
}
