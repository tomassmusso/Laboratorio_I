package entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComidaRapida {
    private String nombre;
    private List<Carrito> pedidos;

    public ComidaRapida(String nombre) {
        this.nombre = nombre;
        pedidos = new ArrayList<>();
    }

    public ComidaRapida(){
        pedidos = new ArrayList<>();
    }

    public void nuevoCarrito(Carrito carrito){
        pedidos.add(carrito);
    }

    public void agregarProductoEnCarrito(int codigoCarrito, Menu menu){
        Carrito buscado = buscar(codigoCarrito);
        if(buscado != null){
            buscado.agregarProducto(menu);
        }
    }

    public Carrito buscar(int codigoCarrito){
        boolean noEncontre = true;
        Carrito aux = null;
        Iterator<Carrito> iterador = pedidos.iterator();
        while (noEncontre && iterador.hasNext()){
            Carrito temp = iterador.next();
            if(temp.getCodigoCarrito() == codigoCarrito){
                aux = temp;
                noEncontre = false;
            }
        }
        return aux;
    }

    public double costoCarrito(int codigoCarrito){
        Carrito buscado = buscar(codigoCarrito);
        double costo = 0;
        if(buscado != null){
            costo = buscado.calcularCostoCarrito();
        }
        return costo;
    }

    public double totalRecaudado(){
        double total = 0;
        for(Carrito carrito:pedidos){
            total += carrito.calcularCostoCarrito();
        }
        return total;
    }
}
