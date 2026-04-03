package entidades;

public class EmpleadoEfectivo extends Empleado{
    private double sueldoBasico;
    private double porcentajeDescuento;

    public EmpleadoEfectivo() {
        super();
    }

    public EmpleadoEfectivo(String nombre, int dni, double sueldoBasico, double porcentajeDescuento) {
        super(nombre, dni);
        this.sueldoBasico = sueldoBasico;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    @Override
    public  double cobrarSueldo(){
        return sueldoBasico-importeDescuentos();
    }
    public String imprimirRecibo()
    {
        return "";
    }
    public double importeDescuentos()
    {
        return sueldoBasico*porcentajeDescuento/100;
    }

    @Override
    public String toString() {
        return "EmpleadoEfectivo{" +
                "nombre='" + nombre + '\'' +
                "sueldo:" + cobrarSueldo() +"}";
    }
}
