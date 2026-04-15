package entidades;

import java.util.*;

public class Empresa {
    private String nombre;
    private List<Empleado> empleados;


    public Empresa() {
        empleados=new ArrayList();
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleados=new ArrayList();
    }
    public void contratarEmpleado(Empleado nuevo)
    {
        empleados.add(nuevo);
    }
    public double importeTotalLiquidaciones()
    {
        double total=0;
       /* for(int i=0; i<empleados.size();i++) {
            try {
                total += empleados.get(i).cobrarSueldo();
            }
            catch (EmpleadoException e)
            {
                total+=0;
            }
        }*/
        for(Empleado empleado:empleados){
            try {
                total += empleado.cobrarSueldo();
            }
            catch (EmpleadoException e)
            {
                total+=0;
            }
        }

        return total;
    }
    public String imprimirRecibos()
    {
        String auxiliar="";
        for(Empleado empleado:empleados)
        {
            auxiliar+=empleado.imprimirRecibo() + "\n";
        }
        return auxiliar;
    }
    public void pagarSueldos()
    {

    }
    public void despedirEmpleado(int legajo)
    {
       /* boolean noEncontre=true;
        Iterator<Empleado> iterador=empleados.iterator();
        while(iterador.hasNext()&&noEncontre)
        {
            Empleado empAux=iterador.next();
            if(empAux.getLegajo()==legajo) {
                iterador.remove();
                noEncontre=false;
            }
        }*/
        Empleado buscado=buscar(legajo);
        if (buscado!=null)
            empleados.remove(buscado);
    }
    public void despedirEmpleado(Empleado empleado)
    {
        empleados.remove(empleado);
    }
    public Empleado buscar(int legajo)
    {
        boolean noEncontre=true;
        Empleado empAux=null;
        Iterator<Empleado> iterador=empleados.iterator();
        while(iterador.hasNext()&&noEncontre)
        {
            empAux=iterador.next();
            if(empAux.getLegajo()==legajo) {
                noEncontre=false;
            }
        }
        return empAux;
    }
    public void ordenar(){
        Collections.sort(empleados);
        empleados.sort(null);

    }
}
