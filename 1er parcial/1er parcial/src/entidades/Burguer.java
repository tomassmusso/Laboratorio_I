package entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// esta clase tiene una relacion de composicion con Pedido, ya que una cadena de hamburguesas cuenta con distintos pedidos
public class Burguer {
    private List<Pedido> pedidos;
    private String nombre;

    public Burguer(String nombre) {
        pedidos = new ArrayList<>();
        this.nombre = nombre;
    }

    public Burguer(){
        pedidos = new ArrayList<>();
    }

    // por mas que no esté especificado en la consigna, al método de agregar pedido le pasé como parámetro un pedido.
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public double calcularTotalPedido(int numeroPedido){
        Pedido buscado = buscar(numeroPedido);
        double total = 0;
        if(buscado != null){
            total = buscado.calcularImporte();
        }
        return total;
    }

    public Pedido buscar(int numeroPedido){
        boolean noEncontre = true;
        Pedido aux = null;
        Iterator<Pedido> iterador = pedidos.iterator();
        while(iterador.hasNext() && noEncontre){
            Pedido temporal = iterador.next();
            if(temporal.getNumero() == numeroPedido){
                noEncontre = false;
                aux = temporal;
            }
        }
        return aux;
    }
}
