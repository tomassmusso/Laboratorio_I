package entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Comercio {
    private String nombre;
    private List<Cliente> clientes;

    public Comercio(String nombre) {
        this.nombre = nombre;
        clientes = new ArrayList<>();
    }

    public Comercio(){
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public int caloriasACubrir(String telefono){
        Vivienda vivienda = buscarVivienda(telefono);
        int calorias = 0;
        if(vivienda != null){
            calorias = vivienda.caloriasNecesarias() - vivienda.caloriasCubiertas();
        }
        return calorias;
    }

    public Vivienda buscarVivienda(String telefono){
        Cliente buscado = buscar(telefono);
        Vivienda vivienda = null;
        if(buscado != null){
            vivienda = buscado.getVivienda();
        }
        return vivienda;
    }

    public Cliente consultarCliente(String telefono){
        Cliente buscado = buscar(telefono);
        if(buscado != null){
            return buscado;
        }
        return null;
    }

    public Cliente buscar(String telefono){
        boolean noEncontre = true;
        Cliente aux = null;
        Iterator<Cliente> iterador = clientes.iterator();
        while(iterador.hasNext() && noEncontre){
            aux = iterador.next();
            if(aux.getTelefono().equals(telefono)){
                noEncontre = false;
                return aux;
            }
        }
        return null;
    }

    public int caloriasTotalesNecesarias(){
        int total = 0;
        for(Cliente cliente:clientes){
            Vivienda vivienda = cliente.getVivienda();
            if(vivienda != null){
                total += vivienda.caloriasNecesarias();
            }
        }
        return total;
    }
}
