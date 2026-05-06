package entidades;

import java.util.ArrayList;

public class Inscripcion {
    private Alumno alumno;
    private Curso curso;
    private ArrayList<Double> notasParciales;
    private Double notaFinal;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        notasParciales = new ArrayList<>();
    }

    public Inscripcion(){
        notasParciales = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
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
        return "Curso: " + curso.toString() + " - Alumno: " + alumno.toString() + " - Notas Parciales: " + notasParciales + " - Nota Final: " + notaFinal;
    }
}
