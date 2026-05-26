package entidades;

import java.util.ArrayList;

public class Inscripcion {
    private int alumnoId;
    private int cursoId;
    private Alumno alumno;
    private Curso curso;
    private ArrayList<Double> notasParciales;
    private Double notaFinal;

    public Inscripcion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.alumnoId = alumno.getId();
        this.cursoId = curso.getIdCurso();
        notasParciales = new ArrayList<>();
    }

    public Inscripcion(){
        notasParciales = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public ArrayList<Double> getNotasParciales() {
        return notasParciales;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public Curso getCurso() {
        return curso;
    }

    public void agregarNotaParcial(double nota){
        notasParciales.add(nota);
    }

    public void setNotaFinal(double nota){
        if(estadoMateria()){
            this.notaFinal = nota;
        }
    }

    public boolean estadoMateria(){
        double acumulado = 0;
        int aprobados = 0;
        for(Double nota : notasParciales){
            acumulado += nota;
            if(nota >= 4){
                aprobados++;
            }
        }
        if(aprobados >= curso.getParcialesAprobadosNecesarios()){
            double promedio = acumulado / curso.getCantidadParciales();
            if(promedio >= curso.getNotaPromocion()){
                this.notaFinal = promedio;
            }
            return true;
        }
        return false;
    }

    public String toString(){
        return " ID Curso: " + cursoId + " - ID Alumno: " + alumnoId + " - Notas Parciales: " + notasParciales + " - Nota Final: " + notaFinal;
    }
}
