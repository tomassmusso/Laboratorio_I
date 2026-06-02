package entidades;

import java.util.*;

public class Curso {
    private int idCurso;
    private String nombre;
    private int cupo;
    private Date fechaInicio;
    private Date fechaFin;
    private double precio;
    private Date fechaInicioDescuento;
    private Date fechaFinDescuento;
    private double precioDescuento;
    private Profesor profesor;
    private int cantidadParciales;
    private double notaAprobacion;
    private double notaPromocion;
    private String turno;

    public Curso(String nombre, int cupo, Date fechaInicio, Date fechaFin, double precio, Date fechaInicioDescuento, Date fechaFinDescuento, double precioDescuento, Profesor profesor, String turno, int cantidadParciales, double notaAprobacion, double notaPromocion) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.fechaInicioDescuento = fechaInicioDescuento;
        this.fechaFinDescuento = fechaFinDescuento;
        this.precioDescuento = precioDescuento;
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

    public Date getFechaInicioDescuento() {
        return fechaInicioDescuento;
    }

    public Date getFechaFinDescuento() {
        return fechaFinDescuento;
    }

    public double getPrecioDescuento() {
        return precioDescuento;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getTurno() {
        return turno;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    // MÉTODOS
    public double getPrecioActual(){
        Date hoy = new Date();
        if(hoy.after(fechaInicioDescuento) && hoy.before(fechaFinDescuento)){
            return precioDescuento;
        }
        return precio;
    }

    public String informeCurso() {
        return "ID Curso: " + idCurso + " - Nombre: " + nombre + " - Precio: $" + precio + " - Profesor: " + profesor;
    }
}
