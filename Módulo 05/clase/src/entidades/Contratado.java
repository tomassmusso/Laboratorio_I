package entidades;

public class Contratado extends Empleado{
    private double valorHora;
    private int cantidadHoras;

    public Contratado(){
        super();
    }

    public Contratado(String nombre, String apellido, int dni, double valorHora){
        super(nombre, apellido, dni);
        this.valorHora = valorHora;
    }

    public void asignarHoras(int cantidad){
        cantidadHoras = cantidad;
    }

    // una excepción es una interrupción por software
    // ejemplo: el pantallazo azul
    @Override
    public double cobrarSueldo() throws EmpleadosExceptions {
        if(cantidadHoras <= 0){
            throw new EmpleadosExceptions("No se ingreso cantidad de horas");
        }
        return valorHora * cantidadHoras;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + " Cantidad Horas: " + cantidadHoras + " Valor Hora: " + "$" + valorHora;
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
