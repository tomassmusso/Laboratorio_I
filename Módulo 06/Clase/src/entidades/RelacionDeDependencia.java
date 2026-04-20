package entidades;
// una clase no abstracta es una clase completa
public class RelacionDeDependencia extends Empleado{
    private double sueldoBasico;
    private double procentajeDescuento;

    public RelacionDeDependencia(){
        super();
    }

    public RelacionDeDependencia(String nombre, String apellido, int dni, double sueldoBasico, double procentajeDescuento) {
        super(nombre, apellido, dni);
        this.sueldoBasico = sueldoBasico;
        this.procentajeDescuento = procentajeDescuento;
    }

    public double importeDescuentos(){
        return (sueldoBasico * procentajeDescuento) / 100;
    }

    @Override
    public double cobrarSueldo(){
        return sueldoBasico - importeDescuentos();
    }

    @Override
    public String imprimirRecibo() {
        return "RECIBO DE SUELDO - EMPLEADO EFECTIVO\n" +
                "Nombre: " + this.getNombre() + " | Legajo: " + this.legajo + "\n" +
                "Sueldo Básico: $" + this.sueldoBasico + "\n" +
                "Descuentos: $" + this.importeDescuentos() + "\n" +
                "NETO A COBRAR: $" + this.cobrarSueldo() + "\n" +
                "---------------------------------------";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + " Sueldo: " + "$" + sueldoBasico + " Porcentaje Descontado: " + procentajeDescuento + "%";
    }

    @Override
    public int diasVacaciones() {
        return 0;
    }

    @Override
    public boolean vacacionesPendientes() {
        return false;
    }
}
