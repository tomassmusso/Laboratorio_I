package entidades;

import java.util.*;

public class Curso {
    private int idCurso;
    private String nombre;
    private int cupo;
    private Date fechaInicio;
    private Date fechaFin;
    private double precio;
    private Profesor profesor;
    private int cantidadParciales;
    private int parcialesAprobadosNecesarios;
    private double notaPromocion;
    private ArrayList<Alumno> alumnos;
    private String turno;

    public Curso(String nombre, int cupo, Date fechaInicio, Date fechaFin, double precio, Profesor profesor, String turno, int cantidadParciales, int parcialesAprobadosNecesarios, double notaPromocion) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.profesor = profesor;
        this.turno = turno;
        this.cantidadParciales = cantidadParciales;
        this.parcialesAprobadosNecesarios = parcialesAprobadosNecesarios;
        this.notaPromocion = notaPromocion;
        alumnos = new ArrayList<>();
    }

    public Curso(){
        alumnos = new ArrayList<>();
    }

    public int getIdCurso() {
        return idCurso;
    }

    public int getCantidadParciales() {
        return cantidadParciales;
    }

    public int getParcialesAprobadosNecesarios() {
        return parcialesAprobadosNecesarios;
    }

    public double getNotaPromocion() {
        return notaPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public double getPrecio() {
        return precio;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getTurno() {
        return turno;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void agregarAlumno(Alumno alumno){
        alumnos.add(alumno);
    }

    public double cantidadRecaudado(){
        double total = 0;
        for(Alumno alumno:alumnos){
            total += precio;
        }
        return total;
    }

    public boolean hayCupo(){
        int totalInscriptos = 0;
        for(Alumno alumno:alumnos){
            totalInscriptos++;
        }
        if (totalInscriptos < cupo){
            return true;
        }
        return false;
    }

    public String informeCurso() {
        return "ID Curso: " + idCurso + " - Nombre: " + nombre + " - Precio: $" + precio + " - Profesor: " + profesor + " - Inscriptos: " + alumnos + " - Total Recaudado: $" + cantidadRecaudado();
    }
}
