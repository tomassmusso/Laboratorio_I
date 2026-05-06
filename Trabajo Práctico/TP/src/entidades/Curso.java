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
    private ArrayList<Inscripcion> inscripciones;
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
        inscripciones = new ArrayList<>();
    }

    public Curso(){
        inscripciones = new ArrayList<>();
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

    public double cantidadRecaudado(){
        double total = 0;
        for(Inscripcion inscripcion:inscripciones){
            total += precio;
        }
        return total;
    }

    public String informeCurso() {
        return "ID Curso: " + idCurso + " - Nombre: " + nombre + " - Precio: $" + precio + " - Profesor: " + profesor + " - Inscriptos: " + inscripciones + " - Total Recaudado: $" + cantidadRecaudado();
    }
}
