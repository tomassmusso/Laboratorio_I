package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// la clase Pedido presenta una relacion de composicion con Producto, ya que un pedido tiene una lista de productos
public class Pedido {
    private int numero;
    private List<Producto> productos;   // productos es una lista de Producto
    private static int ultimoNumero = 100;
    // fijo como un atributo static al ultimo numero, para que el siguiente se autoincremente en el constructor.

    public Pedido() {
        this.numero = ultimoNumero++;   // autoincremento el numero de pedido
        productos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return getNumero() == pedido.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumero());
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public double calcularImporte(){
        double total = 0;
        for(Producto producto : productos){
            total += producto.calcularPrecioVenta();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido nro: " + numero + " Productos: " + productos.toString();
    }
}
