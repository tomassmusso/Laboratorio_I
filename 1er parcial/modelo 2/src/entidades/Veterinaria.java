package entidades;

import java.util.*;

public class Veterinaria {
    private String nombre;
    private List<Dueno> duenos;

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        duenos = new ArrayList();
    }

    public Veterinaria(){
        duenos = new ArrayList();
    }

    public void agregarDueno(Dueno nuevo){
        duenos.add(nuevo);
    }

    public double consultarDeudaDueno(String telefono){
        Dueno buscado = buscar(telefono);
        double total = 0;
        if(buscado != null){
            total = buscado.totalAPagar();
        }
        return total;
    }

    public double consultarRecaudacionTotal(){
        double total = 0;
        for(Dueno dueno:duenos){
            total += dueno.totalAPagar();
        }
        return total;
    }

    public Dueno buscar(String telefono){
        boolean noEncontre = true;
        Dueno aux = null;
        Iterator<Dueno> iterador = duenos.iterator();
        while(iterador.hasNext() && noEncontre){
            Dueno temporal = null;  // declaro un temporal pq, en caso que no encuentre a ningun dueño con el telefono pasado, me va a devolver el ultimo que iteró
            temporal = iterador.next();
            // if(temporal.getTelefono().equals(telefono))
            if(Objects.equals(temporal.getTelefono(), telefono)){
                noEncontre = false;
                aux = temporal;
            }
        }
        return aux;
    }
}