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
    private double notaAprobacion;
    private double notaPromocion;
    private String turno;

    public Curso(String nombre, int cupo, Date fechaInicio, Date fechaFin, double precio, Profesor profesor, String turno, int cantidadParciales, double notaAprobacion, double notaPromocion) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.profesor = profesor;
        this.turno = turno;
        this.cantidadParciales = cantidadParciales;
        this.notaAprobacion = notaAprobacion;
        this.notaPromocion = notaPromocion;
    }

    public Curso(){}

    // GETTERS Y SETTERS
    public int getIdCurso() {
        return idCurso;
    }

    public int getCantidadParciales() {
        return cantidadParciales;
    }

    public double getNotaPromocion() {
        return notaPromocion;
    }

    public double getNotaAprobacion(){
        return notaAprobacion;
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

    // MÉTODOS
    public String informeCurso() {
        return "ID Curso: " + idCurso + " - Nombre: " + nombre + " - Precio: $" + precio + " - Profesor: " + profesor;
    }
}
