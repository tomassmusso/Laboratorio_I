package entidades;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private String cliente;
    private int codigoCarrito;
    private static int ultimoCodigo = 100;
    private List<Menu> productos;

    public Carrito(String cliente) {
        this.cliente = cliente;
        productos = new ArrayList<>();
        this.codigoCarrito = ultimoCodigo++;
    }

    public Carrito(){
        productos = new ArrayList<>();
    }

    public int getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(int codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
    }

    public void agregarProducto(Menu menu){
        productos.add(menu);
    }

    public double calcularCostoCarrito(){
        double total = 0;
        for(Menu producto:productos){
            total += producto.calcularCosto();
        }
        return total;
    }
}
