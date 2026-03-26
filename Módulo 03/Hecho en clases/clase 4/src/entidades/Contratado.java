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

    @Override
    public double cobrarSueldo(){
        return valorHora * cantidadHoras;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + " Cantidad Horas: " + cantidadHoras + " Valor Hora: " + valorHora + "$";
    }
}
