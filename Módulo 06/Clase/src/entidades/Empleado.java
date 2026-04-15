package entidades;

import java.util.Objects;

public abstract class Empleado implements IVacacionar, Comparable<Empleado> {
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
    public abstract double cobrarSueldo() throws EmpleadoException;

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getLegajo() {
        return legajo;
    }

    public String imprimirRecibo()
    {
        return "";
    }
    @Override
    public int compareTo(Empleado e) {
       /* if(this.legajo>e.legajo)
            return 1;
        if(this.legajo<e.legajo)
            return -1;
        return 0;*/
        //return this.nombre.compareTo(e.nombre);
        return this.legajo-e.legajo;
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
