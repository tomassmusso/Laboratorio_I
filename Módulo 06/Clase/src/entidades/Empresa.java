package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Empleado> empleados;

    public Empresa(){
        empleados = new ArrayList();
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList();
    }

    public void contratarEmpleado(Empleado nuevo){
        empleados.add(nuevo);
    }

    public double importeTotalLiquidaciones(){
        double total = 0;
        for(Empleado empleado:empleados){
            try{
                total += empleado.cobrarSueldo();
            }
            catch (EmpleadosExceptions err){
                total += 0;
            }
        }
        return total;
    }

    public String imprimirRecibos(){
        String aux = "";
        for(Empleado empleado:empleados){
            aux += empleado.imprimirRecibo() + "\n";
        }
        return aux;
    }

    public void despedirEmpleado(int legajo){
        Empleado buscado = buscar(legajo);
        if(buscado != null){
            empleados.remove(buscado);
        }
    }

    public Empleado buscar(int legajo){
        boolean noEncontre = true;
        Empleado aux = null;
        Iterator<Empleado> iterador = empleados.iterator();
        while(iterador.hasNext() && noEncontre){
            aux = iterador.next();
            if(aux.legajo == legajo){
                noEncontre = false;
            }
        }
        return aux;
    }

    public void despedirEmpleado2(Empleado empleado){
        empleados.remove(empleado);
    }

    public void ordenar(){
        Collections.sort(empleados);
        empleados.sort(null);
    }
}
