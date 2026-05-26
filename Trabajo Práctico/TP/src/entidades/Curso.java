package entidades;

import java.util.ArrayList;

public class Curso {
    private int idCurso;
    private String nombre;
    private int cupo;
    private double precio;
    private Profesor profesor;
    private int cantidadParciales;
    private int parcialesAprobadosNecesarios;
    private double notaPromocion;
    private static int ultimoIdCurso = 05;
    private ArrayList<Alumno> alumnos;
    private String turno;

    public Curso(String nombre, int cupo, double precio, Profesor profesor, String turno, int cantidadParciales, int parcialesAprobadosNecesarios, double notaPromocion) {
        this.idCurso = ultimoIdCurso++;
        this.nombre = nombre;
        this.cupo = cupo;
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

    public boolean hayLugar(){
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
