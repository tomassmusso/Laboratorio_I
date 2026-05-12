package entidades;
// la llamo abstracta para poder implementar los métodos de la clase padre (Producto)
// a sus clases hijas (ConcCoccion y SinCoccion)
public abstract class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(){}

    public abstract double calcularPrecioVenta();
    // como cada clase hija calcula el total del pedido segun lo que sea, llamo a este método abstracto
    // genero polimorfismo con este método

    public double consultarPrecio(){
        return precio;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + " Precio: " + precio;
    }
}
