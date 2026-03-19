package entidades;

public class Empleado extends Persona{
    private int legajo;
    private static int ultimoLegajo = 100;

    public Empleado(){
        super();
    }
    // lo que hace super es llamar al constructor de la clase que hereda
    public Empleado(String nombre, int dni, Fecha fechaNacimiento){
        super(nombre, fechaNacimiento);
        legajo = ultimoLegajo;
        ultimoLegajo++;
    }

    public String toString(){
        return super.toString() + " Legajo: " + legajo;
    }
}
