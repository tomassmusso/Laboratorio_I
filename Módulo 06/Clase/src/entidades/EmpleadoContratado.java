package entidades;

public class EmpleadoContratado extends Empleado{
    private double valorHora;
    private int cantidadHoras;

    public EmpleadoContratado() {
        super();
    }

    public EmpleadoContratado(String nombre, int dni, double valorHora) {
        super(nombre, dni);
        this.valorHora = valorHora;
    }
    public void asignarHorasTrabajadas(int cantidad){
        cantidadHoras=cantidad;
    }
    @Override
    public  double cobrarSueldo() throws EmpleadoException {
        if (cantidadHoras<=0)
        {
            throw new EmpleadoException("No se ingreso cantidad de horas");
        }
        return valorHora*cantidadHoras;
    }
    public String imprimirRecibo()
    {
        return "";
    }

    public boolean equals(Object o)
    {
        return super.equals(o)&&this.valorHora==((EmpleadoContratado)o).valorHora;
    }
    @Override
    public String toString() {
        return "EmpleadoContratado{" +
                "valorHora=" + valorHora +
                ", nombre='" + nombre + '\'' +
                '}';
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
