package entidades;

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
    public String toString() {
        return super.toString() + "\n" + " Sueldo: " + "$" + sueldoBasico + " Porcentaje Descontado: " + "%" + procentajeDescuento;
    }
}
