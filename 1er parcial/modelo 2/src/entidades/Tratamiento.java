package entidades;

public class Tratamiento {
    private String descripcion;
    private double costo;

    public Tratamiento(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Tratamiento(){}

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}