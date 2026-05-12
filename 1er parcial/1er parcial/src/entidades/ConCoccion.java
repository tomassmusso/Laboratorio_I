package entidades;
// al usar extends Producto, estoy declarando que ConcCoccion es una extensión de Producto, heredando los métodos y atributos definidos alli.
// la clase ConCoccion es un Producto
// hay una relacion de herencia ente Producto y ConCoccion
public class ConCoccion extends Producto {
    private static double recargo = 5000;
    // este atributo lo defino como estático, ya que en el ejercicio se especifica que,
    // si un pedido está cocinado, se debe sumar al costo base, un recargo fijo.

    public ConCoccion(String nombre, double precio) {
        super(nombre, precio);
    }

    public ConCoccion(){
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // este metodo tiene el @Override porque estoy implementando el método definido en la clase padre abstracta
    @Override
    public double calcularPrecioVenta(){
        return consultarPrecio() + recargo;
    }
    // con este método genero polimorfismo, ya que cada clase hija de Porducto (ConCoccion y SinCoccion) lo implementa de una forma diferente.
}
