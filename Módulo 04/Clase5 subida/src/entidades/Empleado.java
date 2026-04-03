package entidades;

import java.util.Objects;

public class Empleado {
    protected String nombre;
    private int dni;
    private int legajo;


    private static int ultimoLegajo=100;


    public Empleado()
    {
        super();
    }
    public Empleado(String nombre, int dni)
    {
       this.nombre=nombre;
       this.dni=dni;
        legajo=ultimoLegajo;
        incrementarUltimo();
    }
   @Override
    public String toString()
    {
        return super.toString() + "Legajo: " +legajo;
    }
    private static void incrementarUltimo() {
        ultimoLegajo++;
    }
    public double cobrarSueldo() throws EmpleadoException {
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String imprimirRecibo()
    {
        return "";
    }
   /* @Override
    public boolean equals(Object o){
        if (o==null)
            return false;
        if (!(o instanceof Empleado))
            return false;
        Empleado aux=(Empleado)o;
        if(aux.getDni()==this.getDni()&&aux.getNombre().equals(this.getNombre()))
            return true;
        else
            return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Empleado empleado = (Empleado) o;
        return dni == empleado.dni && legajo == empleado.legajo && Objects.equals(nombre, empleado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, legajo);
    }
}
