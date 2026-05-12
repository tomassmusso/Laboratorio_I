package entidades;
// al usar extends Producto, estoy declarando que SinCoccion es una extensión de Producto, heredando los métodos y atributos definidos alli.
// la clase SinCoccion es un Producto
// hay una relacion de herencia ente Producto y SinCoccion
public class SinCoccion extends Producto {
    private boolean conRefrigeracion;
    // decidi cambiar el tipo de dato del atributo conRefrigeracion a un boolean, porque me parece mejor para representar
    // si un producto necesita refrigereación en un sistema de cadena de hamburguesas, evitando confusiones con los 0 y 1.

    public SinCoccion(String nombre, double precio, boolean conRefrigeracion) {
        super(nombre, precio);
        this.conRefrigeracion = conRefrigeracion;
    }

    public SinCoccion() {
        super();
    }

    // este metodo tiene el @Override porque estoy implementando el método definido en la clase padre abstracta
    @Override
    public double calcularPrecioVenta(){
        double precio = consultarPrecio();
        if(conRefrigeracion){
            precio += (precio * 5) / 100;   // en caso de ser refrigerado, se le agrega al precio un 5% extra.
        }
        return precio;
    }
    // con este método genero polimorfismo, ya que cada clase hija de Porducto (ConCoccion y SinCoccion),
    // lo implementa de una forma diferente.


    @Override
    public String toString() {
        return super.toString() + " Refigerado: " + conRefrigeracion;
    }
}
