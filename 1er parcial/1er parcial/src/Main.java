import entidades.Burguer;
import entidades.ConCoccion;
import entidades.Pedido;
import entidades.SinCoccion;

public class Main{
    public static void main(String[] args){
        // creo la cadena de hamburguesas
        Burguer cadena = new Burguer("McLaboratorio");

        // creo distintos productos
        ConCoccion prod1 = new ConCoccion("Hamburguesa simple con queso", 8000); // $13000 con el recargo
        ConCoccion prod2 = new ConCoccion("Hamburguesa doble con queso", 10000); // $15000 con el recargo
        SinCoccion prod3 = new SinCoccion("Bebida gaseosa", 3000, true); // $3000 + 5% =
        SinCoccion prod4 = new SinCoccion("Juguete promocion", 4000, false); // $4000
        ConCoccion prod5 = new ConCoccion("Cajita Feliz", 6000);    // $11000 con el recargo

        // creo 2 pedidos distintos
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();

        // agrego los productos a los pedidos
        pedido1.agregarProducto(prod1);
        pedido1.agregarProducto(prod2);
        pedido1.agregarProducto(prod3);
        pedido2.agregarProducto(prod4);
        pedido2.agregarProducto(prod5);

        // la cadena toma los pedidos
        cadena.agregarPedido(pedido1);
        cadena.agregarPedido(pedido2);

        // calculo el precio de cada pedido para que los clientes paguen y muestro los pedidos
        double totalPedido1 = pedido1.calcularImporte();
        double totalPedido2 = pedido2.calcularImporte();
        System.out.println("\n------LISTA DE PEDIDOS------");
        System.out.println(pedido1 + " Importe total: $" + totalPedido1 + "\n");
        System.out.println(pedido2 + " Importe total: $" + totalPedido2 + "\n");

        // busco el importe de un pedido puntual utilzando el metodo de la clase Burguer
        System.out.println("\n------PRECIO TOTAL DEL PEDIDO 101------");
        double totalCalculado = cadena.calcularTotalPedido(pedido2.getNumero());
        System.out.println("Importe total del pedido nro " + pedido2.getNumero() + ": $" + totalCalculado);
    }
}